package com.fuqi.gclearn;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

/**
 * @Description: 模拟一个简单的垃圾回收过程
 * @Author 傅琦
 * @date 2019/7/2 10:53
 * @Version V1.0
 */
public class GCTest1 {
    /**
     * 实现不断地产生新的对象，随机地销毁对象
     * 参数配置：-XX:+UseSerialGC -XX:+PrintGCDetails -Xms16m -Xmx16m
     * @param args
     */
    public static void main(String[] args) throws Exception {
        List<Object> list=  new ArrayList<>();
        while (true){
            int sleep = new Random().nextInt(100);

            if (System.currentTimeMillis() % 2 == 0){
                // 当前时间戳时偶数时，就清空list
                list.clear();
            }else {
                // 当前时间戳时奇数时，向list中添加10000个对象
                for (int i = 0; i < 10000; i++) {
                    Properties properties = new Properties();
                    properties.put("key_" + i, "value_" + System.currentTimeMillis() + i);
                    list.add(properties);
                }
            }

            Thread.sleep(sleep);
        }
    }
}
