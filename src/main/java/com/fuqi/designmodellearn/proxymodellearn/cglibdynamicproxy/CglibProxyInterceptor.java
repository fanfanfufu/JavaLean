package com.fuqi.designmodellearn.proxymodellearn.cglibdynamicproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author FuQi
 * @date 2023/3/5 16:58
 * @description
 */
public class CglibProxyInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 扩展逻辑
        if ("eat".equals(method.getName())) {
            System.out.println("准备投喂动物食物");
        }
        // 代理真实对象执行其方法
        Object ans = methodProxy.invokeSuper(o, objects);
        // 扩展逻辑
        if ("eat".equals(method.getName())) {
            if ("OK".equals(ans)) {
                System.out.println("动物很喜欢本次投喂的食物");
            } else {
                System.out.println("本次投喂的食物动物不喜欢");
            }
        }

        return ans;
    }
}
