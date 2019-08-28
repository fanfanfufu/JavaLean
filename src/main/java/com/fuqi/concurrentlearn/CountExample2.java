package com.fuqi.concurrentlearn;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/8/28 21:07
 * @Version V1.0
 */
public class CountExample2 {
    private static Map<Integer, Integer> map = Maps.newHashMap();

    private static int threadNum = 1;
    private static int clientNum = 5000;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadNum);
        for (int i = 0; i < clientNum; i++) {
            final int threadNum = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    func(threadNum);
                    semaphore.release();
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
        System.out.println("map.size is: " + map.size());
    }

    private static void func(int threadNum){
        map.put(threadNum, threadNum);
    }
}
