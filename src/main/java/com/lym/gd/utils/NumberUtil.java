package com.lym.gd.utils;

import java.util.Random;

/**
 * 数字工具类
 *
 * @author liuyaming
 * @date 2018/3/15 下午10:59
 */
public class NumberUtil {

    private static Random random = new Random();

    /**
     * 0～N之间的数
     *
     * @param value 指定的位数
     * @return 一个数
     */
    public static int randomNumber(int value){
        return random.nextInt(value);
    }


}
