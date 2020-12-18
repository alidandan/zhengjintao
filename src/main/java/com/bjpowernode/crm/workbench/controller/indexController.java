package com.bjpowernode.crm.workbench.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

import javax.servlet.http.HttpSession;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.workbench.controller
 * @Description: java类作用描述
 * @Author: 王恒
 * @CreateDate: 2020/12/17 15:47
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
public class indexController {

    @RequestMapping("/index")
    ModelAndView index(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();

        //调用service
        modelAndView.setView(new InternalResourceView("/login.jsp"));
        //返回视图模型
        return modelAndView;
    }

}
