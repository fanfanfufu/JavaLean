package com.fuqi.designmodellearn.factorymethod;

import com.fuqi.designmodellearn.simplefactorymodulelearn.carfactory.BenChi;
import com.fuqi.designmodellearn.simplefactorymodulelearn.carfactory.Car;

/**
 * @author FuQi
 * @date 2023/3/4 14:55
 * @description
 */
public class BenChiFactory implements CarFactory{
    @Override
    public Car produceCar() {
        System.out.println("由奔驰工厂制造具体的奔驰汽车");
        return new BenChi();
    }
}
