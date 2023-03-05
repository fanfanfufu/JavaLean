package com.fuqi.designmodellearn.proxymodellearn.jdkdynamicproxy;

/**
 * @author FuQi
 * @date 2023/3/5 16:36
 * @description
 */
public class Tiger implements Animal{
    @Override
    public void showName() {
        System.out.println("this is tiger.");
    }

    @Override
    public void showType() {
        System.out.println("it's a mammal.");
    }

    @Override
    public String eat(String food) {
        if ("meat".equals(food)) {
            System.out.println("tiger eats meat.");
            return "OK";
        }

        return "NO";
    }
}
