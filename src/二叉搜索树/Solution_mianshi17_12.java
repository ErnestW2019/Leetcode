package 二叉搜索树;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
	TreeNode(int x) { val = x; }
}
public class Solution_mianshi17_12 {
	/***************递归解法*****************/
    TreeNode cur;
    public TreeNode convertBiNode(TreeNode root) {
        TreeNode node = new TreeNode(Integer.MAX_VALUE);
        cur = node;
        inorder(root);
        return node.right;
    }
    private void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        root.left = null;
        cur.right = root;
        cur = root;
        inorder(root.right);
    }
    /************迭代解法*****************/
    public TreeNode convertBiNode2(TreeNode root) {
    	TreeNode head = new TreeNode(Integer.MAX_VALUE);
    	cur = head;
    	Stack<TreeNode> s = new Stack<TreeNode>();
    	TreeNode temp = root;
    	while(!s.isEmpty()||temp!=null) {
    		if(temp!=null) {
        		s.push(temp);
        		temp=temp.left;
    		}else {
    			temp = s.pop();
    			cur.right = temp;
    			temp.left = null;
    			cur = temp;	
    			temp = temp.right;			
    		}

    	}
    	return head.right;
    }

}
