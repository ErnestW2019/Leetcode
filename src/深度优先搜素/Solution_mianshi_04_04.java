package 深度优先搜素;
/*面试题 04.04. 检查平衡性
难度
简单

实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。

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
public class Solution_mianshi_04_04 {
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return Math.abs(depth(root.left)-depth(root.right))<2&&isBalanced(root.left)&&isBalanced(root.right);
    }
    public int depth(TreeNode root){
        if(root==null) return 0;
        int leftdepth = depth(root.left)+1;
        int rightdepth = depth(root.right)+1;
        return Math.max(leftdepth,rightdepth);
       
    }
}
