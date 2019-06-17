package com.fuqi.threadlearning.threadlearn;

/**
 * @Description: 使用同步方法的方式解决Runnable接口实现下的线程安全问题
 * @Author 傅琦
 * @Date 2019/6/14 14:55
 * @Version V1.0
 */
public class SafeWindow3 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (true){
            show();
            if (ticket == 0){
                break;
            }
        }
    }

    private synchronized void show(){
        if (ticket > 0){
            System.out.println(Thread.currentThread().getName() + ": " + ticket);
            ticket--;
        }
    }
}

class SafeWindowTest3{
    public static void main(String[] args){
        SafeWindow3 window = new SafeWindow3();

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
