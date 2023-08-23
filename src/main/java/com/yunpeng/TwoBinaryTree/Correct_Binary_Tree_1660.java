package com.yunpeng.TwoBinaryTree;

import java.util.HashMap;

public class Correct_Binary_Tree_1660
{
    public static void main(String[] args) {
    }
}




/*
首先什么是错误：
右子节点错误地指向了与其在同一层且在其右侧的一个其他节点。
关键在于如何判断？
我明白了 就直接去遍历，然后如果有一个节点被遍历到两次，则直接停止遍历，定位所在位置
然后进行删除操作

//总结：
思路很简单，首先通过后序遍历搜索得到被遍历过两次的节点
然后通过先序遍历搜索并删除该节点，因为是JAVA，所以我直接置空了
不知道是否符合规范
还是看看其他人怎么做的

出现的问题
1.hashMap的get如果找不到会返回null
2.JAVA的null是什么
3.默认访问控制是什么
4.一些傻逼问题 不管了


 */
class Solution_1660 {
    void PostSearch(TreeNode root){
        if(root==null) return;

        //判断是否已经被遍历过了，然后将val保存起来，因为是互不相同的
        //先右子树，后左子树

        if(root.right!=null&&hashMap.get(root.right.val)!=null){
            //重复了,记录当前节点就是那个节点
            Specialval=root.val;
            return;
        }
        else if(root.right!=null){
            PostSearch(root.right);
        }
        hashMap.put(root.val,1);
        if(root.left!=null){
            PostSearch(root.left);
        }
    }
    void FindAndDelete(TreeNode root){
        if(root==null) return;

        //判断是否已经被遍历过了，然后将val保存起来，因为是互不相同的
        //先右子树，后左子树
        if(root.left!=null){
            if(root.left.val==Specialval){
                //删除，然后继续
                root.left=null;
                return;
            }
            FindAndDelete(root.left);
        }
        if(root.right!=null){
            if(root.right.val==Specialval){
                //删除，然后继续
                root.right=null;
                return;
            }
            FindAndDelete(root.right);
        }
        return;
    }
    public TreeNode correctBinaryTree(TreeNode root) {
        //遍历root，如果有节点被遍历到两次，则直接终止
        PostSearch(root);
        System.out.println(Specialval);
        //已经找到了，需要删除
        //找到，然后删除，随便一个顺序，然后去找，然后当左子或者右子为这个节点，则直接置空
        FindAndDelete(root);
        return root;

    }
    HashMap<Integer,Integer> hashMap = new HashMap<>();
    int Specialval=0;
}