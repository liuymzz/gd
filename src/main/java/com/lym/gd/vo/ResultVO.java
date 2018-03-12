package com.lym.gd.vo;

import lombok.Data;

/**
 * @author liuyaming
 * @date 2018/3/12 下午8:06
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String message;

    private T data;

}
