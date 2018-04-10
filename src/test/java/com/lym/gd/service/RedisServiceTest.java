package com.lym.gd.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author liuyaming
 * @date 2018/4/10 下午2:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceTest {

  @Autowired
  private RedisService redisService;

  @Test
  public void add() {
    redisService.add("a.b.c","d",-1);
    redisService.add("a.b.c1","d",1000);
    redisService.add("a.b.c2","d",1000);
    redisService.add("a.b.c3","d",1000);
    redisService.add("a.b.c4","d",1000);
  }

  @Test
  public void get() {
    System.out.println(redisService.get("a.b.c"));
  }

  @Test
  public void setNoTime(){
    redisService.setNoTime("a.a.a","a");
  }
}