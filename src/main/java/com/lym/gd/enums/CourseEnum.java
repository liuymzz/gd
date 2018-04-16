package com.lym.gd.enums;

import lombok.Getter;

/**
 * @author liuyaming
 * @date 2018/4/16 下午1:23
 */
@Getter
public enum  CourseEnum {
    No_START("1","未开始"),
    STARTING("2","进行中"),
    END("3","已结束")
    ;

    private String status;
    private String message;

    CourseEnum(String status,String message){
        this.status = status;
        this.message = message;
    }
}
