package com.fuqi.designmodellearn.simplefactorymodulelearn.pizzastore.pizza;

/**
 * @Description
 * @Author 傅琦
 * @date 2019/8/9 21:43
 * @Version V1.0
 */
public abstract class Pizza {
    protected String name;

    public abstract void prepare();

    public void bake(){
        System.out.println(name + " baking;");
    }

    public void cut(){
        System.out.println(name + " cutting;");
    }

    public void box(){
        System.out.println(name + " boxing;");
    }

    public void setName(String name){
        this.name = name;
    }
}
