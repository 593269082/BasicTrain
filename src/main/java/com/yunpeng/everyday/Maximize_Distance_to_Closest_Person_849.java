package com.yunpeng.everyday;

import java.util.ArrayList;
import java.util.List;

public class Maximize_Distance_to_Closest_Person_849 {

}

/*
seat[i]=1 a person sitting in the ith seat
seat[i]=0 empty
at least one empty seat
at least one person sitting

Alex maximize the distance between him and the closest person to him

Return the Maximum distance

Firstly, we should consider the problem that where to sit is the best
solution?
    Consider one of the sitted person, Alex can sit left of him or right
    of him.

    明白了
    如果有两个人以上，则最大中间位置距离

    首先，如果两个人之间有位置，那么一定是中间最小
    如果只有一个人，则做到他最远的位置
    那么就很简单了
    首先，先检查有多少人
    如果只有一个人直接返回
    如果有两个人以上则执行如下算法
    首先检查左侧和右侧，是否可以直接坐到最左边和最右边，然后判断距离
    然后遍历每个位置，确定最佳位置

    直接写即可 没什么大问题的
 */
class Solution_849 {
    public int maxDistToClosest(int[] seats) {
        //首先判断边界条件
        int n=seats.length;
        //n>=2,n<=2*10^4
        //遍历一遍，存储一下中间的元素，然后用数组保存每个人的位置，
        ArrayList<Integer> sittingperson = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(seats[i]==1){
                sittingperson.add(i);
            }
        }

        if(sittingperson.size()==1){
            return Math.max(sittingperson.get(0)-0,n-sittingperson.get(0)-1);
        }
        else{
            int Max=-1;
            Max=Math.max(Max,sittingperson.get(0)-0);
            Max=Math.max(Max,n-sittingperson.get(sittingperson.size()-1)-1);
            //执行算法，除了最高的和最低的遍历每个可能的位置，并且用指针随时指向目前的区间的最下面的那个
            //只需遍历中间位置即可
            for(int i=0;i<sittingperson.size()-1;i++){
                int left=sittingperson.get(i);
                int right=sittingperson.get(i+1);
                Max=Math.max(Max,(left+right)/2-left);
            }

            return Max;
        }
    }
}
/*
总结，我这个不是最优解法
因为空间复杂度是存在问题的
这个题目属于双指针，但是在我看来并没有严格的类型属于谁
只是单纯的去进行一些分类讨论即可

题解使用了一个快慢指针来解决了空间占用的问题
 */