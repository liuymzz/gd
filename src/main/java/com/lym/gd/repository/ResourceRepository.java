package com.lym.gd.repository;

import com.lym.gd.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author liuyaming
 * @date 2018/3/11 下午5:48
 */
public interface ResourceRepository extends JpaRepository<Resource,String> {
}
