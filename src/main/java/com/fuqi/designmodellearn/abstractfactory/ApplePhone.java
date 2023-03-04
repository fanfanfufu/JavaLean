package com.fuqi.designmodellearn.abstractfactory;

/**
 * @author FuQi
 * @date 2023/3/4 17:08
 * @description
 */
public class ApplePhone implements Phone{
    @Override
    public void showPhoneBrand() {
        System.out.println("this phone's brand is Apple.");
    }
}
