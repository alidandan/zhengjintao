package com.bjpowernode.crm.settings.service.impl;

import com.bjpowernode.crm.base.constants.CrmExceptionEnum;
import com.bjpowernode.crm.base.exception.CrmExctption;
import com.bjpowernode.crm.base.util.DateTimeUtil;
import com.bjpowernode.crm.base.util.MD5Util;
import com.bjpowernode.crm.settings.bean.User;
import com.bjpowernode.crm.settings.mapper.UserMapper;
import com.bjpowernode.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.settings.service.impl
 * @Description: java类作用描述
 * @Author: 王恒
 * @CreateDate: 2020/12/17 15:24
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        //将密码加密传入
        user.setLoginPwd(MD5Util.getMd5(user.getLoginPwd()));
        //获取contronller中传过来的ip地址
        String allowIps = user.getAllowIps();
        //将ip地址从查询对象中滞空，否则会带ip参数查询登入信息，
        user.setAllowIps(null);


        user = userMapper.selectOne(user);
        if (user == null) {
            //用户名和密码正确
            throw new CrmExctption(CrmExceptionEnum.LOGIN_ACCOUNT_EXCEPTION);
        } else {
            //进入else说明用户姓名和密码是正确的但是还要进一步验证其他信息
            //获取数据库查询出来的有效期时间 user.getCreateTime()
            //调用数据库时间和系统时间比较的方法new DateTimeUtil().compareDate
            /*
            如果两个日期字符串比较大小，使用compareTo方法进行比较 t1 t2
            如果返回值<0 t1 < t2
            返回值=0 t1 == t2
            返回值>0 t1 > t2
            系统时间要比数据库查出来的有效期要小说明该用户可以登入
            */
            //验证登入时间是否符合要求
            if (user.getExpireTime() != null && "".equals(user.getExpireTime())) {
                if (new DateTimeUtil().compareDate(user.getExpireTime()) > 0) {
                    //说明该用户不符合要求，不可以登入返回一个异常
                    throw new CrmExctption(CrmExceptionEnum.LOGIN_TIME_EXCEPTION);
                }
            }

            //验证账户是否是失效的
            if ("0".equals(user.getLockState())) {
                //如果是0 说明账户被锁定，抛出一个异常
                throw new CrmExctption(CrmExceptionEnum.LOGIN_LOCKSTATE_EXCEPTION);
            }

            //检查ip地址是否合法,将获取的ip地址和数据库中的数据比对
            if (user.getAllowIps() != null && !"".equals(user.getAllowIps())) {
                if (!user.getAllowIps().contains(allowIps)) {
                    throw new CrmExctption(CrmExceptionEnum.LOGIN_IP_EXCEPTION);
                }
            }
        }

        return user;
    }
}
