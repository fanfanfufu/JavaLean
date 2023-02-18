package com.fuqi.designmodellearn.singletonlearn;

/**
 * @Description: 单例模式的实现方式之————枚举法
 *
 * 不仅能避免多线程同步问题，而且还能防止反序列化创建新的对象
 *
 * @Author 傅琦
 * @date 2019/8/9 21:25
 * @Version V1.0
 */
public class SingletonTest6 {
    public static void main(String[] args) {
        System.out.println("aa");
        System.out.println("ab");
        SingletonTest6 singletonTest6 = new SingletonTest6();

        Cat cat1 = Cat.INSTANCE;
        Cat cat2 = Cat.INSTANCE;

        // true
        System.out.println(cat1 == cat2);

        // 两个结果相等
        System.out.println(cat1.hashCode());
        System.out.println(cat2.hashCode());
    }

}

enum Cat{
    /**
     * 唯一示例，单例的实现方式
     */
    INSTANCE;
    public void sayOK(){
        System.out.println("OK~");
    }
}
