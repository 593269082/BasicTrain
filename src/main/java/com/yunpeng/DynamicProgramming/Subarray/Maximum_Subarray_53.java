package com.yunpeng.DynamicProgramming.Subarray;
/*
总结
模版：
边界条件
DP定义
初始化判断
状态转移

出现的问题：
忘记了比较dp1[0]
 */
public class Maximum_Subarray_53 {
    public static void main(String[] args) {

    }
}
class Solution_53 {
    public int maxSubArray(int[] nums) {
       //边界条件：
        int n=nums.length;
        if(n==1) return nums[0];
        int[] dp1=new int[n];
        //DP初始化：
        dp1[0]=nums[0];
        int Maxvalue=dp1[0];
        //状态转移
        for(int i=1;i<n;i++){
            dp1[i]=Math.max(dp1[i-1]+nums[i],nums[i]);
            Maxvalue=Math.max(Maxvalue,dp1[i]);
        }


        return Maxvalue;
    }
}