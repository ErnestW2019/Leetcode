package 树;

import java.util.LinkedList;
import java.util.Queue;


/*
 * 226. 翻转二叉树
难度
简单

448





翻转一棵二叉树。
示例：
输入：
     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：
     4
   /   \
  7     2
 / \   / \
9   6 3   1
备注:
这个问题是受到 Max Howell 的 原问题 启发的 ：
谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 */
public class Solution226 {
	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	/****************迭代解法************/
    public static TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null) return null;
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            TreeNode rightTree = temp.right;
            temp.right = temp.left;
            temp.left = rightTree;
            if(temp.left!=null){
                q.offer(temp.left);
            }
            if(temp.right!=null){
                q.offer(temp.right);
            }

        }
        return root;
    }
    /****************递归解法************/
    public static TreeNode invertTree2(TreeNode root) {
    	if(root==null) return null;
    	swap(root);
    	invertTree2(root.right);
    	invertTree2(root.left);
    	return root;
    }
	private static void swap(TreeNode root) {
		// TODO Auto-generated method stub
		//if(root==null) return null;
		
		TreeNode temp = root.right;
		root.right = root.left;
		root.left = temp;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		System.out.println(invertTree2(root).left.val);
	}
}
