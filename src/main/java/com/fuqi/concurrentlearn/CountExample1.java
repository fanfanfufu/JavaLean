package com.fuqi.concurrentlearn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Description: 一个简单的计数demo
 * @Author 傅琦
 * @date 2019/8/28 20:59
 * @Version V1.0
 */
public class CountExample1 {
    private static int threadTotal = 1;
    private static int clientTotal = 5000;

    private static long count = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
        System.out.println("count: " + count);
    }

    private static void add(){
        count++;
    }
}
