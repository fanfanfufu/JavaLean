package com.fuqi.stackoverflowtest;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/7/1 18:15
 * @Version V1.0
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        // true
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        // false
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
