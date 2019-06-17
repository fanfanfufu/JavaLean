package com.fuqi;

/**
 * @Description: String、StringBuffer、StringBuilder对比分析
 * 执行效率对比结果：在操作次数大的时候才能看出StringBuilder比StingBuffer效率高，但两者的效率都远大于String
 * 所以执行效率从高到低：StringBuilder ——> StringBuffer ——> String
 * @Author 傅琦
 * @Date 2019/6/17 19:54
 * @Version V1.0
 */
public class StringBufferBuilder {
    public static void main(String[] args) {
        // 初始设置
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        // 开始对比
        // StringBuffer
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 2000000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime-startTime));

        // StringBuilder
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 2000000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime-startTime));

        // String
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime-startTime));
    }
}
