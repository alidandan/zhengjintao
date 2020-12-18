package com.bjpowernode.crm.base.constants;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.base.constants
 * @Description: java类作用描述
 * 指定义枚举类用来写错误信息
 * @Author: 王恒
 * @CreateDate: 2020/12/17 16:02
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public enum CrmExceptionEnum {
    LOGIN_ACCOUNT_EXCEPTION("001", "用户名或密码错误！"),
    LOGIN_TIME_EXCEPTION("001", "你的账户已过有效期"),
    LOGIN_LOCKSTATE_EXCEPTION("001", "你的账户已经被锁定，请联系管理员"),
    LOGIN_IP_EXCEPTION("001", "请使用指定的ip地址登入");


    private String code;//业务状态码，因为项目复杂的时候，需要把业务细分
    private String mess;//表示业务错误信息

    //添加有产构造方法
    CrmExceptionEnum(String code, String mess) {
        this.code = code;
        this.mess = mess;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
