package com.fuqi.designmodellearn.simplefactorymodulelearn.pizzastore.pizza;

/**
 * @Description
 * @Author 傅琦
 * @date 2019/8/9 21:47
 * @Version V1.0
 */
public class GreekPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println(" 为希腊披萨准备原材料 ");
    }
}
