package com.demo.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 空间复杂度:O(n)
 * 时间复杂度:O(nlogn)
 *
 */
public class Quick {

    private void sort(int [] a) {
        positionSort(a,0,a.length-1);
    }

    private void positionSort(int [] a,int p,int r){
        if(p>=r){
            return;
        }
        int pivot = merge(a, p, r);
        positionSort(a,p,pivot-1);
        positionSort(a,pivot+1,r);
    }

    private int merge(int [] a,int p,int r){
        int i = p;
        int j = p;
        int value = a[r];
        while(j<=r){
             if(a[j]<=value){
                 if(i==j){
                     i++;
                 }else{
                     int tmp = a[j];
                     a[j] = a[i];
                     a[i++] = tmp;
                 }
             }
             j++;
        }
        return i-1;
    }

    // private static int merge(int[] a, int p, int r) {
    //     int pivot = a[r];
    //     int i = p;
    //     for(int j = p; j < r; ++j) {
    //         if (a[j] < pivot) {
    //             if (i == j) {
    //                 ++i;
    //             } else {
    //                 int tmp = a[i];
    //                 a[i++] = a[j];
    //                 a[j] = tmp;
    //             }
    //         }
    //     }
    //
    //     int tmp = a[i];
    //     a[i] = a[r];
    //     a[r] = tmp;
    //
    //     System.out.println("i=" + i);
    //     return i;
    // }

    public static void main(String[] args) {
        int a[] = {5, 3, 1, 6, 7, 3, 9};
        new Quick().sort(a);
        Arrays.stream(a).forEach(System.out::print);
    }
}
