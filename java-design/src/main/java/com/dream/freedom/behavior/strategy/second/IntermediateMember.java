package com.dream.freedom.behavior.strategy.second;

/**
 * 中级会员计费规则
 */
public class IntermediateMember implements FeeService {
    @Override
    public Double compute(Double amount) {
        // 编写具体的业务
        return 7.77;
    }

    @Override
    public Integer getType() {
        return MemberEnum.INTERMEDIATE_MEMBER.getCode();
    }
}
