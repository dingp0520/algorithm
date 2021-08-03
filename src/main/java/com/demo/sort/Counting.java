package com.demo.sort;

import java.util.Arrays;

/**
 * 计数排序
 * 时间复杂度:O(n+k) k是数据范围
 * 不是原地排序
 * 是稳定排序
 */
public class Counting {

    private void countingSort(int [] a){
        int n = a.length;
        //确定最大值
        int max = a[0];
        for (int i = 0; i < n; i++) {
            if(a[i]>max){
                max = a[i];
            }
        }

        //初始化计数数组
        int [] countArr = new int[max+1];
        for (int i = 0; i < n; i++) {
            countArr[a[i]]++;
        }

        //累加
        for (int i = 1; i < n; i++) {
            countArr[i] = countArr[i-1]+countArr[i];
        }

        int [] result = new int[n];
        for (int i = n - 1; i >= 0 ; i--) {
            int index = countArr[a[i]]-1;
            result[index] = a[i];
            countArr[a[i]]--;
        }

        for (int i = 0; i < n; i++) {
            a[i] = result[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,4,3,8,6,3,2,5,6,10,0};
        new Counting().countingSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

}
