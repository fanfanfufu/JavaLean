package com.fuqi.threadlearning.locklearn.cas;

/**
 * @Description
 * @Author 傅琦
 * @date 2019/8/20 22:10
 * @Version V1.0
 */
public class SimpleExample {
    private static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    // 每个线程让count自增100次
                    for (int j = 0; j < 100; j++) {
                        // 加了synchronized之后，线程安全，所以最终结果一定是200
                        synchronized (SimpleExample.class){
                            count++;
                        }
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(count);
    }
}
