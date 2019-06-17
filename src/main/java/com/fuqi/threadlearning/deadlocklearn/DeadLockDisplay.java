package com.fuqi.threadlearning.deadlocklearn;

/**
 * @Description: 死锁问题的演示二
 * @Author 傅琦
 * @Date 2019/6/14 16:57
 * @Version V1.0
 */
public class DeadLockDisplay implements Runnable{
    A a = new A();
    B b = new B();

    public void init(){
        Thread.currentThread().setName("主线程");
        a.foo(b);
        System.out.println("进入了主线程之后");
    }

    @Override
    public void run(){
        Thread.currentThread().setName("副线程");
        b.bar(a);
        System.out.println("进入了副线程之后");
    }

    public static void main(String[] args){
        DeadLockDisplay display = new DeadLockDisplay();
        new Thread(display).start();

        display.init();
    }
}

class A{
    /**
     * 此时，该方法所用的同步监视器是A的类对象a
     * @param b
     */
    public synchronized void foo(B b){
        System.out.println("当前线程名：" + Thread.currentThread().getName() + " 进入A实例的foo方法");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程名：" + Thread.currentThread().getName() + " 企图调用B实例的last方法");
        b.last();
    }

    /**
     * 此时同步监视器是A的类对象a
     */
    public synchronized void last(){
        System.out.println("进入了A类的last方法内部");
    }
}

class B{
    /**
     * 此时，该方法所用的同步监视器是B的类对象b
     * @param a
     */
    public synchronized void bar(A a){
        System.out.println("当前线程名：" + Thread.currentThread().getName() + " 进入了B实例的bar方法");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程名：" + Thread.currentThread().getName() + " 企图调用A实例的last方法");
        a.last();
    }

    /**
     * 此时同步监视器是B的类对象b
     */
    public synchronized void last(){
        System.out.println("进入了B实例的last方法内部");
    }
}
