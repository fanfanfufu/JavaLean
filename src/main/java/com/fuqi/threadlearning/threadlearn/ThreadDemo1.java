package com.fuqi.threadlearning.threadlearn;

/**
 * @Description: 多线程实现方式一的练习
 * @Team 电子科技大学自动化研究所
 * @Author 傅琦
 * @Date 2019/6/12 16:17
 * @Version V1.0
 */
public class ThreadDemo1 {
    public static void main(String[] args){
        MyThread3 thread3 = new MyThread3();
        MyThread4 thread4 = new MyThread4();

        thread3.start();
        thread4.start();

        // 创建Thread类的匿名子类
//        new Thread(){
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    if (i % 2 == 0){
//                        System.out.println(Thread.currentThread().getName() + ": " + i);
//                    }
//                }
//            }
//        }.start();
//
//        new Thread(){
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    if (i % 2 == 1){
//                        System.out.println(Thread.currentThread().getName() + ": " + i);
//                    }
//                }
//            }
//        }.start();
    }
}

class MyThread3 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class MyThread4 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
