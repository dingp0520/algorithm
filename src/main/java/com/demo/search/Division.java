package com.demo.search;


/**
 * 二分法查找
 */
public class Division {

    private int search(int [] a,int value){
        int l = 0;
        int r =a.length-1;
        while(l<=r){
            int c = l+((r-l)>>1);
            if(a[c]==value){
                return c;
            }else if(a[c]<value){
                l = c + 1;
            }else if(a[c]>value){
                r = c - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a [] = {1,3,5,6,9,10,22,34,12};
        int search = new Division().search(a, 10);
        System.out.println(search);
    }


}
