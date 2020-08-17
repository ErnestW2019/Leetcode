package 字符串;

import java.util.HashSet;
import java.util.Stack;


/*
 * 606. 根据二叉树创建字符串
难度
简单

你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
示例 1:
输入: 二叉树: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

输出: "1(2(4))(3)"

解释: 原本将是“1(2(4)())(3())”，
在你省略所有不必要的空括号对之后，
它将是“1(2(4))(3)”。
示例 2:
输入: 二叉树: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 

输出: "1(2()(4))(3)"

解释: 和第一个示例相似，
除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 */
class TreeNode {
	   int val;
	   TreeNode left;
	   TreeNode right;
	   TreeNode(int x) { val = x; }
}
public class Solution606 {
	/*************法一：递归**********/
    /*public String tree2str(TreeNode t) {
        if(t==null) return"";
        if(t.left==null&&t.right==null){
            return t.val+"";
        }
        if(t.right==null){
            return t.val+"("+tree2str(t.left)+")";
        }
        return t.val+"(" +tree2str(t.left)+")("+tree2str(t.right)+")";

    }*/
    /**************非递归**************/
    public static String tree2str(TreeNode t) {
    	if(t==null) return "";
    	StringBuilder sb = new StringBuilder(); 
    	Stack<TreeNode> s = new Stack<TreeNode>();
    	HashSet<TreeNode> visited = new HashSet<TreeNode>();
    	s.push(t);
    	//visited.add(t);
    	while(!s.isEmpty()) {
    		TreeNode temp = s.peek();
    		if(visited.contains(temp)) {
    			s.pop();
    			sb.append(")");
    		}else {
    			visited.add(temp);
    			sb.append("("+temp.val);  
				if(temp.right!=null) {
					s.push(temp.right);	
				}
				if(temp.left!=null) {
					s.push(temp.left);
				}
        		if(temp.left==null&&temp.right!=null) {
        			sb.append("()");
        		}
    		}
    	}
		return sb.toString().substring(1, sb.length()-1);
    }
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.left.left = new TreeNode(4);
    	root.right = new TreeNode(3);
    	System.out.println(tree2str(root).toString());
    }
}
