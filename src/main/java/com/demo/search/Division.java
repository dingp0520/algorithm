package com.demo.search;


/**
 * 二分法查找
 */
public class Division {

    /**
     * 不重复值
     * @param a
     * @param value
     * @return
     */
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

    /**
     * 查找第一个值等于给定值的元素
     * @param a
     * @param value
     * @return
     */
    private int search1(int [] a,int value){
        int l = 0;
        int r = a.length-1;
        while(l<=r){
            int c = l+((r-l)>>1);
            if(a[c]>=value){
                r = c - 1;
            }else {
                l = c + 1;
            }
        }
        if(l<a.length-1&&a[l]==value){
            return l;
        }
        return -1;
    }

    // /**
    //  * 通俗写法
    //  * @param a
    //  * @param value
    //  * @return
    //  */
    // private int search1(int [] a,int value){
    //     int l = 0;
    //     int r =a.length-1;
    //     while(l<=r){
    //         int c = l+((r-l)>>1);
    //         if(a[c]<value){
    //             l = c + 1;
    //         }else if(a[c]>value){
    //             r = c - 1;
    //         }else{
    //             if((c==0)||(a[c-1]!=value)){
    //                 return c;
    //             }else {
    //                 r = c -1;
    //             }
    //         }
    //     }
    //     return -1;
    // }

    /**
     * 查找最后一个值等于给定值的元素
     * @param a
     * @param value
     * @return
     */
    private int search2(int [] a,int value){
        int l = 0;
        int r = a.length-1;
        while(l<=r){
            int c = l+((r-l)>>1);
            if(a[c]<=value){
                l = c + 1;
            }else {
                r = c - 1;
            }
        }
        if(r<a.length-1&&a[r]==value){
            return r;
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     * @param a
     * @param value
     * @return
     */
    private int search3(int [] a,int value){
        int l = 0;
        int r = a.length - 1;
        while(l<=r){
            int c = l+((r-l)>>1);
            if(a[c]>=value){
                if((c==0)||a[c-1]<value){
                    return c;
                }
                r= c - 1;
            }else {
                l = c + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     * @param a
     * @param value
     * @return
     */
    private int search4(int [] a,int value){
        int l = 0;
        int r = a.length - 1;
        while(l<=r) {
            int c = l + ((r - l) >> 1);
            if(a[c]>value){
                r = c - 1;
            }else{
                if((c==0)||(a[c+1]>value)){
                    return c;
                }else {
                    l = c + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a [] = {1,3,5,6,6,10,22,34,12};
        int search = new Division().search4(a, 10);
        System.out.println(search);
    }


}
