package com.lym.gd;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;


/**
 * @author liuyaming
 * @date 2018/5/4 上午9:12
 */
public class other {

    @Test
    public void test(){

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.plusDays(1).toString());

    }


}
