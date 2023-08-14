package com.yunpeng.BasicDatastructure;
import java.util.HashMap;
public class HASHMAP
{
    public static void main(String[] args) {
        //首先是HashMap的基本操作
        //创建HashMap
        HashMap<Integer,String> Sites = new HashMap<>();
        //put 操作 添加键值对
        Sites.put(1, "Google");
        Sites.put(2, "Runoob");
        Sites.put(3, "Taobao");
        Sites.put(4, "Zhihu");
        System.out.println(Sites);
        //get 操作 获取key 对应的value
        System.out.println(Sites.get(3));
        //remove
        Sites.remove(4);
        System.out.println(Sites);
        //clear 清楚
        //Sites.clear();
        //size计算大小
        System.out.println(Sites.size());
        //HashMap的迭代 首先是迭代key值，然后通过key来访问 这个比map简单多了
        for(Integer i: Sites.keySet()){
            System.out.println("key: " + i + " value: " + Sites.get(i));
        }
        //然后可以迭代values
        for(String value: Sites.values()) {
            // 输出每一个value
            System.out.print(value + ", ");
        }
        //其他用法 isEmpty() clone()




    }


}
