package com.fuqi.designmodellearn.simplefactorymodulelearn.pizzastore.order;

import com.fuqi.designmodellearn.simplefactorymodulelearn.pizzastore.pizza.CheesePizza;
import com.fuqi.designmodellearn.simplefactorymodulelearn.pizzastore.pizza.GreekPizza;
import com.fuqi.designmodellearn.simplefactorymodulelearn.pizzastore.pizza.PepperPizza;
import com.fuqi.designmodellearn.simplefactorymodulelearn.pizzastore.pizza.Pizza;

/**
 * @Description
 * @Author 傅琦
 * @date 2019/8/9 22:07
 * @Version V1.0
 */
public class PizzaFactory {
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;

        System.out.println("使用简单工厂模式");
        if ("greek".equals(orderType)){
            pizza = new GreekPizza();
            pizza.setName(" greekPizza");
        }else if ("cheese".equals(orderType)){
            pizza = new CheesePizza();
            pizza.setName(" cheesePizza");
        }else if ("pepper".equals(orderType)){
            pizza = new PepperPizza();
            pizza.setName(" pepperPizza");
        }

        return pizza;
    }
}
