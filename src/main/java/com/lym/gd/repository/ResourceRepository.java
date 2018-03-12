package com.lym.gd.repository;

import com.lym.gd.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author liuyaming
 * @date 2018/3/11 下午5:48
 */
public interface ResourceRepository extends JpaRepository<Resource,String> {

    /**
     * 根据权限获取对应的资源
     *
     * @param role
     * @return
     */
    public List<Resource> findResourcesByResourceRole(String role);
}
