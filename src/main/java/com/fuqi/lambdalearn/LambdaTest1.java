package com.fuqi.lambdalearn;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/6/27 14:23
 * @Version V1.0
 */
public class LambdaTest1 {
    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello, world!");
            }
        };

        r1.run();

        System.out.println("******************************");

        Runnable r2 = () -> System.out.println("你好，世界。");

        r2.run();
    }

    @Test
    public void test2(){
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return Integer.compare(t1, t2);
            }
        };

        int com1 = comparator1.compare(12,21);
        System.out.println("com1 = " + com1);

        System.out.println("******************************");

        // lambda表达式的写法
        Comparator<Integer> comparator2 = (i1, i2) -> Integer.compare(i1, i2);
        int com2 = comparator2.compare(32, 21);
        System.out.println("com2 = " + com2);
        System.out.println("******************************");

        // 方法引用
        Comparator<Integer> comparator3 = Integer :: compare;
        int com3 = comparator3.compare(22, 22);
        System.out.println("com3 = " + com3);
        System.out.println("******************************");
    }
}
