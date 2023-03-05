package com.fuqi.designmodellearn.proxymodellearn.jdkdynamicproxy;

/**
 * @author FuQi
 * @date 2023/3/5 16:38
 * @description
 */
public class Rabbit implements Animal{
    @Override
    public void showName() {
        System.out.println("this is rabbit.");
    }

    @Override
    public void showType() {
        System.out.println("it's a mammal");
    }

    @Override
    public String eat(String food) {
        if ("leaf".equals(food)) {
            return "OK";
        }
        return "NO";
    }
}
