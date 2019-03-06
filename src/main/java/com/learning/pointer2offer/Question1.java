package com.learning.pointer2offer;

/**
 * Desciption
 *
 * @author Claire.Chen
 * @create_time 2019 -03 - 05 17:57
 */

import java.util.Scanner;

/**
 * 问题描述：输入一个整数，输出该数二进制表示1的个数，其中负数使用补码表示
 */
public class Question1 {

    public  static void main(String[] args){
        System.out.println("请输入一个整数");
        Integer a = Integer.valueOf("1111", 2);

        Scanner sc = new Scanner(System.in);
        System.out.println(NumberOf13(sc.nextInt()));
    }
    public  static  int NumberOf11(int n){
        return Integer.bitCount(n);
    }

    public  static  int NumberOf12(int n){
        int count =0;
        int k =1;
        while(k!= 0){
            if((n & k) != 0){
                count ++;
            }
            k = k<<1;
        }
        return count;
    }

    //good
    public  static  int NumberOf13(int n){
        int count =0;
        while(n!= 0){
            count ++;
           n = n&(n-1);
        }
        return count;
    }



}
