package com.fuqi.keywords.volatilelearn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/8/5 14:59
 * @Version V1.0
 */
public class VolatileSerialTest {
    private static int x;
    private static int y;

    public static void main(String[] args) {
        Set<String> resultSet = new HashSet<>();
        Map<String, Integer> resultMap = new HashMap<>();

        for (int i = 0; i < 1000000; i++) {
            x = 0;
            y = 0;
            resultMap.clear();
            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    int a = y;
                    x = 1;
                    resultMap.put("a", a);
                }
            });

            Thread two = new Thread(new Runnable() {
                @Override
                public void run() {
                    int b = x;
                    y = 1;
                    resultMap.put("b", b);
                }
            });

            one.start();
            two.start();
            try {
                one.join();
                two.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            resultSet.add("a=" + resultMap.get("a")+ ", " + "b=" + resultMap.get("b"));
            System.out.println(resultSet);
        }
    }
}
