package com.lym.gd.controller;

import com.lym.gd.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author liuyaming
 * @date 2018/3/12 下午11:20
 */
@Controller
public class IndexController {

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
  public String loginAction(HttpSession session) {

    User user =
        new User.Builder()
            .userCreateDate(new Date())
            .userGrade("2014")
            .userIcon("http://img1.imgtn.bdimg.com/it/u=1508724254,438702305&fm=11&gp=0.jpg")
            .userName("jack")
            .userPhone("188888888888")
            // 先创建一个老师角色
            .userRole("2")
            .major("computer")
            .userSex("1")
            .userSignature("123123123123123123.....")
            .userUpdateDate(new Date())
            .build();

    session.setAttribute("user", user);

    return "redirect:/";
  }
}
