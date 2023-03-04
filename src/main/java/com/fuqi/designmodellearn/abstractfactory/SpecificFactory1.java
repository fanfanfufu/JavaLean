package com.fuqi.designmodellearn.abstractfactory;

import com.fuqi.designmodellearn.simplefactorymodulelearn.carfactory.BaoMa;
import com.fuqi.designmodellearn.simplefactorymodulelearn.carfactory.Car;

/**
 * @author FuQi
 * @date 2023/3/4 17:20
 * @description
 */
public class SpecificFactory1 implements AbstractFactory{
    @Override
    public Car produceCar() {
        System.out.println("具体工厂1制造汽车产品的具体产品1：BaoMa");
        return new BaoMa();
    }

    @Override
    public Phone producePhone() {
        System.out.println("具体工厂1制造手机产品的具体产品1：Apple");
        return new ApplePhone();
    }
}
