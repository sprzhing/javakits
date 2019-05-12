/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.alibaba.impl;

import java.util.List;

import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.phoenix.alibaba.PaymentRemoteService;
import com.baidu.phoenix.alibaba.PaymentService;
import com.baidu.phoenix.alibaba.bean.ConsultResult;
import com.baidu.phoenix.alibaba.enums.PaymentType;
import com.google.common.collect.Lists;

/**
 * PaymentServiceImpl
 *
 * @author sprzhing
 * @date 2018/7/25
 * @description 同步版本，如果业务上可以用，优先用这个版本，否则可以使用 PaymentAsynServiceImpl
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    // 失败重试一次
    private static final int RETRY_TIMES = 2;
    private static final Logger LOG = LoggerFactory.getLogger(PaymentServiceImpl.class);
    @Autowired
    private PaymentRemoteService remoteService;

    @Override
    public List<PaymentType> listAvailablePaymentTypes(Long ucId) {
        Validate.notNull(ucId);
        List<PaymentType> availableList = Lists.newArrayList();
        for (PaymentType type : PaymentType.values()) {
            if (isAvailable(ucId, type)) {
                availableList.add(type);
            }
        }
        return availableList;
    }

    private Boolean isAvailable(Long ucId, PaymentType type){
        int retryTimes = 0;
        Exception e = null;
        while (retryTimes < RETRY_TIMES) {
            try {
                ConsultResult result = remoteService.isEnabled(ucId, type.getValue());
                return result.getEnable();
            } catch (Exception ex) {
                LOG.error("faild to consult payment remote service. ", ex);
                e = ex;
                retryTimes++;
            }
        }
        throw new RuntimeException(e);
    }
}