package 深度优先搜素;

import java.util.ArrayList;
import java.util.List;

/*
 * 872. 叶子相似的树
难度
简单

请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。

举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 
提示：
给定的两颗树可能会有 1 到 200 个结点。
给定的两颗树上的值介于 0 到 200 之间。
 */
public class Solution972 {
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	   public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
	        //String res1 = findLeafSeq(root1,"");
	        //String res2 = findLeafSeq(root2,"");
		   //用String存储会出现问题，比如7,14和71,4本来不同却变成相同。
		   List<Integer> list1 = new ArrayList<Integer>();
		   List<Integer> list2 = new ArrayList<Integer>();
		   findLeafSeq(root1,list1);
		   findLeafSeq(root2,list2);
	       return list1.equals(list2);
	    }
	    private static void findLeafSeq(TreeNode root,List<Integer> list){
	        if(root==null) return;
	        if(root.left==null&&root.right==null){
	            list.add(root.val);
	        }
	        findLeafSeq(root.left,list);
	        findLeafSeq(root.right,list);
	        
	    }
	    public static void main(String[] args) {
	    	TreeNode root1 = new TreeNode(1);
	    	TreeNode root2 = new TreeNode(2);
	    	System.out.println(leafSimilar(root1,root2));
	    }
}
