package com.athena.simple;

/**
 * @Author: xiaoxiang.zhang
 * @Description:委派模式-老板
 * @Date: Create in 6:55 PM 2019/11/28
 */
public class Boss {

    public void command(String commond, Leader leader) {
        leader.divideWork(commond );
    }
}
