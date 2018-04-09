package com.lym.gd.handler;

import com.lym.gd.utils.ResultVOUtil;
import com.lym.gd.vo.ResultVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * 全局异常处理类
 *
 * @author liuyaming
 * @date 2018/4/9 上午9:47
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Throwable.class)
    public ResultVO unknownException(Exception e) throws Exception{
        e.printStackTrace();

        return ResultVOUtil.error("系统错误，请联系管理员");
    }


}
