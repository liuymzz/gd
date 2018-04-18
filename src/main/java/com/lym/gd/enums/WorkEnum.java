package com.lym.gd.enums;

import lombok.Getter;

/**
 * @author liuyaming
 * @date 2018/4/18 下午5:44
 */
@Getter
public enum WorkEnum {

    NOT_READ("1","未阅"),
    READED("2","已阅")
    ;

    private String code;
    private String message;

    WorkEnum(String code,String message){
        this.code = code;
        this.message = message;
    }

}
