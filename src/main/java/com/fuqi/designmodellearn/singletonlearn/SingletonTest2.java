package com.fuqi.designmodellearn.singletonlearn;

/**
 * @Description: 单例模式的实现方式————静态变量饿汉式
 * @Author 傅琦
 * @date 2019/8/9 20:53
 * @Version V1.0
 */
public class SingletonTest2 {

}

class Singleton {

    private static Singleton instance;

    static {
        instance = new Singleton();
    }

    private Singleton() {

    }

    public static Singleton getInstance(){
        return instance;
    }
}

