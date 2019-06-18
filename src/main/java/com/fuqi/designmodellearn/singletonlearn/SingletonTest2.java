package com.fuqi.designmodellearn.singletonlearn;

/**
 * @Description: 单例模式的实现练习1：懒汉式实现
 * @Author 傅琦
 * @Date 2019/6/18 15:46
 * @Version V1.0
 */
public class SingletonTest2 {
    public static void main(String[] args) {
        Order order1 = Order.getInstance();
        Order order2 = Order.getInstance();

        // 结果为true
        System.out.println(order1 == order2);
    }
}

class Order{
    /**
     * 1. 私有化构造器
     */
    private Order() { }

    /**
     * 2. 声明当前类对象，没有初始化
     * 此对象必须声明为static的
     */
    private static Order instance = null;

    /**
     * 3. 声明public static的返回当前类对象的方法
     */
    public static Order getInstance(){
        if (instance == null){
            instance = new Order();
        }
        return instance;
    }
}
