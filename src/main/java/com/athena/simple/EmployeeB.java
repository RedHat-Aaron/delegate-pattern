package com.athena.simple;

/**
 * @Author: xiaoxiang.zhang
 * @Description:委派模式-员工B
 * @Date: Create in 6:57 PM 2019/11/28
 */
public class EmployeeB implements IEmployee {
    public void doWork(String commond) {
        System.out.println("我是员工B，我擅长架构！开始执行：" + commond);
    }
}
