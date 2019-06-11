package com.fuqi.keywords.transientlean;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Description: 测试transient关键字的作用
 * @Author 傅琦
 * @Date 2019/5/29 22:02
 * @Version V1.0
 */
public class TestTransient {
    public static void main1(String[] args){
        // 初始化一个对象
        User user = new User("李雷", 20, "lilei123");
        System.out.println(user);
        // 将对象进行序列化
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.txt"));
            oos.writeObject(user);
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        // 反序列化对象
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.txt"));
            User userRead = (User) ois.readObject();
            System.out.println(userRead);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Male male = new Male(15, 25000);
        System.out.println(Male.getName() + ": " + male);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("male.txt"));
            oos.writeObject(male);
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        // 反序列化对象
        try {
            Male.setName("韩梅梅");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("male.txt"));
            Male maleRead = (Male) ois.readObject();
            System.out.println(Male.getName() + ": " + maleRead);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
