package com.fuqi.designmodellearn.abstractfactory;

import com.fuqi.designmodellearn.simplefactorymodulelearn.carfactory.BenChi;
import com.fuqi.designmodellearn.simplefactorymodulelearn.carfactory.Car;

/**
 * @author FuQi
 * @date 2023/3/4 17:21
 * @description
 */
public class SpecificFactory2 implements AbstractFactory{
    @Override
    public Car produceCar() {
        System.out.println("具体工厂2制造汽车产品的具体产品2：BenChi");
        return new BenChi();
    }

    @Override
    public Phone producePhone() {
        System.out.println("具体工厂2制造手机产品的具体产品2：Huawei");
        return new HuaweiPhone();
    }
}
