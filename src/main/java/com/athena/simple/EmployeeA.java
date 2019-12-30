package com.athena.simple;

/**
 * @Author: xiaoxiang.zhang
 * @Description:委派模式-员工a
 * @Date: Create in 6:56 PM 2019/11/28
 */
public class EmployeeA implements IEmployee {


    public void doWork(String commond) {
        System.out.println("我是员工A,我擅长算法！开始执行：" + commond);
    }
}
