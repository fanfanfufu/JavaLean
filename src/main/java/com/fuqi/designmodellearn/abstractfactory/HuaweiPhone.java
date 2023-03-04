package com.fuqi.designmodellearn.abstractfactory;

/**
 * @author FuQi
 * @date 2023/3/4 17:09
 * @description
 */
public class HuaweiPhone implements Phone{
    @Override
    public void showPhoneBrand() {
        System.out.println("this phone's brand is huawei.");
    }
}
