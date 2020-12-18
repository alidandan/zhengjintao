package com.bjpowernode.crm.settings.controller;

import com.bjpowernode.crm.base.constants.CrmConstants;
import com.bjpowernode.crm.base.exception.CrmExctption;
import com.bjpowernode.crm.settings.bean.User;
import com.bjpowernode.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.settings.controller
 * @Description: java类作用描述
 * @Author: 王恒
 * @CreateDate: 2020/12/17 15:23
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
public class UserController {


    @Autowired
    private UserService userServiceImpl;

    @RequestMapping("login")
    String login(User user, Model model, HttpServletRequest request) {

        //获取ip地址一遍判断是否符合登入要求
        user.setAllowIps(request.getRemoteAddr());
        try {
            User user1 = userServiceImpl.login(user);
            //将用户信息存放到域空间当中，以便后面需要
            request.getSession().setAttribute(CrmConstants.LOGIN_USER, user1);
            //执行到这里说明用户是合法用户需要跳转到主页面
            return "index";

        } catch (CrmExctption e) {


            //将错误信息回显到登入界面
            model.addAttribute("mess", e.getMessage());


        }
        return "../../login";
    }

    String loginOut(HttpSession httpSession){
        httpSession.removeAttribute(CrmConstants.LOGIN_USER);

        return "../../login";
    }
}
