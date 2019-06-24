package com.fuqi.designmodellearn.proxymodellearn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: 动态代理举例
 * @Author 傅琦
 * @date 2019/6/24 15:07
 * @Version V1.0
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        // proxyInstance此时为代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);

        String name = proxyInstance.getName();
        System.out.println("name = " + name);
        proxyInstance.eat("麻辣烫");
        System.out.println("*****************************");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();

        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);

        proxyClothFactory.produceCloth();
    }
}

interface Human{

    String getName();

    void eat(String food);
}

/**
 * 被代理类
 */
class SuperMan implements Human {
    @Override
    public String getName() {
        return "World Peace!";
    }

    @Override
    public void eat(String food) {
        System.out.println("I like eat: " + food);
    }
}

class ProxyFactory {
    /**
     *
     * @param object : 被代理的对象
     * @return: Object：返回一个代理类的对象
     */
    public static Object getProxyInstance(Object object){
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(object);

        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler {
    /**
     * 需要使用被代理类的对象进行赋值
     */
    private Object obj;

    public void bind(Object obj){
        this.obj = obj;
    }

    /**
     * 当通过代理类的对象，调用方法a时，就会自动调用如下的方法：invoke()
     * 将被代理类要执行的方法a的功能声明在invoke()中
     * @param o 代理类对象
     * @param method 代理类的对象的方法
     * @param objects
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        HumanUtil util = new HumanUtil();
        util.method1();

        // method: 即为被代理类对象调用的方法，此方法就作为了被代理类对象要调用的方法
        Object returnValue = method.invoke(obj, objects);

        util.method2();
        return returnValue;


    }
}

class HumanUtil{

    public void method1(){
        System.out.println("***************通用方法1******************");
    }

    public void method2(){
        System.out.println("***************通用方法2******************");
    }
}
