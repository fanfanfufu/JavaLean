package com.fuqi.threadlearn;

/**
 * @Description: 使用同步代码块的方式解决继承Thread类的县城安全问题。
 * @Author 傅琦
 * @Date 2019/6/13 16:05
 * @Version V1.0
 */
public class SafeWindow2 extends Thread{
    private static int ticket = 100;

    private static Object object = new Object();

    @Override
    public void run() {
        while (true){
            synchronized (SafeWindow2.class){
                if (ticket > 0){
                    System.out.println(getName() + ": " + ticket);
                    ticket--;
                }else {
                    break;
                }
            }
        }
    }
}

class SafeWindowTest2{
    public static void main(String[] args){
        SafeWindow2 w1 = new SafeWindow2();
        SafeWindow2 w2 = new SafeWindow2();
        SafeWindow2 w3 = new SafeWindow2();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}
