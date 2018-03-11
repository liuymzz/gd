package com.lym.gd.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 资源（功能）
 *
 * @author liuyaming
 * @date 2018/3/11 下午5:44
 */
@Data
@Entity
public class Resource {

    @Id
    private String resourceId;

    private String resourcePath;

    private String resourceName;

    /**
     * 图标，实际就是layui图标代码
     */
    private String resourceIcon;

    /**
     * 可以使用该资源的角色🎭
     * 1:学生。2:老师。3:管理员
     */
    private String resourceRole;
}
