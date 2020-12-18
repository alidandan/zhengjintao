package com.bjpowernode.crm.base.exception;

import com.bjpowernode.crm.base.constants.CrmExceptionEnum;


/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.base.exception
 * @Description: java类作用描述
 *               自定义的异常类
 * @Author: 王恒
 * @CreateDate: 2020/12/17 16:00
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public class CrmExctption extends RuntimeException {

    //构造方法
    public CrmExctption(CrmExceptionEnum crmExceptionEnum) {
        //调用父类有参的构造方法将信息上传到父类以便后面打印堆栈信息
        super(crmExceptionEnum.getMess());
    }

}
