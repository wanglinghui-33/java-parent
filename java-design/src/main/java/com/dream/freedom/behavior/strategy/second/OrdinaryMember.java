package com.dream.freedom.behavior.strategy.second;

/**
 * 普通会员实现计费规则
 */
public class OrdinaryMember implements FeeService {
    @Override
    public Double compute(Double amount) {
        // 这里就是要处理的业务
        return 9.99;
    }

    @Override
    public Integer getType() {
        return MemberEnum.ORDINARY_MEMBER.getCode();
    }
}
