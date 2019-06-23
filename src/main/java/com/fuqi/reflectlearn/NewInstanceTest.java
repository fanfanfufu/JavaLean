package com.fuqi.reflectlearn;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @Description: 通过反射创建对应的运行时类的对象
 * @Author: 傅琦
 * @DateTime: 2019/6/23 19:52
 * @Version: V1.0
 */
public class NewInstanceTest {

    @Test
    public void test1(){
        Class<Person> clazz = Person.class;

        try {
            // 使用newInstance()即可创建运行时类的对象
            Person person = clazz.newInstance();
            System.out.println("person = " + person);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 体会反射的动态性
     */
    @Test
    public void test2(){
        for (int i = 0; i < 20; i++) {
            int num = new Random().nextInt(3);
            String classPath = "";
            switch (num){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.util.ArrayList";
                    break;
                case 2:
                    classPath = "com.fuqi.reflectlearn.Person";
                    break;
                default:
                    System.out.println("*******************");
            }

            try {
                Object object = getInstance(classPath);
                System.out.println(object);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Object getInstance(String classPath) throws Exception{
        Class<?> clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}
