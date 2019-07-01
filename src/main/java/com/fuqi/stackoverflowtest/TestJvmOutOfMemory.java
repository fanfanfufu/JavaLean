package com.fuqi.stackoverflowtest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Description: 模拟内存溢出的情况
 * @Author: 傅琦
 * @DateTime: 2019/7/1 21:49
 * @Version: V1.0
 */
public class TestJvmOutOfMemory {
    /**
     * 向集合中添加100万个字符串，每个字符串由1000个UUID组成
     * 同时配置该类运行时的JVM参数：-Xms8m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            String str = "";
            for (int j = 0; j < 1000; j++) {
                str += UUID.randomUUID().toString();
            }
            list.add(str);
        }
        System.out.println("ok");
    }
}
