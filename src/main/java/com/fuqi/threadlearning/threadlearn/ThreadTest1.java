package com.fuqi.threadlearning.threadlearn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 测试线程安全
 * @Author 傅琦
 * @date 2019/6/28 16:51
 * @Version V1.0
 */
public class ThreadTest1 {
    private static boolean allThreadTerminated(List<Thread> threads){
        for (Thread thread: threads) {
            if (thread.isAlive()){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Count count = new Count();
        Runnable runnable = () -> {
            for (int i = 0; i < 10000; i++) {
                count.increment();
            }
        };

        List<Thread> threads = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }

        while (true) {
            if (allThreadTerminated(threads)){
                // 所有线程运行结束
                // 期望输出结果为：100000，但是该结果不一定保证每次运行都有
                System.out.println(count.get());
                break;
            }
        }
    }
}
