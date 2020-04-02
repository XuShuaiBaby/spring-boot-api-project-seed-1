package com.company.project.knowledge.base;

import java.util.*;

public class BullsAndCows {
    //每次递推获取新数字的下标
    private static int first = 0;
    private static int last = 4;
    public static void main(String[] args) {
        //随机生成的答案
        int[] answerChars = randomNum();
        //存放计算结果
        Set<Number> trueNumber = new HashSet<>();
        calculate(trueNumber,answerChars);
    }

    public static void calculate(Set<Number> trueNumber,int[] answerChars) {
        // A的个数，B的个数
        int a = 0;
        int b = 0;
        //限定游戏次数
        int count = 8;
        boolean sucess = true;
        while (sucess) {
            System.out.println("请输入你猜的数据");
            int[] numberChars = groupNextNumber(trueNumber);
            System.out.println(Arrays.toString(numberChars));
            for (int i = 0; i < answerChars.length; i++) {
                for (int j = 0; j < numberChars.length; j++) {
                    if (i == j) {
                        if (answerChars[i] == numberChars[j]) {
                            trueNumber.add(new Number(i, answerChars[i]));
                            a++;
                        }
                    } else {
                        if (answerChars[i] == numberChars[j]) {
                            trueNumber.add(new Number(i, answerChars[i]));
                            b++;
                        }
                    }
                }
            }
            System.out.println(a + "A" + b + "B");
            System.out.println("还剩" + --count + "次");
            if (count == 0) {
                sucess = false;
                System.out.println("次数用完，游戏结束");
            }
            if (a == 4 && b == 0) {
                sucess = false;
                System.out.println("回答正常，答案是" + Arrays.toString(answerChars));
            }
            a = 0;
            b = 0;
        }
    }

    public static int[] groupNextNumber(Set<Number> trueNumber){
        int[] nextNum = new int[]{-1,-1,-1,-1};
        if (trueNumber.isEmpty()){
            int[] ints = generateNum(first, last);
            first = last++;
            last += 3;
            return ints;
        }else {
            last = first + (4 - trueNumber.size());
        }
        for (Number n : trueNumber){
            nextNum[n.getIndex()] = n.getValue();
        }
        int[] next = generateNum(first, last);
        first = last;
        for (int i = 0,j = 0;i < nextNum.length; i++){
            if (nextNum[i] == -1){
                nextNum[i] = next[j];
                j++;
            }
        }
        return nextNum;
    }

    public static int[] generateNum(int first,int last){
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
        int[] numberChars = new int[4];
        for (int i = first,j =0; i < last; i++,j++) {
            numberChars[j] = array[i] ;
        }
        return numberChars;
    }

    public static int[] randomNum(){
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
        int[] result = new int[4];
        Random random = new Random();
        for (int i = 0, len = 9, index; i < 4; i++) {
            index = random.nextInt(len);
            result[i] = array[index];
            array[index] = array[len--];
        }
        return result;
    }

    static class Number{
        private int index;
        private int value;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Number number = (Number) o;
            return index == number.index &&
                value == number.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, value);
        }



        public Number(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
