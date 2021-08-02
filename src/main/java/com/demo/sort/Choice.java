package com.demo.sort;

import java.util.Arrays;

/**
 * 选择排序-从小到大
 * 空间复杂度:O(1) 原地排序算法
 * 时间复杂度: O(n^2)
 * 不稳定排序算法
 */
public class Choice {

    private void sort(int [] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int j = i+1;
            int min = i;
            for (; j < n; j++) {
                if(a[j]<a[min]){
                    min = j;
                }
            }
            if(min!=i){
                int tmp = a[min];
                a[min] = a[i];
                a[i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {5, 3, 1, 6, 7, 3, 9};
        new Choice().sort(a);
        Arrays.stream(a).forEach(System.out::print);
    }

}
