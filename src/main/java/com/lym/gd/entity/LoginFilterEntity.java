package com.lym.gd.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author liuyaming
 * @date 2018/3/14 下午8:40
 */
@Entity
@Data
public class LoginFilterEntity {
    @Id
    private String loginFilterId;

    private String loginFilterPath;

}
