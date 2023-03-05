package com.fuqi.designmodellearn.proxymodellearn.cglibdynamicproxy;

/**
 * @author FuQi
 * @date 2023/3/5 16:39
 * @description
 */
public class Shark {
    public void showName() {
        System.out.println("this is shark.");
    }

    public void showType() {
        System.out.println("it's a fish.");
    }

    public String eat(String food) {
        if ("meat".equals(food) || "fish".equals(food)) {
            return "OK";
        }

        return "NO";
    }
}
