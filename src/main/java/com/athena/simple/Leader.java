package com.athena.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiaoxiang.zhang
 * @Description:委派模式-负责人
 * @Date: Create in 6:55 PM 2019/11/28
 */
public class Leader {

    private static final Map<String, IEmployee> register = new HashMap<String, IEmployee>();

    public Leader() {
        register.put("算法", new EmployeeA());
        register.put("架构", new EmployeeB());
    }

    /*
     * @Author xiangxz
     * @Description 分配工作
     * @Date 6:58 PM 2019/11/28
     * @Param
     * @return
     **/

    public void divideWork(String commond) {
        register.get(commond).doWork(commond);
    }
}
