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
        System.out.println(person1.toString());

        // 2. 通过对象通用Person内部的属性、方法
        person1.age = 10;
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
            Field age = clazz.getDeclaredField("age");
            age.set(person, 10);
            System.out.println(person.toString());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.println("***********************");

        // 3. 调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(person);

        System.out.println("***********************");

        // 通过反射可以嗲用Person类的私有结构：私有属性、私有方法、私有构造器等
        // 调用私有构造器
        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);
        // 必须要有设置true这一步
        // 否则会报can not access a member of class ******* with modifiers "private"这种错误
        declaredConstructor.setAccessible(true);
        Person person1 = (Person) declaredConstructor.newInstance("Jerry");
        System.out.println(person1);

        System.out.println("***********************");

        // 调用私有属性
        try {
            Field name = clazz.getDeclaredField("name");
            name.setAccessible(true);
            name.set(person1, "HanMeimei");
            System.out.println(person1);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        System.out.println("***********************");
        // 调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(person1, "中国");
        System.out.println("nation = " + nation);
    }
}
