package com.company.project.knowledge.base;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class BullsAndCows {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String answer = String.valueOf(randomNum());
        char[] answerChars = answer.toCharArray();
        int a = 0;
        int b = 0;
        int count = 8;
        boolean sucess = true;
        while (sucess){
            System.out.println("请输入你猜的数据");
            String number = input.next();
            char[] numberChars = number.toCharArray();
            for (int i = 0; i < answerChars.length; i++) {
                for (int j = 0; j < numberChars.length; j++) {
                    if (i == j){
                        if (answerChars[i] == numberChars[j]){
                            a++;
                        }
                    }else{
                        if (answerChars[i] == numberChars[j]){
                            b++;
                        }
                    }
                }
            }
            System.out.println(a+"A"+b+"B");
            System.out.println("还剩"+--count+"次");
            if (a == 4 && b == 0){
                sucess = false;
            }
            a = 0;
            b = 0;
        }
        System.out.println("正确答案"+answer);
    }

    public static int randomNum(){
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
        int result = 0;
        Random random = new Random();
        for (int i = 0, len = 9, index = 0; i < 4; i++) {
            index = random.nextInt(len);
            result = result * 10 + array[index];
            array[index] = array[len--];
        }
        return result;
    }
}
