package com.fuqi.designmodellearn.simplefactorymodulelearn.carfactory;

/**
 * @author FuQi
 * @date 2023/3/4 13:15
 * @description
 */
public class SimpleCarFactoryTest {
    public static void main(String[] args) {
        SimpleCarFactory factory = new SimpleCarFactory();
        Car baoma = factory.getCar("baoma");
        baoma.showBrand();
        System.out.println("+++++++++++++++++");
        Car benchi = factory.getCar("benchi");
        benchi.showBrand();
    }
}
