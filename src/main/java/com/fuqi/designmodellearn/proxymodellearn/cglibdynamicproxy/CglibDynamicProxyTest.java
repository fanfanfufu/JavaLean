package com.fuqi.designmodellearn.proxymodellearn.cglibdynamicproxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author FuQi
 * @date 2023/3/5 17:02
 * @description
 */
public class CglibDynamicProxyTest {
    public static void main(String[] args) {
        CglibProxyInterceptor proxyInterceptor = new CglibProxyInterceptor();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Shark.class);
        enhancer.setCallback(proxyInterceptor);
        Shark shark = (Shark) enhancer.create();
        shark.showType();
        shark.showName();
        shark.eat("water");
        shark.eat("meat");
        shark.eat("grass");
        shark.eat("fish");
    }
}
