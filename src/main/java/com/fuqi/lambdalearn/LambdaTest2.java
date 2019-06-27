package com.fuqi.lambdalearn;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @Description: Lambda表达式的使用练习
 *
 * 1. 举例：(i1, i2) -> Integer.compare(i1, i2);
 * 2. 格式：
 *      ->: lambda的操作符 或 箭头操作符
 *      ->左边: lambda形参列表 （接口中的抽象方法的形参列表）
 *      ->右边: lambda体 (重写的抽象方法的方法体)
 * 3. Lambda表达式的额使用：6种情况
 *
 * 4. Java种Lambda表达式的本质：左边接口的对象
 *
 * @Author 傅琦
 * @date 2019/6/27 14:41
 * @Version V1.0
 */
public class LambdaTest2 {
    /**
     * 语法格式一：无参无返回值
     */
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

        Runnable r2 = () -> {
            System.out.println("你好，世界。");
        };
        r2.run();
    }

    /**
     * 语法格式二：Lambda需要一个参数，但是没有返回值
     */
    @Test
    public void test2(){
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer1.accept("一句话");

        System.out.println("******************************");

        Consumer<String> consumer2 = (String s) -> {
            System.out.println("s = " + s);
        };
        consumer2.accept("第二句话");
    }

    /**
     * 语法格式三：数据类型可以省略，可由编译器推断得出，称为类型推断
     */
    @Test
    public void test3(){
        Consumer<String> consumer1 = (String s) -> {
            System.out.println("s = " + s);
        };
        consumer1.accept("方法三第一句话");
        System.out.println("******************************");

        Consumer<String> consumer2 = (s) -> {
            System.out.println("s = " + s);
        };
        consumer2.accept("方法三第二句话");
        System.out.println("******************************");
    }

    /**
     * 语法格式四：Lambda只需要一个参数时，参数的小括号也可以省略
     */
    @Test
    public void test4(){
        Consumer<String> consumer1 = (s) -> {
            System.out.println("s = " + s);
        };
        consumer1.accept("方式四第一句话");
        System.out.println("******************************");

        Consumer<String> consumer2 = s -> {
            System.out.println("s = " + s);
        };
        consumer2.accept("方式四第二句话");
        System.out.println("******************************");
    }

    /**
     * 语法格式五：Lambda需要两个或以上的参数，多条执行语句，并且可以由返回值时
     */
    @Test
    public void test5(){
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                System.out.println("t1 = " + t1);
                System.out.println("t2 = " + t2);
                return Integer.compare(t1, t2);
            }
        };
        int res1 = comparator1.compare(12,21);
        System.out.println("res1 = " + res1);
        System.out.println("******************************");

        Comparator<Integer> comparator2 = (i1, i2) -> {
            System.out.println("i1 = " + i1);
            System.out.println("i2 = " + i2);
            return i1.compareTo(i2);
        };
        int res2 = comparator2.compare(12, 6);
        System.out.println("res2 = " + res2);
        System.out.println("******************************");
    }

    /**
     * 语法格式六：当Lambda体只有一条语句时，return与大括号可以省略
     */
    @Test
    public void test7(){
        Comparator<Integer> comparator1 = (i1, i2) -> {
            return i1.compareTo(i2);
        };
        int res1 = comparator1.compare(12, 6);
        System.out.println("res1 = " + res1);
        System.out.println("******************************");

        Comparator<Integer> comparator2 = (i1, i2) -> i1.compareTo(i2);
        System.out.println("res2 = " + comparator2.compare(12, 21));
    }
}
