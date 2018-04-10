package com.lym.gd.enums;

import lombok.Getter;

/**
 *
 * 主要用来定义跟课堂有关的值
 *
 * @author liuyaming
 * @date 2018/4/10 下午4:23
 */
@Getter
public enum ClassEnum {
    LIFE_TIME(60*24,"会话过期时间");

    private Integer code;
    private String message;

    ClassEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
