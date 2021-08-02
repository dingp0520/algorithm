package com.demo.sort;

import java.util.Arrays;

/**
 * 插入排序-从小到大
 * 空间复杂度:O(1) 原地排序算法
 * 时间复杂度:O(n) - O(n^2)
 * 稳定排序算法
 */
public class Insert {

    private void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int j = i - 1;
            int value = a[i];
            for (; j >= 0 ; j--) {
                if(a[j]>value){
                    a[j+1] = a[j];
                }else{
                    break;
                }
            }
            a[j+1] = value;
        }
    }

    public static void main(String[] args) {
        int a[] = {5, 3, 1, 6, 7, 3, 9};
        new Insert().sort(a);
        Arrays.stream(a).forEach(System.out::print);
    }
}
