package com.company.project.knowledge.base;

public class Fibonacci {

    static int fibonacci(int number) {
        if (number <= 0) {
            return 0;
        }
        if (number == 1 || number == 2) {
            return 1;
        }
        int first = 1, second = 1, third = 0;
        for (int i = 3; i <= number; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    public static int fibonacci1(int n) {

        if (n <= 0) {
            return 0;
        }
        if (n == 1||n==2) {
            return 1;
        }

        return fibonacci1(n - 2) + fibonacci1(n - 1);

    }

    static int jumpFloorII(int number) {
        //2^(number-1)用位移操作进行，更快
        return 1 << --number;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        //int result = fibonacci(100000);
        //int result = fibonacci1(45);
        int result = jumpFloorII(4);
        long endTime = System.currentTimeMillis();
        System.out.println("运行结果："+result+"运行时间："+(endTime-startTime)+"ms");
    }
}
