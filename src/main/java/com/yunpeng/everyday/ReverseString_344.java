package com.yunpeng.everyday;

public class ReverseString_344 {
    public static void main(String[] args) {
        String strtest="hello";
        char[] str1=strtest.toCharArray();
        reverseString(str1);
        System.out.print(str1);


    }
    public static void reverseString(char[] s) {
        //原地翻转字符串 不浪费额外空间
        //思路：如果长度是偶数，则进行n/2次交换
        //如果长度是奇数，则进行n/2次交换
        //这样就可以达成目标
        int n=s.length;
        for(int i=0;i<n/2;i++){
            char buffer;
            buffer=s[i];
            s[i]=s[n-i-1];
            s[n-i-1]=buffer;
        }

    }
}
