package com.fuqi.designmodellearn.singletonlearn;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @Description: 单例模式实现方式之————使用静态内部类实现（）
 * @Author 傅琦
 * @date 2019/8/9 21:13
 * @Version V1.0
 */
public class SingletonTest5 {
    public static void main(String[] args) throws Exception {
        Tom tomA = Tom.getInstance();
        Tom tomB = Tom.getInstance();
        // 结果为true
        System.out.println(tomA == tomB);

        Class<Tom> tomClass = Tom.class;
        Constructor<Tom> tomConstructor = tomClass.getDeclaredConstructor();
        tomConstructor.setAccessible(true);
        Tom tomC = tomConstructor.newInstance();
        // false：tomC没有属性，但是确实不同的实例了
        System.out.println(tomA == tomC);
    }
}

class Tom {
    private Tom(){
        if (TomInstance.INSTANCE != null) {
            throw new IllegalStateException();
        }
    }

    private static class TomInstance {
        private static final Tom INSTANCE = new Tom();
    }

    public static Tom getInstance() {
        return TomInstance.INSTANCE;
    }
}
