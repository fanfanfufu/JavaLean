package com.fuqi.designmodellearn.proxymodellearn;

/**
 * @Description: 静态代理举例
 * @Author 傅琦
 * @date 2019/6/24 15:03
 * @Version V1.0
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        // 1. 创建被代理类的对象
        NikeClothFactory nike = new NikeClothFactory();
        // 2. 创建代理类的对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);

        proxyClothFactory.produceCloth();
    }
}

interface ClothFactory {
    void produceCloth();
}

/**
 * 代理类
 */
class ProxyClothFactory implements ClothFactory {
    private ClothFactory clothFactory;

    public ProxyClothFactory(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工程做一些准备工作");

        clothFactory.produceCloth();

        System.out.println("代理工厂做后续工作");
    }
}

/**
 * 被代理类
 */
class NikeClothFactory implements ClothFactory {
    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产一批运动服");
    }
}
