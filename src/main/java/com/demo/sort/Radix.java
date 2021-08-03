package com.demo.sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class Radix {

    private void radixSort(int [] a){

        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if(a[i]>max){
                max = a[i];
            }
        }

        for (int exp = 1; max/exp>0; exp=exp*10) {
            countingSort(a,exp);
        }

    }

    //计数排序
    private void countingSort(int [] a,int exp){
        int n = a.length;
        int [] c = new int[10];
        for (int i = 0; i < n; i++) {
            int value = (a[i]/exp)%10;
            c[value]++;
        }
        for (int i = 1; i < n; i++) {
            c[i] = c[i-1]+c[i];
        }
        int [] result = new int[n];
        for (int i = n - 1; i >= 0 ; i--) {
            int value = (a[i]/exp)%10;
            result[c[value]-1] = a[i];
            c[value]--;
        }
        for (int i = 0; i < n; i++) {
            a[i] = result[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {1832714868,
                1567990687,
                1753760967,
                8680670,
                50886768,
                1512806940,
                28424330,
                1342400294,
                537800922,
                836361472};
        new Radix().radixSort(a);
        Arrays.stream(a).forEach(System.out::println);
    }
}
