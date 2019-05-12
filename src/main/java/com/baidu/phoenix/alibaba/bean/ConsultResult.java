/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.phoenix.alibaba.bean;

/**
 * ConsultResult
 *
 * @author sprzhing
 * @date 2018/7/25
 * @description consult result bean
 */
public class ConsultResult {
    // 是否可用
    private Boolean isEnable;
    // 错误码
    private String errorCode;

    public ConsultResult(Boolean isEnable, String errorCode){
        this.isEnable = isEnable;
        this.errorCode = errorCode;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public String getErrorCode() {
        return errorCode;
    }
}