package com.fuqi.designmodellearn.simplefactorymodulelearn.carfactory;

/**
 * @author FuQi
 * @date 2023/3/4 13:13
 * @description
 */
public class SimpleCarFactory {
    /**
     * 根据品牌名称提供对应品牌的车
     *
     * @param brand
     * @return
     */
    public Car getCar(String brand) {
        if ("baoma".equals(brand)) {
            return new BaoMa();
        } else if ("benchi".equals(brand)) {
            return new BenChi();
        }

        return null;
    }
}
