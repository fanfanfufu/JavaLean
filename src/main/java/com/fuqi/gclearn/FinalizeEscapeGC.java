package com.fuqi.gclearn;

/**
 * @Description: 演示2点：
 * 1. 对象可以在被GC时自我拯救
 * 2. 这种自救的机会只有一次，因为一个对象的finalize()方法最多只会被系统调用一次
 * @Author 傅琦
 * @date 2019/7/3 20:44
 * @Version V1.0
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("Yes,i am still alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable {
        // 第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        // 因为finalize方法优先级很低，所以暂停0.5秒等待其被调用
        Thread.sleep(500);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("first survival failure, i am dead");
        }

        // 第二次自救，但是会失败
        SAVE_HOOK = null;
        System.gc();
        // 因为finalize方法优先级很低，所以暂停0.5秒等待其被调用
        Thread.sleep(500);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("second survival failure, i am dead");
        }
    }
}
