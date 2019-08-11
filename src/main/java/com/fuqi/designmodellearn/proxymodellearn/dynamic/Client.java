package com.fuqi.designmodellearn.proxymodellearn.dynamic;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/8/11 20:57
 * @Version V1.0
 */
public class Client {
    public static void main(String[] args) {
        /**
         * 1. 创见一个目标对象
         */
        ITeacherDao target = new ITeacherDaoImpl();

        /**
         * 2. 给目标对象创建代理对象
         */
        ITeacherDao proxyInstance = (ITeacherDao) new ProxyFactory(target).getProxyInstance();

        /**
         * 返回结果可以看出内存中动态生成了代理对象
         */
        System.out.println("proxyInstance= " + proxyInstance.getClass());

        /**
         * 通过代理对象调用目标对象的方法
         */
//        proxyInstance.teach();

        proxyInstance.sayHello("Tom");
    }
}
