package com.lym.gd.service;

import com.alibaba.fastjson.JSONObject;
import com.lym.gd.entity.User;
import com.lym.gd.repository.UserRepository;
import com.lym.gd.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyaming
 * @date 2018/4/16 下午3:34
 */
@Service
public class IndexService {
    @Autowired
    private UserRepository userRepository;


    public User loginAction(JSONObject jsonObject) {
        return userRepository.findByUserPhoneAndUserPassword(
                jsonObject.getString("phone"),
                MD5Utils.MD5(jsonObject.getString("password"))
        );
    }
}
