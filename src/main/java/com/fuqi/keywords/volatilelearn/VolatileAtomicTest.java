package com.fuqi.keywords.volatilelearn;

/**
 * @Description: volatile原子性测试
 * @Author 傅琦
 * @date 2019/8/4 21:58
 * @Version V1.0
 */
public class VolatileAtomicTest {
    public static volatile int num = 0;
    public static void increase(){
        num++;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        for (Thread th : threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                System.out.println("exception");
            }
        }

        // 理想结果为：1000*10=10000
        System.out.println(num);
    }
}
