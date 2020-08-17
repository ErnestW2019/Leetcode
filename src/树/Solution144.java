package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 144. 二叉树的前序遍历
难度
中等

给定一个二叉树，返回它的 前序 遍历。
 示例:
输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [1,2,3]
 */
public class Solution144 {
	/**********非递归*******************/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root==null) return list;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode temp = s.pop();
            list.add(temp.val);
            if(temp.right!=null){
                s.push(temp.right);
            }
            if(temp.left!=null){
                s.push(temp.left);
            }
        }
        return list;
    }
    /**********递归***************/
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> preorderTraversal2(TreeNode root) {
        
        if(root!=null){
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return list;
    }
    
    //或者
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        dfs(root,list);
        return list;
    }
    private void dfs(TreeNode root,List<Integer> list){
        if(root==null) return;
        list.add(root.val);
        dfs(root.left,list);
        dfs(root.right,list);
    }
}
