package com.company.project.knowledge.base;

import java.util.Arrays;

/**
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 */
public class ArrayTest {

    private static int[] sortArray(int[] arr){
        int [] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i] * arr[i];
        }
        Arrays.sort(newArr);
        return newArr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-7,-3,2,3,11};
        int[] newArr = sortArray(arr);
        /*System.out.println(Arrays.toString(newArr));
        System.out.println(3 | 9);
        System.out.println(3 & 9);
        System.out.println(3<<4);*/
        String str = "http://192.168.9.167/group2/M00/16/7E/wKgJp1xj5R-AWEfYAAAVD6mb4I4424.jpg?visitType=ext&categoryId=1206&sign=YzNmYjE3MWIzZTc2OWFiZGMyNGUyZjRlMmY2NWFlNjg=";
        System.out.println(str.length());
        /**
         * 3 转换为二进制是 0011 向左移动4位 意思就是向右补0
         * 结果: 0011 0000
         * 转换为十进制 就是 2的5次方 + 2的四次方 32 + 16 = 48
         */
        System.out.println(2>>1);
        /**
         * 2 转换为二进制是 0010 向右移动1位 意思是往左补0
         * 结果：0000 0001
         * 转换为十进制 就是 2的0次方 1
         */
        /**  1    2    3    4    5    6    7    8    9    10  11  1 2  13    14   15
         * 0001 0010 0011 0100 0101 0110 0111 1000 1001 1010 1011 1100 1101 1110 1111
         *   16           17          18            19          20
         * 0001 0000 0001 0001 0001 0010 0001 0011 0001 0100 0001 0101
         */

    }
}
