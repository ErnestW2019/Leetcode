package 深度优先搜素;

public class jianzhi_55_II {
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	/**********先序遍历，O（n）*****************/
	/*
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return Math.abs(depth(root.left)-depth(root.right))<2&&isBalanced(root.left)&&isBalanced(root.right);

    }
    private int depth(TreeNode root){
        if(root==null) return 0;
        return Math.max(depth(root.left),depth(root.right))+1;
    }
    */
    /**********自底向上遍历，O（logn）*****************/
    public boolean isBalanced(TreeNode root) {
    	return depth(root)!=-1;
    }
    private int depth(TreeNode root){
    	if(root==null) return 0;
    	int leftdepth = depth(root.left);
    	if(leftdepth==-1) return -1;
    	int rightdepth = depth(root.right);
    	if(rightdepth==-1) return -1;
    	return Math.abs(leftdepth-rightdepth)<2?Math.max(leftdepth,rightdepth)+1:-1;
    }
}
