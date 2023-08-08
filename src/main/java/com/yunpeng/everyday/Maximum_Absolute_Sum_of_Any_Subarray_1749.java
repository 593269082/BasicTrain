package com.yunpeng.everyday;
/*
总结：
绝对值问题，要考虑最小值和最大值
题解：
和的绝对值的最大值，要么是和的最小值，要么是和的最大值。
转换为了连续子数组的最大和问题。
中间遇到的问题：
首先是边界问题；
然后是不要忘记DP的基本模版；
记住，DP数组一般是以xxx为结尾的xxx。
 */
public class Maximum_Absolute_Sum_of_Any_Subarray_1749 {
    public static void main(String[] args) {

    }
}
class Solution1749 {
    public int maxAbsoluteSum(int[] nums) {
        //nums 按照定义 子数组为连续子数组
        //一眼DP子数组问题 鉴定为可以状态转移来解决
        //和的绝对值 dp定义：dp[i] i以及之前的最大和的绝对值,选择只有要么包含自身，要么不包含自身
        //维护一个Sum利用前缀和求出 前缀和已经能求出了，那么O(n2)就已经可以求出了，但是因为10^5，所以不可行
        //需要保存之前的状态
        //dp[i]=max(dp[i-1],好像不太对
        //发现自己存在啥问题 之前的动态规划的题目有点忘记了 需要开始每周加入复习时间
        //上午两个小时时间 复习子数组类型题目 就按照给定的题单来吧
        //题解： 和的绝对值的最大值，要么是和的最小值，要么是和的最大值。这就转换为了连续子数组的最大和问题。
        //dp[i] 包含i的连续子数组的最大和，要么包含前面，要么不包含前面
        //绝对值相关的题目可以找一下。
        int n=nums.length;
        if(n<=1) return Math.abs(nums[0]);
        int[] dp1=new int[n];
        int[] dp2=new int[n];
        dp1[0]=nums[0];
        dp2[0]=nums[0];
        int Maxvalue=dp1[0];
        int Minvalue=-dp2[0];
        for(int i=1;i<n;i++){
            dp1[i]=Math.max(dp1[i-1]+nums[i],nums[i]);
            dp2[i]=Math.min(dp2[i-1]+nums[i],nums[i]);
            Maxvalue=Math.max(Maxvalue,dp1[i]);
            Minvalue=Math.min(Minvalue,dp2[i]);
        }
        return Math.max(Math.abs(Maxvalue),Math.abs(Minvalue));




    }
}
