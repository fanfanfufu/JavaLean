package com.fuqi.threadlearn;

/**
 * @Description: 创建三个窗口买票，总票数为100张
 * @Author 傅琦
 * @Date 2019/6/12 17:16
 * @Version V1.0
 */
public class WindowTest1 {
    public static void main(String[] args){
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}

class Window extends Thread{
    private static int ticket = 100;

    @Override
    public void run() {
        while (true){

            if (ticket > 0){
                System.out.println(getName() + ": " + ticket);
                ticket--;
            }else {
                break;
            }
        }
    }
}
