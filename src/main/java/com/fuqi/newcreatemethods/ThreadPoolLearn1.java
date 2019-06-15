package com.fuqi.newcreatemethods;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Description: 创建线程的方式四：使用线程池
 * @Author 傅琦
 * @Date 2019/6/15 16:25
 * @Version V1.0
 */
public class ThreadPoolLearn1 {
    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

        ExecutorService executorService = new ThreadPoolExecutor(5, 10, 2000L ,TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

//        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // 设置线程池的属性
        // ThreadPoolExecutor service = (ThreadPoolExecutor) executorService;
        // service.setCorePoolSize(5);

        // execute方法适合用于实现了Runnable接口的类
        executorService.execute(new NumberThread());
        executorService.execute(new NumberThread());

        executorService.shutdown();
    }
}

class NumberThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 101; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
