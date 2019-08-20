package com.fuqi.threadlearning.locklearn.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @Author 傅琦
 * @date 2019/8/20 22:16
 * @Version V1.0
 */
public class AtomicIntegerTest {
    private static AtomicInteger count = new AtomicInteger(0);

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
                    // 同样可以保证最终结果是200
                    for (int j = 0; j < 100; j++) {
                        count.incrementAndGet();
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("count = " + count);
    }
}
