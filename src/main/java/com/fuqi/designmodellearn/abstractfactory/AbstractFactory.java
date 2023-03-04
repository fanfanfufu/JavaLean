package com.fuqi.designmodellearn.abstractfactory;

import com.fuqi.designmodellearn.simplefactorymodulelearn.carfactory.Car;

public interface AbstractFactory {
    Car produceCar();

    Phone producePhone();
}
