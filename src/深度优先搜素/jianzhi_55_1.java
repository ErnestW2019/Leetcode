package 深度优先搜素;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
例如：

给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7

返回它的最大深度 3 。
 */
public class jianzhi_55_1 {
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
    /**********层次遍历**************/
    public int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>(){{add(root);}};
        int depth = 0;
        while(!queue.isEmpty()){
            int cursize = queue.size();
            for(int i = 0; i < cursize; i++){
                TreeNode temp = queue.poll();
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            depth++;
        }
        return depth;
    }
}
