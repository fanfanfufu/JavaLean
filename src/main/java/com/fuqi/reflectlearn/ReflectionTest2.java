package com.fuqi.reflectlearn;

import org.junit.jupiter.api.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Description:
 * @Author: 傅琦
 * @DateTime: 2019/6/23 21:15
 * @Version: V1.0
 */
public class ReflectionTest2 {
    /**
     * 获取当前运行时类的父类的泛型
     */
    @Test
    public void test(){
        Class clazz = Person.class;

        // 父类有泛型时能正常出结果，没有泛型时会报：java.lang.Class cannot be cast to java.lang.reflect.ParameterizedType
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        // 获取泛型类型
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        System.out.println(((Class) actualTypeArguments[0]).getName());
    }
}
