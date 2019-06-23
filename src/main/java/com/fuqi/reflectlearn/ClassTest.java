package com.fuqi.reflectlearn;

import org.junit.jupiter.api.Test;

/**
 * @Description: 练习获取Class的方式
 * @Author: 傅琦
 * @DateTime: 2019/6/23 16:03
 * @Version: V1.0
 */
public class ClassTest {
    /**
     * 方式一：调用运行时 类的属性 .class
     */
    @Test
    public void test1(){
        Class<Person> personClass = Person.class;
        System.out.println("personClass = " + personClass);
    }

    /**
     * 方式二：通过运行时的类的对象
     */
    @Test
    public void test2(){
        Person person = new Person();
        Class personClass = person.getClass();
        System.out.println("personClass = " + personClass);
    }

    /**
     * 调用Class的静态方法：forName(String classPath)
     */
    @Test
    public void test3(){
        Class clazz = null;
        try {
            clazz = Class.forName("com.fuqi.reflectlearn.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("clazz = " + clazz);
    }

    /**
     * 以上三种获取方式获取到的都是同一个类的实例，用 == 判断，返回值为true
     */

    /**
     * 方式四：使用类的加载器：ClassLoader(了解)
     */
    @Test
    public void test4(){
        ClassLoader classLoader = ClassTest.class.getClassLoader();
        Class clazz = null;
        try {
            clazz = classLoader.loadClass("com.fuqi.reflectlearn.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("clazz = " + clazz);

        Class<Person> personClass = Person.class;
        // 结果为true
        System.out.println(clazz == clazz);
    }
}
