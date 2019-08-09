package com.fuqi.designmodellearn.simplefactorymodulelearn.pizzastore.order;

import com.fuqi.designmodellearn.simplefactorymodulelearn.pizzastore.pizza.CheesePizza;
import com.fuqi.designmodellearn.simplefactorymodulelearn.pizzastore.pizza.GreekPizza;
import com.fuqi.designmodellearn.simplefactorymodulelearn.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/8/9 21:48
 * @Version V1.0
 */
public class OrderPizza {

//    public OrderPizza(){
//        Pizza pizza = null;
//        String orderType;
//        do {
//            orderType = gettype();
//            if (orderType.equals("greek")){
//                pizza = new GreekPizza();
//                pizza.setName(" greekPizza");
//            }else if (orderType.equals("cheese")){
//                pizza = new CheesePizza();
//                pizza.setName(" cheesePizza");
//            }else {
//                break;
//            }
//
//            // 输出pizza的制作过程
//            pizza.prepare();
//            pizza.bake();
//            pizza.cut();
//            pizza.box();
//
//        }while (true);
//    }

    /**
     * 定义一个简单的披萨工厂对象
     */
    PizzaFactory pizzaFactory;
    Pizza pizza = null;

    /**
     *
     * @param pizzaFactory
     */
    public OrderPizza(PizzaFactory pizzaFactory){
        setPizzaFactory(pizzaFactory);
    }

    public void setPizzaFactory(PizzaFactory pizzaFactory){
        String orderType = "";

        this.pizzaFactory = pizzaFactory;

        do {
            orderType = gettype();
            pizza = this.pizzaFactory.createPizza(orderType);

            if (pizza != null){
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else {
                System.out.println(" 预定失败。");
                break;
            }
        }while (true);
    }

    /**
     * 获取用户希望订购的披萨种类
     */
    private String gettype(){
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type: ");
            String str = strin.readLine();
            return str;
        }catch (IOException e){
            e.printStackTrace();
            return " ";
        }
    }
}
