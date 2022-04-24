package com.dream.freedom.enumeration;

import lombok.Getter;

/**
 * 会员级别的枚举类型
 */
@Getter
public enum MemberLevel {


    JUNIOR_MEMBER(1, "初级会员"), INTERMEDIATE_MEMBER(2, "中级会员"), SENIOR_MEMBER(3, "高级会员"),
    ;

    private Integer type;

    private String name;

    MemberLevel(Integer type, String name) {
        this.type = type;
        this.name = name;
    }
}
