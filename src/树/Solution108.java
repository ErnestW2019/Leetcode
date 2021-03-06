package 树;
/*
 * 108. 将有序数组转换为二叉搜索树
难度
简单

将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
示例:
给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
 */
public class Solution108 {
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
		}
	public TreeNode sortedArrayToBST(int[] nums) {
		return creatNode(nums, 0, nums.length-1);
	}
	public TreeNode creatNode(int [] nums,int left,int right) {
		if(left>right) return null;
		int mid = left+(right-left)/2;
		TreeNode rootNode = new TreeNode(nums[mid]);
		rootNode.left = creatNode(nums,left,mid-1);
		rootNode.right = creatNode(nums, mid+1, right);
		return rootNode;
	}
}


