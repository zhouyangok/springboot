package com.crazyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName IndexController
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/2/28 上午11:26.
 */
@Controller
public class IndexController  extends  AbstractController{

    @RequestMapping("/main")
    public String main(Model model){
        model.addAttribute("ctx", getContextPath()+"/");
        return "main";
    }

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("ctx", getContextPath()+"/");
        return "index";
    }

    @RequestMapping("")
    public String index1(Model model){
        model.addAttribute("ctx", getContextPath()+"/");
        return "index";
    }
}
