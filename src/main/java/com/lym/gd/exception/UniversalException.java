package com.lym.gd.exception;

import com.lym.gd.enums.ResultEnum;


/**
 * @author liuyaming
 * @date 2018/3/12 下午8:27
 */
public class UniversalException extends RuntimeException {
    private Integer code;

    public UniversalException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code= resultEnum.getCode();
    }

    public UniversalException(Integer code,String message){
        super(message);
        this.code=code;
    }

}
