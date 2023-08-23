package com.yunpeng.everyday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Find_the_Losers_of_the_Circular_Game_2682 {
}
/*
n个朋友玩游戏，圈
顺时针方向 编号
i->i+1 n->1
1->b->k
模拟这个过程，相当于取模




 */
class Solution_2682 {
    public int[] circularGameLosers(int n, int k) {
        //边界条件
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        //初始持有球的人
        int Havetheball=0;
        hashMap.put(Havetheball,1);
        int i=1;
        //模拟过程
        while(true){
            //传球过程
            //确定传给谁
            Havetheball=(Havetheball+i*k)%n;
            i++;
            //判断是否结束
            if(hashMap.get(Havetheball)!=null) break;
            else{
                hashMap.put(Havetheball,1);
            }
        }
        //JAVA的包装类会自动拆箱
        //JAVA来做这种事情是有点麻烦的
        List<Integer> result=new ArrayList<>();
        for(int x=0;x<=n-1;x++){
            if(hashMap.get(x)==null){
                result.add(x+1);
            }
        }
        int[] resultintarray = new int[result.size()];
        for(int x=0;x<result.size();x++ ){
            resultintarray[x]=result.get(x);
        }
        return resultintarray;
    }
}
