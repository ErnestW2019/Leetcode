package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 94. 二叉树的中序遍历
难度
中等

给定一个二叉树，返回它的中序 遍历。
示例:
输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */

public class Solution94 {
	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        if(root==null) return list;
        TreeNode temp = root;
        while(temp!=null||!s.isEmpty()){
            if(temp!=null){
                s.push(temp);
                temp = temp.left;
            }else {
                temp = s.pop();
                list.add(temp.val);
                temp = temp.right;
            }

        }
        return list;
    }
}
