package 栈;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * 103. 二叉树的锯齿形层次遍历
难度
中等

给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
例如：
给定二叉树 [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：
[
  [3],
  [20,9],
  [15,7]
]
 */
public class Solution103 {
	 public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
	 }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(root==null) return res;
        Deque<TreeNode> q = new LinkedList<TreeNode>();
        int layer = 0;
        TreeNode temp;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            list = new ArrayList();
            for(int i=0;i<size;i++){
                if(layer%2==0){
                    temp = q.pollLast();
                    list.add(temp.val);
                    if(temp.left!=null){
                        q.offerFirst(temp.left);
                    }
                    if(temp.right!=null){
                        q.offerFirst(temp.right);
                    }
                }else if(layer%2==1){
                    temp = q.pollFirst();
                    list.add(temp.val);
                    if(temp.right!=null){
                        q.offerLast(temp.right);
                    }
                    if(temp.left!=null){
                        q.offerLast(temp.left);
                    }
                }
            }
            res.add(list);
            layer++;
        }
        return res;
    }
}
