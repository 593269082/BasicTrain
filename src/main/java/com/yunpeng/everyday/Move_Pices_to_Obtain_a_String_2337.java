package com.yunpeng.everyday;

import java.util.ArrayList;

public class Move_Pices_to_Obtain_a_String_2337 {
    public static void main(String[] args) {

    }
}
/*
L R
L and R represent pieces
L can move to left only if there is a blank space directly to the left
R can move to right only if there is a blank space directly to the right
_
start can change to target?

只要长度一致，而且里面的字母去掉空格后是一样的，不就ok了吗

 */
class Solution_2337 {
    void change(ArrayList<Character> array,String str){
        //关键在于这一步，有哪些是需要删除，有哪些是需要保留的
        //这样来搞，阶段删除，首先正向删除，然后反向删除，
        //正向删除，如果出现了R，到下一个为止的所有的_全都删除，
        //如果出现了L，则到下一个字母的所有_全都删除
        //那么可以尝试了
        //正向删除
        ArrayList<Character> array2=new ArrayList<>();
        int flag=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='R'){
                flag=1;
                array2.add('R');
            }
            if(str.charAt(i)=='_'&&flag==0){
                array2.add('_');
            }
            if(str.charAt(i)=='L'){
                flag=0;
                array2.add('L');
            }
        }
        //反向删除
        //遇到L，则左边的_全部删除，遇到R则停止
        flag=0;
        for(int i=array2.size()-1;i>=0;i--){
            if(array2.get(i)=='L'){
                flag=1;
                array.add('L');
            }
            if(array2.get(i)=='_'&&flag==0){
                array.add('_');
            }
            if(array2.get(i)=='R'){
                flag=0;
                array.add('R');
            }
        }
        System.out.println(array);
    }
    boolean equal(ArrayList<Character> array1,ArrayList<Character> array2){
        if(array1.size()!=array2.size()){
            return false;
        }
        for(int i=0;i<array1.size();i++){
            if(array1.get(i)!=array2.get(i)){
                return false;
            }
        }
        return true;
    }
    public boolean canChange(String start, String target) {
        //先处理为我想要的形式
        //然后再继续
        ArrayList<Character> arraycharlist1=new ArrayList<Character>();
        ArrayList<Character> arraycharlist2=new ArrayList<Character>();
        change(arraycharlist1,start);
        change(arraycharlist2,target);
        return equal(arraycharlist1,arraycharlist2);

    }
}

/*
目前看起来我的算法并不是正确的，似乎存在一些问题
因为左右的问题
所以其实是一些特殊情况，先加入一些特殊判断，然后再进行尝试
 */