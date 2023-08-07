package com.yunpeng.sort;
import java.util.Arrays;


public class QuickSortAPI {
    public static void main(String[] args) {
        int[] array = {5, 9, 3, 6, 2, 8, 1, 7};
        Arrays.sort(array); // 利用api接口，使用快速排序对数组进行排序
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
