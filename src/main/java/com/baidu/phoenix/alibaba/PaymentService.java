/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.alibaba;

import java.util.List;

import com.baidu.phoenix.alibaba.enums.PaymentType;

/**
 * PaymentService
 *
 * @author sprzhing
 * @date 2018/7/25
 * @description 支付服务
 */
public interface PaymentService {
    List<PaymentType> listAvailablePaymentTypes(Long ucId);
}