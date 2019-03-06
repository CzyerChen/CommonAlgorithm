package com.learning.pointer2offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Desciption
 *
 * @author Claire.Chen
 * @create_time 2019 -03 - 06 17:58
 */
public class MinHeap {

    private int[] values = new int[16];

    private int size;


    /**
     * 移除并获取一个堆顶元素
     *
     * @return 堆顶元素
     */
    public int poll() {
        if (size <= 0) throw new IllegalStateException("不存在元素");
        int value = values[0];
        values[0] = values[--size]; //将最后一个元素提到堆顶
        values[size] = 0; //清空最后一个的数据
        fixDown(); //下沉操作
        return value;
    }


    /**
     * 下沉
     *
     * @return 下沉到适合位置的index
     */
    private int fixDown() {
        int f = 0; //父节点的index
        int k;  //较小者子节点的index
        while ((k = (f << 1) + 1) < size) { //至少存在左子节点
            if (k < size - 1) {   //存在右子节点
                if (values[k] > values[k + 1]) k++; //左右子节点进行比较。
            }
            if (values[f] <= values[k]) break; //父节点小于较小者子节点，则找到合适的位置，退出循环
            int temp = values[f];
            values[f] = values[k];
            values[k] = temp;
            f = k;
        }
        return f;
    }

    /**
     * 上浮
     *
     * @return
     */
    private int fixUp() {
        int j = size - 1;   //最后一个元素的下标
        int f; //父节点的下标
        while ((f = ((j - 1) >> 1)) >= 0) { //通过父节点的下标
            if (values[f] <= values[j]) break; //父节点的值小于子节点的值，则打适合的位置。
            int temp = values[f];
            values[f] = values[j];
            values[j] = temp;
            j = f;
        }
        return f;
    }

    /**
     * 添加一个元素在最小堆中上
     *
     * @return
     */
    public int push(int item) {
        if (size >= values.length) Arrays.copyOf(values, size << 1);
        values[size++] = item;
        return fixUp();
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        int[] a = new int[]{4,5,1,6,2,7,3,8};
        for(int i = 0 ; i < a.length ; i ++){
            heap.push(a[i]);
        }
        List<Integer> list =new ArrayList<Integer>();
        while (heap.size >4){
            int poll = heap.poll();
            list.add(poll);
        }
        System.out.println(list);

    }
}
