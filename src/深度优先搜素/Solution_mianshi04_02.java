package 深度优先搜素;
/*
 * 面试题 04.02. 最小高度树
难度
简单

给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
示例:
给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

          0 
         / \ 
       -3   9 
       /   / 
     -10  5 
   */
public class Solution_mianshi04_02 {
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	public TreeNode sortedArrayToBST(int[] nums) {
	    return buildTree(nums, 0, nums.length - 1);
	}

	private TreeNode buildTree(int[] nums, int left, int right) {
	    if (left > right)
	        return null;
	    int m = left + ((right - left) >> 1);
	    TreeNode root = new TreeNode(nums[m]);
	    root.left = buildTree(nums, left, m - 1);
	    root.right = buildTree(nums, m + 1, right);
	    
	    return root;
	}
}
