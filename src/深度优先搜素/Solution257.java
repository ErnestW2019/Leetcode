package 深度优先搜素;

import java.util.ArrayList;
import java.util.List;

public class Solution257 {
	public class TreeNode {
		int val;
		TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root==null) return res;
        String str = "";
        dfs(root,str,res);
        return res;
    }
    private void dfs(TreeNode root,String str,List<String> res){
        if(root!=null){
            str += root.val;
        }
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            res.add(str);
        }else {
            dfs(root.left,str+"->",res);
            dfs(root.right,str+"->",res);
        }
    }
}
