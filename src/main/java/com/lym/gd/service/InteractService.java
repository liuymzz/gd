package com.lym.gd.service;

import com.lym.gd.entity.User;
import com.lym.gd.enums.ClassEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author liuyaming
 * @date 2018/4/10 下午3:32
 */
@Service
public class InteractService {
    @Autowired
    private HttpSession httpSession;

    @Autowired
    private RedisService redisService;

    /**
     * 判断当前用户在当前会话中已存在课堂
     * 存在的依据：userId.sessionId在Redis中存在对应的键，并且值不为空或null
     *
     * @return 任意字符串，如果为空或者是null，则说明没有对应的课堂
     */
    public String existClass(){
        // 先获取登录用户
        User user = (User) httpSession.getAttribute("user");

        // 再获取sessionID
        String sessionId = httpSession.getId();

        return redisService.get(user.getUserId() + "." + sessionId);
    }

    /**
     * 当前用户在当前会话中已经存在课堂，则获取课堂的名字
     * @return 已存在课堂名称
     */
    public String getClassName(){
        // 先获取登录用户
        User user = (User) httpSession.getAttribute("user");

        // 再获取sessionID
        String sessionId = httpSession.getId();

        String key = user.getUserId() + "." + sessionId+".name";

        return redisService.get(key);
    }

    /**
     *
     *  新建课堂，
     *
     * @param name 课堂名称
     */
    public void startClass(String name){
        // 先获取登录用户
        User user = (User) httpSession.getAttribute("user");

        // 再获取sessionID
        String sessionId = httpSession.getId();

        // userId.sessionId = 1
        redisService.add(user.getUserId() + "." + sessionId,"1",ClassEnum.LIFE_TIME.getCode());

        // userId.sessionId.name = 课堂名称
        redisService.add(user.getUserId() + "." + sessionId + ".name",name,ClassEnum.LIFE_TIME.getCode());

    }


}
