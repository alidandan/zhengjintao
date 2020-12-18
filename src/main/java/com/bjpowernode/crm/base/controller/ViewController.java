package com.bjpowernode.crm.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

/**
 * @ProjectName: crm999
 * @Package: com.bjpowernode.crm.base.controller
 * @Description: java类作用描述
 * @Author: 郑进滔
 * @CreateDate: 2020/12/18 14:59
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
@Controller
public class ViewController {


    @RequestMapping("/toView/{firstView}/{secondView}")
    String toView(
            @PathVariable(value = "firstView",required = false)String firstView,
            @PathVariable(value = "secondView",required = false)String secondView)
    {


        return File.separator+firstView+secondView;
    }
}
