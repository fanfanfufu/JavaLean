package com.fuqi.designmodellearn.factorymethod;

import com.fuqi.designmodellearn.simplefactorymodulelearn.carfactory.BaoMa;
import com.fuqi.designmodellearn.simplefactorymodulelearn.carfactory.Car;

/**
 * @author FuQi
 * @date 2023/3/4 14:53
 * @description
 */
public class BaoMaFactory implements CarFactory{
    @Override
    public Car produceCar() {
        System.out.println("由宝马工厂制造具体的宝马汽车");
        return new BaoMa();
    }
}
