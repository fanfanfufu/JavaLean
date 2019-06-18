package com.fuqi.innerclasslearn;

/**
 * @Description: 局部内部类学习1
 * @Author 傅琦
 * @Date 2019/6/18 20:26
 * @Version V1.0
 */
public class InnerClassTest2 {
    public void mehtod(){
        // 局部内部类
        class AA{

        }
    }

    /**
     * 返回一个实现了Comparable接口的类的对象
     * @return
     */
    public Comparable getComparable1(){
        // 方式一
        // 创建一个实现了Comparable接口的类：局部内部类
        class MyComparable implements Comparable{
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        }
        return new MyComparable();
    }

    public Comparable getComparable2(){
        // 方式二：匿名类
        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }
}
