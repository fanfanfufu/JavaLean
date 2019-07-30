package com.fuqi.threadlearning.threadlocallearn;

/**
 * @Description: threadLocal学习示例一
 * @Author: 傅琦
 * @DateTime: 2019/7/30 22:39
 * @Version: V1.0
 */
public class ThreadLocalExample {
    public static class MyRunnable implements Runnable {
        private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        @Override
        public void run() {
            threadLocal.set((int) (Math.random() * 100D));

            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){

            }

            System.out.println(threadLocal.get());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
