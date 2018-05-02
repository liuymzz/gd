package com.lym.gd.enums;

import lombok.Getter;


/**
 * @author liuyaming
 * @date 2018/5/2 下午3:05
 */
@Getter
public enum  StudentWorkEnum {
    NOT_READ("1","未阅"),
    READE("2","已阅")
    ;


    private String code;
    private String message;

    StudentWorkEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
