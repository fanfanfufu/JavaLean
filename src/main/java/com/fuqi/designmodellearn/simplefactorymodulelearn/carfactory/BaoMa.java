package com.fuqi.designmodellearn.simplefactorymodulelearn.carfactory;

/**
 * @author FuQi
 * @date 2023/3/4 13:11
 * @description
 */
public class BaoMa implements Car{

    @Override
    public void showBrand() {
        System.out.println("this car's brand is BaoMa!");
    }
}
