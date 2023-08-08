package com.yunpeng.DynamicProgramming.Subarray;
/*
总结：
String的两个函数 CharAt和toCharArray()
HashMap的使用方法 主要是new put和get三个函数
包装类的使用有点忘记了需要复习一下
JAVA的类型转换方法

 */
import java.util.HashMap;

public class Find_the_Substring_With_Maximum_Cost_2606 {
}
class Solution2606 {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        //边界判断：
        int n=s.length();
        //建立一个Map 对应的每个字符的价值首先进行求解
        HashMap<Character,Integer> hashMap=new HashMap<Character, Integer>();
        for(int i=0;i<26;i++){
            hashMap.put((char)('a'+i),i+1);
        }
        char[] newchars=chars.toCharArray();
        //charat 也可以用来遍历String
        for(int i=0;i<newchars.length;i++){
            hashMap.put(newchars[i],vals[i]);
        }
        //最大子数组的和问题
        int[] dp=new int[n];
        dp[0]=hashMap.get(s.charAt(0));
        int Maxvalue=dp[0];
        for(int i=1;i<n;i++){
            dp[i]=Math.max(dp[i-1]+hashMap.get(s.charAt(i)),hashMap.get(s.charAt(i)));
            Maxvalue=Math.max(dp[i],Maxvalue);
        }

        return Math.max(Maxvalue,0);//可能为0，因此需要加入一个判断
    }
}