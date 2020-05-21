package com.fuqi.threadlearning.threadlearn;

/**
 * @Description: 使用同步代码块的方式解决继承Thread类的线程安全问题。
 * @Author 傅琦
 * @Date 2019/6/13 16:05
 * @Version V1.0
 */
public class SafeWindow2 extends Thread{
    private static int ticket = 100;

    /**
     * 这里的object必须是静态的，否则就不能作为锁
     */
    private static Object object = new Object();

    @Override
    public void run() {
        while (true){
            // 使用object作为锁
            // synchronized (object){
            // 也可以使用类本身作为锁
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
        /**
         * 采用this作为锁不适用于继承Thread类的多线程实现方式
         * 因为在主线程中需要创建多个类对象，this不是公用的对象，
         * 因此不能用于锁
         */
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
