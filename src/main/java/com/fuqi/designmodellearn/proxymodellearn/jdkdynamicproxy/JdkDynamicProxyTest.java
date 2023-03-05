package com.fuqi.designmodellearn.proxymodellearn.jdkdynamicproxy;

import java.lang.reflect.Proxy;

/**
 * @author FuQi
 * @date 2023/3/5 16:48
 * @description
 */
public class JdkDynamicProxyTest {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        ProxyHandler tigerProxyHandler = new ProxyHandler(tiger);
        Animal tigerProxy = (Animal) Proxy.newProxyInstance(tiger.getClass().getClassLoader(), tiger.getClass().getInterfaces(), tigerProxyHandler);
        tigerProxy.showType();
        tigerProxy.showName();
        tigerProxy.eat("糖");
        tigerProxy.eat("meat");
    }
}
