package com.dream.freedom.behavior.strategy.second;

/**
 * 初级会员计费规则
 */
public class JuniorMember implements FeeService{
    @Override
    public Double compute(Double amount) {
        return 8.88;
    }

    @Override
    public Integer getType() {
        return MemberEnum.JUNIOR_MEMBER.getCode();
    }
}
