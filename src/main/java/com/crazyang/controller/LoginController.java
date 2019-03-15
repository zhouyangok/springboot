package com.crazyang.controller;


import com.crazyang.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/** 登录
 * Created by tengj on 2017/4/10.
 */
@Controller
public class LoginController extends  AbstractController{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("ctx", getContextPath()+"/");
        return "login";
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public Map<String,Object> login(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("ctx",request.getContextPath());
        Map<String,Object> map =new HashMap<String,Object>();
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        if(!userName.equals("") && password!=""){
            User user =new User();
            user.setName(userName);
            user.setPassword(password);
            request.getSession().setAttribute("user",user);
            map.put("result","1");
        }else{
            map.put("result","0");
        }
        return map;
    }
}
