package com.fuqi;

/**
 * @Description: 练习System.arraycopy方法的使用
 * 		a. 方法名：
 * 			public static native void System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)：
 * 		b. 参数说明：
 * 			Object src : 原数组
 * 			int srcPos : 从元数据的起始位置开始（注意不能越界）
 * 			Object dest : 目标数组
 * 			int destPos : 目标数组的开始起始位置（注意不能越界）
 *          int length  : 要copy的数组的长度（注意不能越界）
 * @Author 傅琦
 * @Date 2019/6/17 23:01
 * @Version V1.0
 */
public class ArrayCopyLearning {
    public static void main(String[] args) {
        int[] src = new int[]{1,2,3,4,5,6,7,8,9};
        int[] dest1 = new int[5];
        // 1 2 3 0 0
        System.arraycopy(src, 0, dest1, 0, 3);
        for (int num: dest1) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("**************************");
        // 5 6 7 0 0
        System.arraycopy(src, 4, dest1, 0, 3);
        for (int num: dest1) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("**************************");
        int[] dest2 = new int[5];
        // 0 0 5 6 7
        System.arraycopy(src, 4, dest2, 2, 3);
        for (int num: dest2) {
            System.out.print(num + " ");
        }
    }
}
