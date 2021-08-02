package com.demo.sort;

import java.util.Arrays;

/**
 * 冒泡排序-从小到大
 * 空间复杂度:O(1) 原地排序算法
 * 时间复杂度: O(n) - O(n^2)
 * 稳定排序算法
 */
public class Bubbling {

    private void sort(int [] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n -i -1; j++) {
                if(a[j]>a[j+1]){
                    int tmp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {5, 3, 1, 6, 7, 3, 9};
        new Bubbling().sort(a);
        Arrays.stream(a).forEach(System.out::print);
    }
}
