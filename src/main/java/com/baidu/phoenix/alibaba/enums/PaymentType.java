/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.alibaba.enums;

public enum PaymentType {
    // 余额 红包 优惠券 代金券
    BALANCE("balance"), RED_ENVOLOPES("red_envolopes"),
    COUPONS("coupons"), VOUCHERS("vouchers");

    private String value;

    PaymentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
