package com.fuqi.threadlearn;

/**
 * @Description: 创建多线程的方式二：实现Runnable接口
 * 1. 创建一个实现了Runnable接口的类
 * 2. 实现类去实现Runnable中的抽象方法
 * 3. 创建实现类的对象
 * 4. 通过此对象调用start()
 *
 * @Author 傅琦
 * @Date 2019/6/12 19:20
 * @Version V1.0
 */
public class MyThread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class ThreadTest2 {
    public static void main(String[] args){
        MyThread2 myThread2 = new MyThread2();
        Thread thread1 = new Thread(myThread2);
        thread1.start();

        Thread thread2 = new Thread(myThread2);
        thread2.start();
    }
}


