package com.bjpowernode.crm.settings.service;

import com.bjpowernode.crm.settings.bean.User;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.settings.service
 * @Description: java类作用描述
 * @Author: 王恒
 * @CreateDate: 2020/12/17 15:23
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public interface UserService {
    User login(User user);
}
