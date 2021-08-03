package com.demo.sort;

import java.util.Arrays;

/**
 * 桶排序
 * 时间复杂度:当桶的个数接近数据个数时，接近O(n)
 * 不是原地排序
 * 稳定排序
 */
public class Bucket {

    private void bucketSort(int[] arr, int bucketSize) {
        if(arr.length<2){
            return;
        }
        int length = arr.length;
        //先确定最大最小值
        int max = arr[0];
        int min = arr[1];
        for (int i = 0; i < length; i++) {
            if(arr[i]>max){
                max = arr[i];
            }else if(arr[i]<min){
                min = arr[i];
            }
        }
        int bucketCount = (max - min) / bucketSize + 1;
        //初始化桶以及辅助数组
        int [][] buckets = new int[bucketCount][bucketSize];
        int [] bucketIndex = new int[bucketCount];

        //分配数据
        for (int i = 0; i < length; i++) {
            int bucket = (arr[i]-min)/bucketSize;
            if(bucketIndex[bucket]==buckets[bucket].length){
                ensureCapacity(buckets,bucket);
            }
            buckets[bucket][bucketIndex[bucket]++] = arr[i];
        }

        int k =0;
        for (int i = 0; i < bucketCount; i++) {
            if (bucketIndex[i] == 0) {
                continue;
            }
            sort(buckets[i],0,bucketIndex[i]-1);
            for (int j = 0; j < bucketIndex[i]; j++) {
                arr[k++] = buckets[i][j];
            }
        }

    }

    //数组扩容
    private void ensureCapacity(int [][] buckets,int bucketIndex){
        int [] oldArr = buckets[bucketIndex];
        int [] newArr = new int[oldArr.length*2];
        for (int i = 0; i < oldArr.length; i++) {
            newArr[i] = oldArr[i];
        }
        buckets[bucketIndex] = newArr;
    }

    //快速排序
    private void sort(int [] a,int p,int r){
        if(p>=r){
            return;
        }
        int position = position(a, p, r);
        sort(a,p,position-1);
        sort(a,position+1,r);
    }

    private int position(int [] a,int p,int r){
        int i = p;
        int j = p;
        int value = a[r];
        while(j<=r){
            if(a[j]<=value){
                int tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
                i++;
            }
            j++;
        }
        return i-1;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,3,8,7,10};
        new Bucket().bucketSort(arr,2);
        Arrays.stream(arr).forEach(System.out::println);
    }

}
