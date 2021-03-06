package com.crazyang.controller;


import com.crazyang.common.utils.MD5Utils;
import com.crazyang.entity.User;
import com.crazyang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LoginController
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/2/27 上午11:26.
 */
@Controller
public class LoginController extends AbstractController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("ctx", getContextPath() + "/");
        return "login";
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("ctx", request.getContextPath());
        Map<String, Object> map = new HashMap<String, Object>();

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if (!userName.equals("") && password != "") {
            User dataUser = userService.findByName(userName);
            if (dataUser != null) {
                if (dataUser.getPassword().equals(MD5Utils.getResult(password))) {
                    request.getSession().setAttribute("user", dataUser);
                    map.put("result", "1");
                } else {
                    map.put("result", "0");
                }
            } else {
                map.put("result", "0");
            }
        } else {
            map.put("result", "0");
        }
        return map;
    }
}
