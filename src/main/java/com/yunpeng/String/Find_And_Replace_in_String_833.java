package com.yunpeng.String;
import java.util.HashMap;
import java.util.Arrays;
public class Find_And_Replace_in_String_833 {
    public static void main(String[] args) {

    }
}
class Solution_833 {
    boolean Check(String s,int index,String str){
        for(int i=0;i<str.length();i++){
            if(i+index>=s.length()||i+index<0) return false;
            if(s.charAt(i+index)!=str.charAt(i)){
                //System.out.println(s.charAt(i+index));
                //System.out.println(str.charAt(i));
                return false;
            }
        }
        return true;
    }
    String Replace(String s,int index,String str,String replacestr){
        //替换s在index位置下的str为replacestr
        char[] resultArray=new char[s.length()+replacestr.length()-str.length()];

        //那就只能用ArrayList了
        for(int i=0;i<index;i++){
            resultArray[i]=s.charAt(i);
            //System.out.println(resultArray[i]);
        }
        for(int i=0;i<replacestr.length();i++){
            resultArray[i+index]=replacestr.charAt(i);
            //System.out.println(resultArray[i+index]);
        }
        for(int i=index+str.length();i<s.length();i++){
            resultArray[i+index+replacestr.length()-index-str.length()]=s.charAt(i);
        }
        String re = new String(resultArray);
        return re;
    }
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        //我这个必须按照前后顺序来 这就是不同步进行转换的缺点
        //主要是对java的数组操作太不熟悉了 而且边界出错很多
        //这个题暴露了 JAVA的困难之处
        //首先将indices和sources和targets按照先后顺序排序
        //其实就是这个用C++做 也存在一些问题，需要对这类题型讨论进行总结
        HashMap<Integer,Integer> Map=new HashMap<>();

        int k=indices.length;
        for(int i=0;i<k;i++){
            Map.put(indices[i],i);
        }
        Arrays.sort(indices);

        System.out.println(indices[0]);
        int initn=s.length();
        for(int i=0;i<k;i++){
            //check
            int newindex=s.length()-initn+indices[i];
            //System.out.println(newindex);
            if(Check(s,newindex,sources[Map.get(indices[i])])){
                //int newindex=s.length()-initn+i;
                //System.out.println(newindex);
                s=Replace(s,newindex,sources[Map.get(indices[i])],targets[Map.get(indices[i])]);
                //System.out.println(s);
            }
        }
        return s;
    }
}
/*
总结
关于索引的问题，一定要先确定好索引然后再开始写
另外由于这个题要求同步发生，索引是在变化的，因此需要添加偏移量
由于乱序会导致索引出错，因此需要排序后，再进行模拟。



 */