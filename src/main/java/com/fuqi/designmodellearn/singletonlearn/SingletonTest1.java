package com.fuqi.designmodellearn.singletonlearn;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Description: 单例模式的实现练习1：饿汉式实现
 * @Author 傅琦
 * @Date 2019/6/18 15:39
 * @Version V1.0
 */
public class SingletonTest1 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();

        // 结果为true
        System.out.println(bank1 == bank2);

        // 通过反射的方式
        Class<Bank> bankClass = Bank.class;
        Constructor<Bank> bankClassConstructor = bankClass.getDeclaredConstructor();
        bankClassConstructor.setAccessible(true);
        Bank bank = bankClassConstructor.newInstance();
        // 结果为false
        System.out.println(bank == bank1);
    }
}

class Bank{
    /**
     * 1. 构造器私有化
     */
    private Bank(){  }

    /**
     *
     * 2. 内部创建类的对象
     * 要求此对象也必须声明为静态的
     */
    private static Bank instance = new Bank();

    /**
     * 3. 提供公共的方法，返回类的对象
     * 此方法必须是静态方法
     */
    public static Bank getInstance(){
        return instance;
    }
}
