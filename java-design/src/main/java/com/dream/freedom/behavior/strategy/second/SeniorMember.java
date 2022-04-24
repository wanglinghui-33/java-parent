package com.dream.freedom.behavior.strategy.second;

/**
 * 高级会员计费规则
 */
public class SeniorMember implements FeeService {
    @Override
    public Double compute(Double amount) {
        return 6.66;
    }

    @Override
    public Integer getType() {
        return MemberEnum.SENIOR_MEMBER.getCode();
    }
}
