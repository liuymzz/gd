package com.lym.gd.DTO;

import lombok.Data;

/**
 * @author liuyaming
 * @date 2018/5/4 下午12:05
 */
@Data
public class AliSMSDTO {
    private String phoneNum;

    private String signName;

    private String templateCode;

    private String templateParam;
}
