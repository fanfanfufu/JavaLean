package com.fuqi.threadlearning.deadlocklearn;

/**
 * @Description: 演示线程的死锁问题
 *               出现死锁后，不会出现异常，不会出现提示，只是所有的线程都处于阻塞状态，无法继续。
 * @Author 傅琦
 * @Date 2019/6/14 16:48
 * @Version V1.0
 */
public class DeadLockTest1 {
    public static void main(String[] args){
        final StringBuffer sb1 = new StringBuffer();
        final StringBuffer sb2 = new StringBuffer();

        new Thread(){
            @Override
            public void run() {
                synchronized (sb1){
                    sb1.append("a");
                    sb2.append("1");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (sb2){
                        sb1.append("b");
                        sb2.append("2");

                        System.out.println(sb1);
                        System.out.println(sb2);
                    }
                }
            }
        }.start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                synchronized (sb2){
                    sb1.append("c");
                    sb2.append("3");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (sb1){
                        sb1.append("d");
                        sb2.append("4");

                        System.out.println(sb1);
                        System.out.println(sb2);
                    }
                }
            }
        }).start();
    }
}
