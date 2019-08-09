package com.fuqi.designmodellearn.simplefactorymodulelearn.pizzastore.pizza;

/**
 * @Description
 * @Author 傅琦
 * @date 2019/8/9 22:10
 * @Version V1.0
 */
public class PepperPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println(" 为胡椒披萨准备原材料。");
    }
}
