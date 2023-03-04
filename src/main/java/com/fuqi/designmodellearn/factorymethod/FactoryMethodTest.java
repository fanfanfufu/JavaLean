package com.fuqi.designmodellearn.factorymethod;

import com.fuqi.designmodellearn.simplefactorymodulelearn.carfactory.Car;

import java.util.Collection;

/**
 * @author FuQi
 * @date 2023/3/4 14:26
 * @description
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        BaoMaFactory baoMaFactory = new BaoMaFactory();
        Car baoma = baoMaFactory.produceCar();
        baoma.showBrand();
        System.out.println("===============================");
        BenChiFactory benChiFactory = new BenChiFactory();
        Car benchi = benChiFactory.produceCar();
        benchi.showBrand();
    }
}
