package com.lym.gd.controller;

import com.alibaba.fastjson.JSONObject;
import com.lym.gd.service.InteractService;
import com.lym.gd.utils.ResultVOUtil;
import com.lym.gd.vo.ResultVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuyaming
 * @date 2018/4/10 下午3:32
 */
@Controller
public class InteractController {
    @Autowired
    private InteractService interactService;

    @GetMapping("/interact")
    public String interactView(String name, Model model){

        model.addAttribute("className",name);

        return "other/interact";
    }


    /**
     * 判断是否存在课堂
     * @return
     */
    @GetMapping("/existClass")
    @ResponseBody
    public ResultVO existClass(){
        ResultVO resultVO = ResultVOUtil.success();
        Map<String,String> map = new HashMap<>();

        String value = interactService.existClass();

        String name = null;
        if (StringUtils.isNotEmpty(value)){
            name = interactService.getClassName();
        }

        map.put("name",name);

        resultVO.setData(map);

        return resultVO;
    }

    /**
     * 创建课堂（Redis中添加标识）
     * @param jsonObject
     * @return
     */
    @PostMapping("/startClass")
    @ResponseBody
    public ResultVO startClass(@RequestBody JSONObject jsonObject){
        ResultVO resultVO = ResultVOUtil.success();

        interactService.startClass(jsonObject.getString("name"));

        return resultVO;
    }


}
