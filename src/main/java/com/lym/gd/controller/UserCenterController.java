package com.lym.gd.controller;

import com.lym.gd.entity.Resource;
import com.lym.gd.entity.User;
import com.lym.gd.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author liuyaming
 * @date 2018/3/11 下午9:21
 */
@Controller
public class UserCenterController {

    private final ResourceService resourceService;

    @Autowired
    public UserCenterController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping("/")
    public String index(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
    System.out.println("首页");
        List<Resource> resourceList = resourceService.findResourcesByUser(user);

        model.addAttribute("resourceList", resourceList);
        return "user/index";
    }

}
