package com.yunpeng.sort;
/*
Given an integer array nums, reorder it such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
You may assume the input array always has a valid answer.
 */
import java.util.Arrays;
public class WiggleSort_280 {
    //思路 先排序，分成
    public static void main(String[] args) {
        int[] testnums={3,5,2,1,6,4};
        Solution s=new Solution();
        s.wiggleSort(testnums);
        for(int i:testnums){
            System.out.print(i+" ");
        }
    }
}

class Solution {
    //普通方法，交换法，观察法，nums[0] <= nums[1] >= nums[2] <= nums[3]...
    //相当于排序后，后面两两交换
//    public void wiggleSort(int[] nums) {
//        Arrays.sort(nums);
//        int n=nums.length;
//        if(n==1){
//            return;
//        }
//        for(int i=1;i<n-1;i+=2){
//            int buffer;
//            buffer=nums[i+1];
//            nums[i+1]=nums[i];
//            nums[i]=buffer;
//        }
//
//    }
    //不排序如何用O(n)解决这个问题？ 计数排序 这样的解才是标准解，因为肯定考察的是计数排序，是否满足条件要看空间
    public void calculateSort(int[] nums){
        int[] nums1=new int[10001];//默认初始值为0
        for(int x:nums){
            nums1[x]+=1;
        }
        int j=0;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]!=0){
                for(int x=0;x<nums1[i];x++){
                    nums[j++]=i;
                }

            }
        }
    }
    public void wiggleSort(int[] nums) {
        calculateSort(nums);
        int n=nums.length;
        if(n==1){
            return;
        }
        for(int i=1;i<n-1;i+=2){
            int buffer;
            buffer=nums[i+1];
            nums[i+1]=nums[i];
            nums[i]=buffer;
        }

    }
}
