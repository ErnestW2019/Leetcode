package 树;

import 树.Solution112.TreeNode;

/*
 * 110. 平衡二叉树
难度
简单

给定一个二叉树，判断它是否是高度平衡的二叉树。
本题中，一棵高度平衡二叉树定义为：
一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
示例 1:
给定二叉树 [3,9,20,null,null,15,7]
    3
   / \
  9  20
    /  \
   15   7
返回 true 。

示例 2:
给定二叉树 [1,2,2,3,3,null,null,4,4]
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
返回 false 。
 */
public class Solution110 {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	/***********自上而下递归解法****************/  //1ms
    /*public boolean isBalanced(TreeNode root) {
        if(root==null) return true;

        return Math.abs(Height(root.left)-Height(root.right))<2&&isBalanced(root.left)&&isBalanced(root.right);
        
    }
    private int Height(TreeNode root){
        if(root==null) return 0;
        return Math.max(Height(root.left),Height(root.right))+1;
    }*/
    /***********自下而上递归解法****************/
    public boolean isBalanced(TreeNode root) {
    	if(root==null) return true;
    	return Height(root)!=-1;
    	
    }
    private int Height(TreeNode root) {
    	if(root==null) return 0;   
    	int leftdepth = Height(root.left)+1;
        if(leftdepth==0) return -1; 
    	int rightdepth = Height(root.right)+1;
        if(rightdepth==0) return -1;
    	if(Math.abs(leftdepth-rightdepth)>=2) {
    		return -1;
    	}
    	else{
    		return Math.max(leftdepth, rightdepth);
    	}
    }
    
}
