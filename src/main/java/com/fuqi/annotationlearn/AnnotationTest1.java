package com.fuqi.annotationlearn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;

/**
 * @Description: Annotation学习1
 * @author 傅琦
 * @date 2019/6/20 14:55
 * @version V1.0
 */
public class AnnotationTest1 {
    public static void main(String[] args) {
        Students students = new Students();
        students.walk();
        students.show();

        @SuppressWarnings("unused")
        int num = 10;
//        System.out.println("num = " + num);
    }

    @Test
    public void testGetAnnotations(){
        Class clazz = Students.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println("annotations = " + annotations[i]);
        }

    }
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MyAnnotation
class Person{
    private String name;
    private int age;

    public void walk(){
        System.out.println("人走路");
    }

    public void eat(){
        System.out.println("人吃饭");
    }
}

interface Info{
    void show();
}

class Students extends Person implements Info{
    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    @Override
    public void show() {
        System.out.println(System.currentTimeMillis());
    }
}
