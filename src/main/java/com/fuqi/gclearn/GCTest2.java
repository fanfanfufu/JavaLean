package com.fuqi.gclearn;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Description: 测试使用jstat查看使用了G1垃圾收集器的代码运行时，gc的各个状态
 * @Author: 傅琦
 * @DateTime: 2019/7/31 23:20
 * @Version: V1.0
 */
public class GCTest2 {
    public static void main(String[] args) {
        // 创建一个计时器
        Timer timer = new Timer();

        // 开启一个计时调度，延迟 0毫秒（也就是立即开始执行），调度评率： 1秒
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // 生成随机数逻辑
                Random r = new Random();
                int num = r.nextInt(10) + 1;
                System.out.println("随机数为：" + num);
            }
        }, 0L, 3000L);

        // timer.cancel();  // 关闭计时器
    }
}
