package com.baidu.phoenix.alibaba;

import com.baidu.phoenix.alibaba.bean.ConsultResult;

/**
 * PaymentRemoteService
 *
 * @author sprzhing
 * @date 2018/7/25
 * @description payment available query service
 */
public interface PaymentRemoteService {
    // 这是一个远程可被调用的接口
    ConsultResult isEnabled(Long ucId, String paymentType);
}