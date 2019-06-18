package com.fuqi.innerclasslearn;

/**
 * @Description: 内部类学习一
 * @Author 傅琦
 * @Date 2019/6/18 19:20
 * @Version V1.0
 */
public class InnerClassTest1 {
}

class Person{

    /**
     * 成员内部类
     */
    class Brain{

    }

    /**
     * 静态成员内部类
     */
    static class Mouth{

    }

    public void method(){
        // 局部内部类
        class AA{

        }
    }


}
