package com.fuqi.reflectlearn;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author 傅琦
 * @date 2019/6/22 20:32
 * @Version V1.0
 */
public class ReflectionTest1 {
    /**
     * 反射之前，对于Person类的操作
     */
    @Test
    public void test1(){
        // 1. 创建Person类对象
        Person person1 = new Person("Tom", 12);

        // 2. 通过对象通用Person内部的属性、方法
        person1.name = "Mike";
        System.out.println("person1 = " + person1);

        person1.show();
    }

    @Test
    public void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Person.class;
        // 1. 通过反射创建Person类对象
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Object tom = constructor.newInstance("Tom", 12);
        Person person = (Person) tom;
        System.out.println(person.toString());

        System.out.println("***********************");
        // 2. 通过反射，调用对象指定的属性方法
        try {
            // 会报错：can not access a member of class com.fuqi.reflectlearn.Person with modifiers "private"
//            Field age = clazz.getDeclaredField("age");
//            age.set(person, 10);
//            System.out.println(person.toString());
            Field name = clazz.getDeclaredField("name");
            name.set(person, "Mike");
            System.out.println(person.toString());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.println("***********************");

        // 3. 调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(person);
    }
}
