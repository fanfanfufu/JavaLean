package com.fuqi.stackoverflowtest;

/**
 * @Description:
 * @Author 傅琦
 * @Date 2019/6/19 22:39
 * @Version V1.0
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable{
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            // 本机上测试结果：stack length = 36502
            System.out.println("stack length = " + oom.stackLength);
            throw e;
        }
    }
}
