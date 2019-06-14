package com.fuqi.threadlearn;

/**
 * @Description: 由两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 *
 * 分析:1. 是否是多线程问题？是，有两个储户线程
 *     2. 是否有共享数？有，共用账户
 *     3. 是否有线程安全问题？有
 *     4. 需要如何考虑解决线程安全问题？同步机制
 *
 * @Author 傅琦
 * @Date 2019/6/14 21:20
 * @Version V1.0
 */
public class AccountExercise {
    public static void main(String[] args){
        Account account = new Account(0);
        Customer customer1 = new Customer(account);
        Customer customer2 = new Customer(account);
        customer1.setName("储户1");
        customer2.setName("储户2");

        customer1.start();
        customer2.start();
    }
}

class Customer extends Thread{
    private Account account;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(1000);
        }
    }
}

class Account{
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    /**
     * 存钱操作
     */
    public synchronized void deposit(double amt){
        if (amt > 0){
            balance += amt;
            System.out.println(Thread.currentThread().getName() + "存钱成功，当前余额为：" + balance);
        }
    }
}
