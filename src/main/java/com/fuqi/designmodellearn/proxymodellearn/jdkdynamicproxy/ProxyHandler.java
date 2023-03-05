package com.fuqi.designmodellearn.proxymodellearn.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author FuQi
 * @date 2023/3/5 16:41
 * @description
 */
public class ProxyHandler implements InvocationHandler {
    private Animal animal;

    public ProxyHandler(Animal animal) {
        this.animal = animal;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 扩展逻辑
        if ("eat".equals(method.getName())) {
            System.out.println("准备投喂动物食物");
        }
        // 执行真实对象的目标方法
        Object ans = method.invoke(animal, args);
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
