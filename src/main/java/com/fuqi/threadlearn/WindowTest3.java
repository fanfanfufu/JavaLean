package com.fuqi.threadlearn;

/**
 * @Description: 线程安全问题的示例，出现0、-1的概率会很大
 * @Author 傅琦
 * @Date 2019/6/13 15:28
 * @Version V1.0
 */
public class WindowTest3 {
    public static void main(String[] args){
        Window3 window = new Window3();

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

class Window3 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (true){
            if (ticket > 0){
                // 不解决线程问题的情况下：加上休眠时间，就使得出现0、-1的概率增加了很多
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {

                }

                System.out.println(Thread.currentThread().getName() + ": " + ticket);
                ticket--;
            }else {
                break;
            }
        }
    }
}
