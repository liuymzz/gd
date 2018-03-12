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
        User u = new User();
        u.setUserRole("2");
        u.setUserName("张三");
        u.setUserPhone("18888888888");
        u.setUserSignature("----------------------------");
        session.setAttribute("user",u);

        User user = (User) session.getAttribute("user");

        List<Resource> resourceList = resourceService.findResourcesByUser(user);

        model.addAttribute("resourceList", resourceList);
        return "user/index";
    }

}
