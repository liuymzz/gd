package com.lym.gd.enums;

import lombok.Getter;

/**
 * @author liuyaming
 * @date 2018/3/12 下午8:30
 */
@Getter
public class ResultEnum {

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
