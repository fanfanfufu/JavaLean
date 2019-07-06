package com.fuqi.somequestion;

/**
 * @Description: 两个对象的 hashCode() 相同，则 equals() 也一定为 true，对吗？
 * @Author: 傅琦
 * @DateTime: 2019/7/6 16:40
 * @Version: V1.0
 */
public class question001 {
    /**
     * 两个对象的 hashCode() 相同
     * 但是equels方法的返回值却不同
     * @param args
     */
    public static void main(String[] args) {
        String str1 = "通话";
        String str2 = "重地";
        // true
        System. out. println(String. format("str1：%d | str2：%d",  str1. hashCode(),str2. hashCode()));
        // false
        System. out. println(str1. equals(str2));
    }
}
