package com.dream.freedom.behavior.strategy.second;


/**
 * 策略接口
 */
public interface FeeService {


    /**
     * 计费规则
     * @param amount 会员的交易金额
     * @return
     */
    Double compute(Double amount);

    /**
     * 获取会员级别
     * @return
     */
    Integer getType();

}
