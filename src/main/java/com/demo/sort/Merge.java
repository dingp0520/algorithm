package com.demo.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 空间复杂度:O(n)
 * 时间复杂度:O(nlogn)
 * 稳定排序算法
 */
public class Merge {

    private void sort(int [] a) {
        positionSort(a,0,a.length-1);
    }

    private void positionSort(int [] a,int p,int r){
        if(p>=r){
            return;
        }
        int q = (p+r)/2;
        positionSort(a,p,q);
        positionSort(a,q+1,r);
        merge(a,p,q,r);
    }

    private void merge(int [] a,int p,int q,int r){
        int i = p;
        int j = q+1;
        int k = 0;
        int [] tmp = new int[r-p+1];
        while(i<=q&&j<=r){
            if(a[i]>a[j]){
                tmp[k++] = a[j];
                j++;
            }else {
                tmp[k++] = a[i];
                i++;
            }
        }
        while(i<=q){
            tmp[k++] = a[i];
            i++;
        }

        while(j<=r){
            tmp[k++] = a[j];
            j++;
        }

        for (int l = 0; l < tmp.length; l++) {
            a[p++] = tmp[l];
        }
    }


    public static void main(String[] args) {
        int a[] = {5, 3, 1, 6, 7, 3, 9};
        new Merge().sort(a);
        Arrays.stream(a).forEach(System.out::print);
    }

}
