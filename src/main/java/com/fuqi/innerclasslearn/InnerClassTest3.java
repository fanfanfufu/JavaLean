package com.fuqi.innerclasslearn;

/**
 * @Description: 局部内部类学习2
 * @author 傅琦
 * @date 2019/6/18 20:34
 * @version V1.0
 */
public class InnerClassTest3 {
    /**
     * 在局部内部类的方法中，如果调用局部内部类所声明的方法中的局部变量，如下面的num
     * 要求此变量必须被声明为final的
     */
    public void method(){
        /**
         * JDK7以及之前的版本，要求次局部变量必须显示地声明为final的
         * JDK8以及之后的版本，则可省略final地声明
         */
        final int num = 10;

        class AA{
            public void show(){
                // num = 20;  这里无法修改num的值，num必须被声明为是final的
                System.out.println("num = " + num);
            }
        }
    }
}
