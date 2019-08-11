package com.fuqi.designmodellearn.proxymodellearn.dynamic;

/**
 * @Description
 * @Team 电子科技大学自动化研究所
 * @Author 傅琦
 * @date 2019/8/11 20:47
 * @Version V1.0
 */
public class ITeacherDaoImpl implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("老师正在授课中。。。。");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("hello, " + name);
    }
}
