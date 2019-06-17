package com.fuqi.threadlearning.threadlearn;

/**
 * @Description:
 * @Author 傅琦
 * @Date 2019/6/12 20:25
 * @Version V1.0
 */
public class WindowTest2 {
    public static void main(String[] args){
        TicketWindow window = new TicketWindow();

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

class TicketWindow implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (true){
            if (ticket > 0){
                System.out.println(Thread.currentThread().getName() + ": " + ticket);
                ticket--;
            }else {
                break;
            }
        }
    }
}
