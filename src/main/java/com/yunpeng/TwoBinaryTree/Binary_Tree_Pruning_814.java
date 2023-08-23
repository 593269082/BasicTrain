package com.yunpeng.TwoBinaryTree;

public class Binary_Tree_Pruning_814 {
    public static void main(String[] args) {
    }
}
/*
解题过程
移除所有不包含1的子树的原二叉树
什么是原二叉树 就是原地删除
 */
/*
思路
其实比较简单，就是后序遍历
搜索左右子树，然后如果均为null，且自己val为0，则说明这个子树可以删掉

总结
思路和题解差不多
差别在于
不知道为什么用函数写的时候
这样写存在问题
找同学问一下
class Solution_814 {
    void PostDeleteTree(TreeNode root){
        if(root==null) return;
        if(root.left!=null){
            PostDeleteTree(root.left);
        }
        if(root.right!=null){
            PostDeleteTree(root.right);
        }
        if(root.left==null&&root.right==null&&root.val==0){
            root=null;
            return;
        }
    }
    public TreeNode pruneTree(TreeNode root) {
        PostDeleteTree(root);
        return root;
    }
}


 */
class Solution_814 {
    void PostDeleteTree(TreeNode root){
        if(root==null) return;
        if(root.left!=null){
            PostDeleteTree(root.left);
        }
        if(root.right!=null){
            PostDeleteTree(root.right);
        }
        //判断 置空左右吧 直接 就是左子树要是左右子树都是空的，那么就置为null
        //右子树要是左右子树均为空，则
        if(root.left!=null&&root.left.left==null&&root.left.right==null&&root.left.val==0){
            root.left=null;
        }
        if(root.right!=null&&root.right.left==null&&root.right.right==null&&root.right.val==0){
            root.right=null;
        }
    }
    public TreeNode pruneTree(TreeNode root) {
        PostDeleteTree(root);
        if(root.left==null&&root.right==null&&root.val==0){
            return null;
        }
        return root;
    }
}


/*
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}

作者：力扣官方题解
链接：https://leetcode.cn/problems/binary-tree-pruning/solutions/1683846/er-cha-shu-jian-zhi-by-leetcode-solution-k336/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

可以学习一下官方的题解

 */