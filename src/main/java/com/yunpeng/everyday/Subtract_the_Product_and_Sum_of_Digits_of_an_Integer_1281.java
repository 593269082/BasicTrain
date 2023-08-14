package com.yunpeng.everyday;

public class Subtract_the_Product_and_Sum_of_Digits_of_an_Integer_1281 {
}
class Solution1281 {
    public int subtractProductAndSum(int n) {
        long x=1;
        long y=0;
        int buffer=n;

        while(buffer!=0){
            x*=buffer%10;
            y+=buffer%10;
            buffer/=10;

        }
        return (int)(x-y);
    }
}