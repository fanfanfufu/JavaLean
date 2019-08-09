package com.fuqi.designmodellearn.singletonlearn;

/**
 * @Description: 单例模式实现方式之————使用静态内部类实现（）
 * @Author 傅琦
 * @date 2019/8/9 21:13
 * @Version V1.0
 */
public class SingletonTest5 {
}

class Tom {
    private Tom(){}

    private static class TomInstance {
        private static final Tom INSTANCE = new Tom();
    }

    public static Tom getInstance() {
        return TomInstance.INSTANCE;
    }
}
