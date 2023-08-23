package com.yunpeng.everyday;
/*
总结；
很久没做二叉树相关的题目了
有点忘记思路了
要注意左右子树分别继续递归
重点在于递归的思路

而且JAVA的二叉树是第一次做
所以有点不懂套路
实际上还是比较简单的
思路一定是
先根  后左 后右 这样来递归遍历子树


 */
public class Merge_Two_Binary_Trees {
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
    TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution_617 {
    public TreeNode mergeTrees(TreeNode r1,TreeNode r2){
        if(r1==null&&r2==null){
            return null;
        }
        else if(r2==null){
            return r1;
        }
        else if(r1==null){
            return r2;
        }
        else{
            TreeNode merged = new TreeNode(r1.val+r2.val);
            merged.left=mergeTrees(r1.left,r2.left);
            merged.right=mergeTrees(r1.right,r2.right);
            return merged;
        }
    }
}