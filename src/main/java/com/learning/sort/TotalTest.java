package com.learning.sort;

import java.util.Arrays;

/**
 * Desciption
 *
 * @author Claire.Chen
 * @create_time 2019 -03 - 06 17:10
 */
public class TotalTest {

    public static void main(String[] args){
        int[] a = new int[]{4,2,7,1,8,3};
        int[] tmp = new int[a.length];
        MergeSort1(a,tmp,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static void ChoiceSort1(int[] a){
        for(int i =0 ; i<a.length-1 ; i++){
            int min = i;
            for(int j = i+1 ; j < a.length ;j++){
                if(a[j] < a[min]){
                    min = j;
                }
            }
            if(min != i){
                int tmp = a[i];
                a[i] = a[min];
                a[min] = tmp;
            }
        }
    }
    public static void BubbleSort1(int[] a) {

      for(int i = a.length -1 ; i>0 ; i--){
          boolean flag = true;
          for(int j = 0 ; j< i  ; j++){
              if(a[j] > a[j+1]){
                  int tmp = a[j];
                  a[j] = a[j+1];
                  a[j+1] = tmp;
                  flag = false;
              }
          }
          if(flag){
              break;
          }
      }
    }

    public static void QuickSort1(int[] a,int left ,int right) {
    if(left < right){
        int i = left;
        int j = right;
        int x = a[i];
        while(i<j){
            while(i<j && a[j] > x){
                j--;
            }
            if(i<j){
                a[i++] =a[j];
            }
            while(i<j && a[i]<x){
                i++;
            }
            if(i<j){
                a[j--]= a[i];
            }

        }
        a[i] = x;
        QuickSort1(a,left,i-1);
        QuickSort1(a,i+1,right);
    }
    }


    public  static  void MergeSort1(int[] a,int[] tmp,int left,int right){
        if(left < right){
            int center  = (left + right)/2;
            MergeSort1(a,tmp,left,center);
            MergeSort1(a,tmp,center+1,right);
            merge(a,tmp,left,right,center);
        }

    }

    public static void merge(int[] a, int[] tmp,int left , int right ,int center){
        int i = left;
        int j = center + 1;
        for(int k = left ; k<= right ; k++){
            if(i>center){
                tmp[k] = a[j++];
            }else if(j >right){
                tmp[k] = a[i++];
            }else if(a[i] > a[j]){
                tmp[k] = a[j++];
            }else if(a[i] <= a[j]){
                tmp[k]= a[i++];
            }
        }
        System.arraycopy(tmp,left,a,left,right-left +1);
    }


}
