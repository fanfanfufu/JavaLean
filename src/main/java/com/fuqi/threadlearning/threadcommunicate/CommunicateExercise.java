package com.fuqi.threadlearning.threadcommunicate;

/**
 * @Description: 实现两个线程交替打印1-100的数
 * @Author 傅琦
 * @Date 2019/6/14 21:47
 * @Version V1.0
 */
public class CommunicateExercise {
    public static void main(String[] args){
        Number number = new Number();

        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}

class Number implements Runnable{
    private int number = 1;

    @Override
    public void run() {
        while (true){
            synchronized (this) {
                // 唤醒在等待的线程
                // notify()只唤醒一个休眠的线程，有多个的情况下，先唤醒优先级高的；notifyAll()则唤醒所有在休眠的线程
                // 若锁不是当前类对象，需要通过obj.notify()来唤醒一个休眠线程
                notify();

                if (number <= 100){
                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number++;

                    try {
                        // 使当前线程等待，wait()会释放锁；相比之下，sleep()却不会释放锁
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }
    }
}
