package com.yunpeng.Array;
import java.util.*;

public class Find_All_Duplicates_in_an_Array_442 {
}
//问题的关键在于常量额外空间如何搞定？
//如何判断一个元素出现过几次
//如果只出现一次，则放入，如果出现了两次，则拿出来
//这就是一个buffer 可以对之前的元素进行覆盖

//这个是时间复杂度满足，但是空间复杂度不满足的做法
//class Solution_442 {
//    public List<Integer> findDuplicates(int[] nums) {
//        //采用交换法，首先对nums进行遍历
//        List<Integer> result=new ArrayList<>();
//        HashMap<Integer,Integer> M=new HashMap<>();
//
//        int n=nums.length;
//        for(int i=n-1;i>=0;i--){
//            if(M.get(nums[i])!=null) result.add(nums[i]);
//            M.put(nums[i],1);
//        }
//        return result;
//    }
//}
//关键在于如何原地实现这样的操作？ 先进行正向交换，将重复的放进去，再进行反向交换，将重复的放进去
//是否合理？
class Solution_442 {
    public List<Integer> findDuplicates(int[] nums) {
        //采用交换法，首先对nums进行遍历
        List<Integer> result=new ArrayList<>();


        int n=nums.length;
        for(int i=n-1;i>=0;i--){
            int buffer=0;

            buffer=nums[nums[i]-1];
            nums[nums[i]-1]=nums[i];
            nums[i]=buffer;
        }
        return result;
    }
}