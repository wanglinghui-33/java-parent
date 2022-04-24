package com.dream.freedom.behavior.strategy.second;

/**
 * 会员枚举-- 用于维护会员类型(后期可以增加)
 */
public enum MemberEnum {

    ORDINARY_MEMBER(0, "普通会员"), JUNIOR_MEMBER(1, "初级会员"), INTERMEDIATE_MEMBER(2, "中级会员"), SENIOR_MEMBER(3, "高级会员"),
    ;

    private Integer code;
    private String name;

    MemberEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
