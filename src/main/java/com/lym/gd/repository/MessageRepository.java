package com.lym.gd.repository;

import com.lym.gd.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author liuyaming
 * @date 2018/3/11 下午6:25
 */
public interface MessageRepository extends JpaRepository<Message,String>{
}
