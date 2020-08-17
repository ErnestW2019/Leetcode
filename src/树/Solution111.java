package 树;

public class Solution111 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	/*****递归解法****************/
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return 1;
        int mindepth = Integer.MAX_VALUE;
        if(root.left!=null) {
            mindepth = Math.min(minDepth(root.left)+1,mindepth);
        }
        if(root.right!=null){
            mindepth = Math.min(minDepth(root.right)+1,mindepth);
        } 
        return mindepth;
    }
}
