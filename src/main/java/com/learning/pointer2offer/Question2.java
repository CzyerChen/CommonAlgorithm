package com.learning.pointer2offer;

/**
 * Desciption
 *
 * @author Claire.Chen
 * @create_time 2019 -03 - 05 18:37
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 问题：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Question2 {
    /**
     * 运行时间：243ms
     * 占用内存：28136k
     */
    /**
     * 运行时间：237ms
     * 占用内存：27864k
     */

    /**
     * 运行时间：275ms
     * 占用内存：29836k
     */
    /**
     * 运行时间：287ms
     * 占用内存：30012k
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{6, 2, 5, 8, 1, 4, 5, 9};
        /*List<Integer> list = new ArrayList<Integer>();
        for(int i : a){
            list.add(i);
        }
        int index = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                index = i;
                break;
            }
        }

        Collections.rotate(list,a.length-(index+1));
        System.out.println(list.get(0));*/

       /* int[] b = new int[index+1];
        int[] c = new int[a.length-index-1];

        for(int i = 0 ; i<= index;i++){
            b[i] = a[i];
        }
        for(int i = index+1; i< a.length; i++){
            c[i-index-1] = a[i];
        }
        int[] d = new int[a.length];
        for(int i =0 ;i < c.length ; i++){
            d[i] = c[i];
        }
        for(int i = c.length;i<b.length+c.length;i++){
            d[i] = b[i-c.length];
        }*/
        /*Collections.rotate(list, index + 1);*/
        int i = 0;
        int j = array.length - 1;
        int small = array[(i + j) / 2];
        while (i < array.length - 1 && j > 0) {
            if (j < i) {
                break;
            }
            if (array[i] < small) {
                small = array[i];

            }
            if (array[j] < small) {
                small = array[j];

            }
            i++;
            j--;
            /*if (array[j] < small) {
                small = array[j];
                i++;
            } else {
                small = array[i];
                j--;
            }*/
        }

    }


    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;

        int low = 0;
        int high = array.length - 1;
        int mid = low;
        while (array[low] >= array[high]) {
            if (array[low] == array[high]) {
                for (int i = low; i < array.length; i++) {
                    if (array[low] != array[i]) {
                        low = i - 1;
                        break;
                    }
                }
                for (int i = high; i >= 0; i--) {
                    if (array[high] != array[i]) {
                        high = i + 1;
                        break;
                    }
                }
            }
            if (high - low <= 1) {
                mid = high;
                break;
            }
            mid = (low + high) / 2;
            if (array[mid] >= array[low]) {
                low = mid;
            } else if (array[mid] <= array[high]) {
                high = mid;
            }
        }
        return array[mid];
    }

    /**
     * 运行时间：357ms
     * 占用内存：27744k
     * @param array
     * @return
     */
    public int test(int[] array) {

        if (array == null || array.length == 0)
            return 0;
        int low = 0;
        int high = array.length - 1;
        int mid = low;
        while (array[low] >= array[high]) {
            if (array[low] == array[high]) {
                for (int i = low; i < array.length; i++) {
                    if (array[low] != array[i]) {
                        low = i - 1;
                        break;
                    }
                }
                for (int i = high; i >= 0; i--) {
                    if (array[high] != array[i]) {
                        high = i + 1;
                        break;
                    }
                }
            }
            if (high - low <= 1) {
                mid = high;
                break;
            }
            mid = (low + high) / 2;
            if (array[mid] >= array[low]) {
                low = mid;
            } else if (array[mid] <= array[high]) {
                high = mid;
            }
        }
        return array[mid];
    }


    /**
     * 运行时间：324ms
     * 占用内存：27952k
     * @param array
     * @return
     */
    public  int test1(int[] array){
        if(array==null||array.length==0){
            return 0;
        }
        int len=array.length;
        return findmin(array,0,len-1);
    }
    int findmin(int [] array,int left,int right){
        if(left>=right||array[left]<array[right]){
            return array[left];
        }
        int mid;
        mid=(left+right)/2;
        if(array[mid]>array[left]){
            return findmin(array,mid+1,right);
        }
        else if(array[mid]==array[left]){
            return findmin(array,mid+1,right)<findmin(array,left,mid-1)?findmin(array,mid+1,right):findmin(array,left,mid-1);
        }
        else{
            return findmin(array,left,mid);
        }
    }


}
