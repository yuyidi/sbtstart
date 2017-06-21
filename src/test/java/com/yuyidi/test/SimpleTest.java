package com.yuyidi.test;

import org.junit.Test;

import java.util.Arrays;

/**
* @author yuyidi 2017-06-19 10:41:46
* @class com.yuyidi.test.SimpleTest
* @description description
*/
public class SimpleTest {

    @Test
    public void testReflect(){
//        OrderParameter orderParameter = new WechatOrderParameter();
//        System.out.println(orderParameter.getClass());
    }

    @Test
    public void testCopyArray(){
        Comparable[] c = { 4, 9, 23, 1, 45, 27, 5, 2 };
        Comparable[] copyArray = {1};
        Comparable [] result = concat(c, copyArray);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }


    public <T> T[] concat(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
}
