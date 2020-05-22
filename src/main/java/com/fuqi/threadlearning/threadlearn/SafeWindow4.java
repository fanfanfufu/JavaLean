package com.fuqi.threadlearning.threadlearn;

/**
 * @Description: 使用同步方法来处理继承自Thread类的线程安全问题
 * @Author 傅琦
 * @Date 2019/6/14 16:03
 * @Version V1.0
 */
public class SafeWindow4 extends Thread {
    private static int ticket = 100;

    private static Object object = new Object();

    @Override
    public void run() {
        while (true){
            if (ticket == 0){
                break;
            }
            show();
        }
    }

    /**
     * 这里的同步方法需要定义成静态方法
     */
    private static synchronized void show(){
        if (ticket > 0){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": " + ticket);
            ticket--;
        }
    }
}

class SafeWindowTest4{
    public static void main(String[] args){
        SafeWindow4 w1 = new SafeWindow4();
        SafeWindow4 w2 = new SafeWindow4();
        SafeWindow4 w3 = new SafeWindow4();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}
