package com.fuqi.threadlearning.locklearn;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 使用Lock解决线程安全问题
 * @Author 傅琦
 * @Date 2019/6/14 20:58
 * @Version V1.0
 */
public class LockTest1 {
    public static void main(String[] args){
        Window window = new Window();

        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        Thread t3 = new Thread(window);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window implements Runnable{
    private int ticket = 100;

    /**
     * 使用Lock来解决线程安全问题
     * 1. 实例化一个ReentrantLock
     */
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {
                // 2. 调用lock()
                lock.lock();

                if (ticket > 0){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ": " + ticket);
                    ticket--;
                }else {
                    break;
                }
            }finally {
                //3. 释放锁，调用unlock()方法
                lock.unlock();
            }
        }
    }
}
