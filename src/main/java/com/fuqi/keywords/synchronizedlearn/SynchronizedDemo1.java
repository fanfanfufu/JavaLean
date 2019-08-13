package com.fuqi.keywords.synchronizedlearn;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/8/13 10:02
 * @Version V1.0
 */
public class SynchronizedDemo1 {
    public void method() {
        synchronized (this){
            System.out.println("synchronized code");
        }
    }
}
