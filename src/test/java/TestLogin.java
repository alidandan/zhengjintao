import com.bjpowernode.crm.base.constants.CrmExceptionEnum;
import com.bjpowernode.crm.base.exception.CrmExctption;
import com.bjpowernode.crm.base.util.MD5Util;
import org.junit.Test;

import java.util.UUID;

/**
 * @ProjectName: crm
 * @Package: PACKAGE_NAME
 * @Description: java类作用描述
 * @Author: 王恒
 * @CreateDate: 2020/12/17 16:35
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public class TestLogin {

    @Test
    public void Test01() {
        int i = 0;
        try {
            if (i == 0) {
                throw new CrmExctption(CrmExceptionEnum.LOGIN_ACCOUNT_EXCEPTION);
            }
        } catch (CrmExctption e) {
            System.out.println(e.getMessage());
        }


    }

    //生成32位uuid
    String getUUID32() {

        return UUID.randomUUID().toString().replace("-", "").toLowerCase();

    }

    @Test
    public void Test02() {

        /*Integer integer = new DateTimeUtil().compareDate("2011-12-20 00:00:00");
        System.out.println(integer);*/
       /* String s = "1";
        System.out.println("".equals(s));*/

        String uuid32 = getUUID32();
        System.out.println(uuid32);


    }


    @Test
    public void test03() {
        String admin = MD5Util.getMd5("admin");
        System.out.println(admin);

    }
}
