package com.fuqi.designmodellearn.simplefactorymodulelearn.pizzastore.order;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/8/9 21:54
 * @Version V1.0
 */
public class PizzaStore {
    public static void main(String[] args) {
//        new OrderPizza();

        // 使用简单工程模式
        new OrderPizza(new PizzaFactory());
        System.out.println("退出程序。");
    }
}
