package com.fuqi;

import java.util.Scanner;

/**
 * @Description: 从键盘分别输入年月日，判断这一天是当年的第几天
 *
 * 注意：要判断闰年：①能被4整除，但不能被100整除；或者是可以被400整除
 *
 * @Author 傅琦
 * @Date 2019/6/17 14:41
 * @Version V1.0
 */
public class SwitchCaseExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年：");
        int year = scanner.nextInt();
        System.out.println("请输入月：");
        int month = scanner.nextInt();
        System.out.println("请输入天：");
        int day = scanner.nextInt();
        scanner.close();

        if (month < 1 && month > 12){
            System.out.println("输入的月份不合常理");
            return;
        }
        if (day < 28 && day > 31){
            System.out.println("输入的天不合常理");
            return;
        }

        // 定义一个变量来保存总天数
        int sumDays = 0;
        switch (month){
            case 12:
                sumDays += 30;
            case 11:
                sumDays += 31;
            case 10:
                sumDays += 30;
                break;
            case 9:
                sumDays += 31;
            case 8:
                sumDays += 31;
            case 7:
                sumDays += 30;
            case 6:
                sumDays += 31;
            case 5:
                sumDays += 30;
            case 4:
                sumDays += 31;
            case 3:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
                    sumDays += 29;
                }else {
                    sumDays += 28;
                }
            case 2:
                sumDays += 31;
            case 1:
                sumDays += day;
            default:
                System.out.println("输入的数据有误");
        }

        System.out.println("今天是" + year + "年的第" + sumDays + "天");
    }
}
