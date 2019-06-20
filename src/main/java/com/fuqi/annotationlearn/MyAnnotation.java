package com.fuqi.annotationlearn;

import java.lang.annotation.*;

/**
 * @Description: 自定义注解练习
 * 1. 注解声明为@interface
 * 2. 内部类成员，通常使用value表示
 * 3. 可以指定成员的默认值，使用default定义
 * 4. 如果自定义注解有成员且成员没有默认值，使用时需要指定成员的值
 * 4. 如果自定义注解没有成员，标明是一个标识作用
 * @author 傅琦
 * @date 2019/6/20 15:18
 * @version V1.0
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE})
public @interface MyAnnotation {

    String value() default "hello";
}
