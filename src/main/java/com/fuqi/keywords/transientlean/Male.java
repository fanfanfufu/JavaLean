package com.fuqi.keywords.transientlean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: Male实体类
 * @Author 傅琦
 * @Date 2019/5/29 22:12
 * @Version V1.0
 */
@AllArgsConstructor
@Data
public class Male implements Serializable {
    private static final long serialVersionUID = 405573135826470637L;
    private transient static String name = "李雷";
    private int age;
    private transient int salary;
    private final transient String description = "男";

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Male.name = name;
    }
}
