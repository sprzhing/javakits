/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.alibaba.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.phoenix.alibaba.PaymentRemoteService;
import com.baidu.phoenix.alibaba.PaymentService;
import com.baidu.phoenix.alibaba.bean.ConsultResult;
import com.baidu.phoenix.alibaba.enums.PaymentType;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * PaymentReactiveServiceImpl
 *
 * @author sprzhing
 * @date 2018/7/26:11:49
 * @description 多线程响应式远程过程调用
 */
@Service
public class PaymentReactiveServiceImpl implements PaymentService {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentReactiveServiceImpl.class);
    @Autowired
    private PaymentRemoteService remoteService;

    @Override
    public List<PaymentType> listAvailablePaymentTypes(Long ucId) {
        List<PaymentType> availableList = Lists.newArrayList();
        Map<PaymentType, CompletableFuture<ConsultResult>> futureMap = Maps.newHashMap();
        for (PaymentType type : PaymentType.values()) {
            CompletableFuture<ConsultResult> future = CompletableFuture.supplyAsync(() ->
                    remoteService.isEnabled(ucId, type.getValue())
            );
            futureMap.put(type, future);
        }
        int lenth = futureMap.size();
        CompletableFuture.allOf(futureMap.values().toArray(new CompletableFuture[lenth]))
                .whenComplete((v, th) -> {
                    for (Map.Entry<PaymentType, CompletableFuture<ConsultResult>> entry : futureMap.entrySet()){
                        try {
                            if(entry.getValue().get().getEnable()){
                                availableList.add(entry.getKey());
                            }
                        } catch (Exception e) {
                            LOG.error(e.getMessage());
                        }
                    } }).join();
        return availableList;
    }
}
