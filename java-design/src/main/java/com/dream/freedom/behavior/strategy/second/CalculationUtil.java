package com.dream.freedom.behavior.strategy.second;

/**
 * 这个案例采用了---策略模式、工厂模式、单利模式
 */
public class CalculationUtil {

    public static Double getFee(Integer type, Double money) {
        FeeService feeService =  FeeServiceFactory.getInstance().getFee(type);
        if (null == feeService){
            throw new IllegalArgumentException("type is not exist");
        }
        return feeService.compute(money);
    }

}
