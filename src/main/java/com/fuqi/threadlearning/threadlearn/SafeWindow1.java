package com.fuqi.threadlearning.threadlearn;

/**
 * @Description: 用同步代码块的方式解决Runnable实现方式下线程安全问题的练习：
 * @Author 傅琦
 * @Date 2019/6/13 15:55
 * @Version V1.0
 */
public class SafeWindow1 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (true){
            // 采用同步代码块的方式来解决线程安全问题，虽然会损失部分性能
            synchronized (this){
                if (ticket > 0){
                    System.out.println(Thread.currentThread().getName() + ": " + ticket);
                    ticket--;
                }else {
                    break;
                }
            }
        }
    }
}

class SafeWindowTest1{
    public static void main(String[] args){
        SafeWindow1 window = new SafeWindow1();

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
