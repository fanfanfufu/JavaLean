package com.fuqi.designmodellearn.abstractfactory;

import com.fuqi.designmodellearn.simplefactorymodulelearn.carfactory.Car;

/**
 * @author FuQi
 * @date 2023/3/4 17:38
 * @description
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractFactory specificFactory1 = new SpecificFactory1();
        Car baoma = specificFactory1.produceCar();
        baoma.showBrand();
        Phone applePhone = specificFactory1.producePhone();
        applePhone.showPhoneBrand();
        System.out.println("==================================");
        AbstractFactory specificFactory2 = new SpecificFactory2();
        Car benchi = specificFactory2.produceCar();
        benchi.showBrand();
        Phone huawei = specificFactory2.producePhone();
        huawei.showPhoneBrand();
    }
}
