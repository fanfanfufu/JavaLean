package com.fuqi.keywords.volatilelearn;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/8/4 17:15
 * @Version V1.0
 */
public class VolatileVisibilityTest {
    /**
     * 不加volatile关键字的控制台输出结果：
     * waiting data...
     * prepare...
     * prepare data end!
     *
     */
    private static volatile boolean initFlag = false;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("waiting data...");
                while (!initFlag){

                }
                System.out.println("==============success");
            }
        }).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                prepareData();
            }
        }).start();
    }

    private static void prepareData(){
        System.out.println("prepare...");
        initFlag = true;
        System.out.println("prepare data end!");
    }
}
