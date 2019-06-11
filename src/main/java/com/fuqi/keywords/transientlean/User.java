package com.fuqi.keywords.transientlean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: User实体类
 * @Author 傅琦
 * @Date 2019/5/29 21:56
 * @Version V1.0
 */
@AllArgsConstructor
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 8645066796013228213L;
    private String username;
    private int age;
    private transient String password;
}
