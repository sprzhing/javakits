/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.alibaba.impl;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.baidu.phoenix.alibaba.PaymentRemoteService;
import com.baidu.phoenix.alibaba.PaymentService;
import com.baidu.phoenix.alibaba.bean.ConsultResult;
import com.baidu.phoenix.alibaba.enums.PaymentType;
import com.google.common.collect.Lists;

/**
 * PaymentAsynServiceImpl
 *
 * @author sprzhing
 * @date 2018/7/25
 * @description 考虑到业务上同一用户的可用付款状态变更并不频繁（通常在用户付款操作时才回变更，可以在付款时刷缓存）
 * 也可以考虑异步缓存可用列表，可以更快速这里的缓存可以用 redis 或者 ConcurrentMap 配合定时器来刷新，
 * 这里为了简单直接使用Spring 的 annotation配合 ConcurrentMap,也可以使用 Timer 等
 */
@Service
public class PaymentAsynServiceImpl implements PaymentService {
    @Autowired
    private PaymentRemoteService remoteService;
    // 缓存, 定时刷新 + 付款状态变更时刷新
    private static ConcurrentMap<String, Boolean> availableMap = new ConcurrentHashMap<>();

    @Override
    public List<PaymentType> listAvailablePaymentTypes(Long ucId) {
        Validate.notNull(ucId);
        List<PaymentType> availableList = Lists.newArrayList();
        if (0 == availableMap.size()) {
            // 启动后先刷新一次
            flush(ucId);
        }
        for (PaymentType type : PaymentType.values()) {
            String key = ucId + type.getValue();
            if (availableMap.get(key)) {
                availableList.add(type);
            }
        }
        return availableList;
    }

    // 每 5分钟刷新一次，时间可根据并发情况调节
    @Scheduled(fixedRate = 300000)
    public void flush(Long ucId) {
        final int RETRY_TIMES = 2;
        for (PaymentType type : PaymentType.values()) {
            int times = 0;
            while (times < RETRY_TIMES) {
                try {
                    ConsultResult result = remoteService.isEnabled(ucId, type.getValue());
                    availableMap.put(ucId + type.getValue(), result.getEnable());
                } catch (Exception ex) {
                    times++;
                    // 这里多次失败，最好邮件通知，防止外部服务PaymentRemoteService挂了无法感知
                }
            }
        }
    }
}