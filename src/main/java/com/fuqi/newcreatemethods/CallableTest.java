package com.fuqi.newcreatemethods;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description: 创建线程的方式三：实现Callable接口
 *
 * 1. 创建一个实现Callable的实现类
 * 2. 重写call()方法，将需要执行的操作生命在其中
 * 3. 创建Callable接口实现类的对象
 * 4. 将此实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask的对象
 * 5. 将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()方法
 * 6. 若重写的call()方法返回值不为空，则获取其返回值。
 *
 * @Author 傅琦
 * @Date 2019/6/15 14:43
 * @Version V1.0
 */
public class CallableTest {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();

        FutureTask futureTask = new FutureTask(numThread);

        new Thread(futureTask).start();

        try {
            // get()的返回值几位FutureTask构造器参数Callable实现类重写的call()方法的返回值
            Object sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class NumThread implements Callable{
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i < 101; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
                sum += i;
            }
        }

        return sum;
    }
}
