package com.athena.simple;

/**
 * @Author: xiaoxiang.zhang
 * @Description:
 * @Date: Create in 7:18 PM 2019/11/28
 */
public class DelegateTest {
    public static void main(String[] args) {
        new Boss().command("算法", new Leader());
    }
}
