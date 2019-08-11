package com.fuqi.designmodellearn.proxymodellearn.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/8/11 20:43
 * @Version V1.0
 */
public class ProxyFactory {
    /**
     * 目标对象
     */
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 给目标对象生成一个代理对象
     */
    public Object getProxyInstance(){
        // 用到了 newProxyInstance()方法，下面就该方法予以说明
        /**
         * public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
         * ClassLoader loader: 值定当前目标对象使用的类加载器，获取加载器的方法固定
         * Class<?>[] interfaces：目标对象实现的接口类型，使用泛型方法确认
         * InvocationHandler h：事件处理，执行目标对象的方法时，会去出发事件处理器的方法，
         *                      会把当前执行的目标对象方法作为参数传入
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("JDK代理开始");
                        // 通过反射机制调用目标对象的方法，并返回调用结果
                        Object returnVal = method.invoke(target, args);
                        System.out.println("JDK代理提交");
                        return returnVal;
                    }
                });
    }
}
