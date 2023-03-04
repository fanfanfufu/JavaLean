package com.fuqi.designmodellearn.simplefactorymodulelearn.carfactory;

/**
 * @author FuQi
 * @date 2023/3/4 13:12
 * @description
 */
public class BenChi implements Car{
    @Override
    public void showBrand() {
        System.out.println("this car's brand is BenChi!");
    }
}
