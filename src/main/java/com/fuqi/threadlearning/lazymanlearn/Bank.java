package com.fuqi.threadlearning.lazymanlearn;

/**
 * @Description:
 * @Author 傅琦
 * @Date 2019/6/14 16:27
 * @Version V1.0
 */
public class Bank {
    private Bank() { }

    private static Bank instance = null;

    /**
     * 使用同步方法以保证线程安全
     * @return Bank
     */
    public static synchronized Bank getInstance(){
        /**方式一：效率稍差
        synchronized(Bank.class){
            if (instance == null){
                instance = new Bank();
            }
            return instance;
        }

         方式二：效率较高
         if(instance == null){
             synchronized(Bank.class){
                 if (instance == null){
                    instance = new Bank();
                 }
                 return instance;
             }
         }
         */
        if (instance == null){
            instance = new Bank();
        }
        return instance;
    }
}
