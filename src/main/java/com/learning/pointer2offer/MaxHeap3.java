package com.learning.pointer2offer;

import java.util.Arrays;

/**
 * Desciption
 *
 * @author Claire.Chen
 * @create_time 2019 -03 - 06 18:38
 */
public class MaxHeap3<T extends Comparable<? super T>> {
        private T[] data;
        private int size;
        private int capacity;
        public MaxHeap3(int capacity) {
            this.data = (T[]) new Comparable[capacity + 1];
            size = 0;
            this.capacity = capacity;
        }
        public int size() {
            return this.size;
        }
        public Boolean isEmpty() {
            return size == 0;
        }
        public int getCapacity() {
            return this.capacity;
        }
        /**
         * @return 查看最大根(只看不删, 与popMax对比)
         */
        public T seekMax() {
            return data[1];
        }
        public void swap(int i, int j) {
            if (i != j) {
                T temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        public void insert(T item) {
            size++;
            data[size] = item;
            shiftUp(size);
        }
        /**
         * @return 弹出最大根(弹出意味着删除, 与seekMax对比)
         */
        public T popMax() {
            swap(1, size--);
            shiftDown(1);
            return data[size + 1];
        }
        /**
         * @param child 孩子节点下角标是child，父节点下角表是child/2
         */
        public void shiftUp(int child) {
            while (child > 1 && data[child].compareTo(data[child / 2]) > 0) {
                swap(child, child / 2);
                child = child / 2;
            }
        }
        /**
         * @param a data数组中某个元素的下角标
         * @param b data数组中某个元素的下角标
         * @return 哪个元素大就返回哪个的下角标
         */
        private int max(int a, int b) {
            if (data[a].compareTo(data[b]) < 0) {
                //如果data[b]大
                return b;
                //返回b
            } else {
                //如果data[a]大
                return a;
                //返回a
            }
        }
        /**
         * @param a data数组中某个元素的下角标
         * @param b data数组中某个元素的下角标
         * @param c data数组中某个元素的下角标
         * @return 哪个元素大就返回哪个的下角标
         */
        private int max(int a, int b, int c) {
            int biggest = max(a, b);
            biggest = max(biggest, c);
            return biggest;
        }
        /**
         * @param father 父节点下角标是father,左右两个孩子节点的下角表分别是：father*2 和 father*2+1
         */
        public void shiftDown(int father) {
            while (true) {
                int lchild = father * 2;
                //左孩子
                int rchild = father * 2 + 1;
                //右孩子
                int newFather = father;
                //newFather即将更新，父、左、右三个结点谁大，newFather就是谁的下角标
                if (lchild > size) {
                    //如果该father结点既没有左孩子，也没有右孩子
                    return;
                } else if (rchild > size) {
                    //如果该father结点只有左孩子，没有右孩子
                    newFather = max(father, lchild);
                } else {
                    //如果该father结点既有左孩子，又有右孩子
                    newFather = max(father, lchild, rchild);
                }
                if (newFather == father) {
                    //说明father比两个子结点都要大，表名已经是大根堆，不用继续调整了
                    return;
                } else {
                    //否则，还需要继续调整堆，直到满足大根堆条件为止
                    swap(father, newFather);
                    //值进行交换
                    father = newFather;
                    //更新father的值，相当于继续调整shiftDown(newFather)
                }
            }
        }
        public static void main(String[] args) {
            //创建大根堆
            MaxHeap3<Integer> maxHeap = new MaxHeap3<Integer>(8);
            //向堆里存
            int[] a = new int[]{4,5,1,6,2,7,3,8};
            for (int i = 0; i < a.length; i++) {
                maxHeap.insert(a[i]);
            }
            while(maxHeap.size >4){
                maxHeap.popMax();
            }
            Integer[] tmp = new Integer[4];
            System.arraycopy(maxHeap.data,1,tmp,0,4);
            System.out.println(Arrays.toString(tmp));
        }
    }

