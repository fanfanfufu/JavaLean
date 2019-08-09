package com.fuqi.designmodellearn.singletonlearn;

/**
 * @Description: 单例模式实现方式之——双重检查(技能解决线程安全问题，也能解决效率问题。推荐使用)
 * @Author 傅琦
 * @date 2019/8/9 21:04
 * @Version V1.0
 */
public class SingletonTest4 {

}

class Person {
    private static volatile Person person;

    private Person(){ }

    public static Person getInstance(){
        if (person == null){
            synchronized (Person.class){
                if (person == null){
                    person = new Person();
                }
            }
        }

        return person;
    }
}
