package com.fuqi.threadlearning.threadlearn;

/**
 * @Description: 多线程的创建方式一：
 *
 * 1. 创建一个继承于Thread类的子类
 * 2. 重写Thread累的run()方法
 * 3. 创建Thread类的子类的对象
 * 4. 通过此对象调用start()方法
 *
 * @Author 傅琦
 * @Date 2019/6/12 15:54
 * @Version V1.0
 */
public class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}

class MyThreadTest{
    public static void main(String[] args){
        MyThread1 t1 = new MyThread1();

        // 调用start()方法：
        // 作用1：启动t1线程
        // 作用2：调用t1线程的run()
        t1.start();

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1){
                System.out.println(i);
            }
        }
    }
}
