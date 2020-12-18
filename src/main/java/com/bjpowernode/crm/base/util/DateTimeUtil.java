package com.bjpowernode.crm.base.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.base.util
 * @Description: java类作用描述
 * 用来验证输入的时间是否符合登入时间
 * @Author: 王恒
 * @CreateDate: 2020/12/17 17:06
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public class DateTimeUtil {

    public Integer compareDate(String date) {

        //设计时间格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取当前时间
        Date date1 = new Date();
        //将时间转换成字符串格式
        String format = simpleDateFormat.format(date1);
        //比较数据库时间和系统时间
        int i = format.compareTo(date);

        //将比较结果输出
        return i;

    }
}
