package com.fuqi.reflectlearn;

import java.io.Serializable;

/**
 * @Description
 * @Author 傅琦
 * @date 2019/6/22 20:28
 * @Version V1.0
 */
public class Person implements Serializable {
    private static final long serialVersionUID = -6710807211838433643L;

    public String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void show(){
        System.out.println("你好，我叫" + name);
    }

    private String showNation(String nation){
        System.out.println("my nation= " + nation);
        return nation;
    }
}
