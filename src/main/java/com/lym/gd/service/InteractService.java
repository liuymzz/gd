package com.lym.gd.service;

import com.lym.gd.entity.User;
import com.lym.gd.enums.ClassEnum;
import com.lym.gd.utils.IdUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Set;

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
        return redisService.get(IdUtils.getUserAndSessionId(httpSession));
    }

    /**
     * 当前用户在当前会话中已经存在课堂，则获取课堂的名字
     * @return 已存在课堂名称
     */
    public String getClassName(){
        return redisService.get(IdUtils.getUserAndSessionIdAndName(httpSession));
    }

    /**
     *
     *  新建课堂，
     *
     * @param name 课堂名称
     */
    public void startClass(String name){
        String userAndSessionID = IdUtils.getUserAndSessionId(httpSession);
        String userSessionName = IdUtils.getUserAndSessionIdAndName(httpSession);

        // 创建之前需先查看是否已有课堂，如已有，则删除

        // 通过userId.sessionId查看
        String userAndSessionIDValue =  redisService.get(userAndSessionID);

        if (StringUtils.isNotEmpty(userAndSessionIDValue)){
            // 如果存在对应的键值对，则删除所有该课堂相关内容
            redisService.remove(userAndSessionID);
            redisService.deleteByPrefix(userAndSessionID);
        }




        // userId.sessionId = 1
        redisService.add(userAndSessionID,"1",ClassEnum.LIFE_TIME.getCode());

        // userId.sessionId.name = 课堂名称
        redisService.add(userSessionName,name,ClassEnum.LIFE_TIME.getCode());

    }

    /**
     * 获取当前用户当前会话中已存在课堂的所有talks
     * @return map
     */
    public Map<String,String> getTalks(){
        String userAndSessionIdAndDot = IdUtils.getUserAndSessionId(httpSession) + "##";

        return redisService.getByPrefix(userAndSessionIdAndDot);
    }

    /**
     * 删除指定键值对
     * @param id
     */
    public void delTalk(String id){
        redisService.remove(id);
    }

    /**
     * 删除该课堂下所有talks
     */
    public void delTalks(){
        String userAndSessionIdDot = IdUtils.getUserAndSessionId(httpSession) + "##";

        Set<String> keys = redisService.getKeysByPrefix(userAndSessionIdDot);

        keys.remove(userAndSessionIdDot + "name");

        keys.forEach(key -> redisService.remove(key));
    }

}
