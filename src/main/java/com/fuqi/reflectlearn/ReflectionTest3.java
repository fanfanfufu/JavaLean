package com.fuqi.reflectlearn;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Description: 调用运行时类中指定的结构：属性、方法、构造器
 * @Author: 傅琦
 * @DateTime: 2019/6/23 21:38
 * @Version: V1.0
 */
public class ReflectionTest3 {
    /**
     * 调用指定的属性
     */
    @Test
    public void test1() throws Exception {
        Class clazz = Person.class;

        // 创建运行时类的对象
        Person person = (Person) clazz.newInstance();

        // 获取指定的属性：要求此属性在运行时类中需要声明为public。通常不采用此方法
//        Field age = clazz.getField("age");

        // 获取指定名称的属性
        Field name = clazz.getDeclaredField("name");

        // 设置当前属性的值
        // 1. 如果不是public所修饰的，需要先设置能修改该属性，使得当前属性可以被访问
        name.setAccessible(true);
        // 2. 参数1：指定设置哪个对象的属性；参数2：将此属性设置为多少
        name.set(person, "Tom");
        System.out.println(person);

        // 获取当前属性的值
    }

    /**
     * 调用运行时类的指定的方法
     */
    @Test
    public void testMethod() throws Exception{
        Class clazz = Person.class;

        // 创建运行时类的对象
        Person person = (Person) clazz.newInstance();

        /**
         * 调用非静态方法
         */
        // 1. 获取指定的某个方法
        // 该方法说明：
        //    参数1：指明要获取的方法的名称
        //    参数2：指定要获取的方法的参数列表
        Method show = clazz.getDeclaredMethod("showNation", String.class);

        // 2. 设置方法是可以被访问的
        show.setAccessible(true);

        // 3. 调用invoke():
        //     参数1：方法的调用者
        //     参数2：给方法形参赋值的实参
        //    其返回值为对应类中调用的方法的返回值
        Object china = show.invoke(person, "China");
        System.out.println("china = " + china);

        System.out.println("*****************************************");
        /**
         * 调用静态方法
         */
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        // 如果该方法没有返回值，则invoke()返回null
//        Object invoke = showDesc.invoke(Person.class);
        // 这里invoke方法的参数也可以设置为null
        Object invoke = showDesc.invoke(null);
        System.out.println("invoke = " + invoke);
    }

    /**
     * 调用运行时类的指定的构造器
     */
    @Test
    public void testConstructor() throws Exception{
        Class clazz = Person.class;

        // 1. 获取指定的构造器
        // getDeclaredConstructor(参数)：参数：指明构造器的参数列表(可变参数列表，有多少个写多少个)
        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);

        // 2. 设置该构造器是可以被访问的
        declaredConstructor.setAccessible(true);

        // 3. 调用此构造器创建运行时类对象
        Person person = (Person) declaredConstructor.newInstance("Tom");
        System.out.println("person = " + person);
    }
}
