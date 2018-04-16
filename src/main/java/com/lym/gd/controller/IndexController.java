package com.lym.gd.controller;

import com.alibaba.fastjson.JSONObject;
import com.lym.gd.entity.User;
import com.lym.gd.service.IndexService;
import com.lym.gd.utils.MD5Utils;
import com.lym.gd.utils.ResultVOUtil;
import com.lym.gd.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author liuyaming
 * @date 2018/3/12 下午11:20
 */
@Controller
public class IndexController {

  @Autowired
  private IndexService indexService;

  @GetMapping("/logout")
  public String logout(HttpSession session) {
    session.removeAttribute("user");
    System.out.println("logout");
    return "redirect:/";
  }

  @GetMapping("/login")
  public String login() {

    return "user/login";
  }

  @PostMapping("/loginAction")
  @ResponseBody
  public ResultVO loginAction(@RequestBody JSONObject jsonObject, HttpSession session) {
    ResultVO resultVO = ResultVOUtil.success();

    User user = indexService.loginAction(jsonObject);

    if (user == null) {
      resultVO = ResultVOUtil.error("登录失败，请检查账号密码");
    } else {
      session.setAttribute("user", user);
    }


    return resultVO;
  }
}
