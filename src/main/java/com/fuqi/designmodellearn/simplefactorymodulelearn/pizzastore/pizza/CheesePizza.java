package com.fuqi.designmodellearn.simplefactorymodulelearn.pizzastore.pizza;

/**
 * @Description
 * @Author 傅琦
 * @date 2019/8/9 21:46
 * @Version V1.0
 */
public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println(" 为制作奶酪披萨做准备；");
    }
}
