package 树;
/*
 * 623. 在二叉树中增加一行
难度
中等

给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。
将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
示例 1:
输入: 
二叉树如下所示:
       4
     /   \
    2     6
   / \   / 
  3   1 5   

v = 1

d = 2

输出: 
       4
      / \
     1   1
    /     \
   2       6
  / \     / 
 3   1   5   

示例 2:
输入: 
二叉树如下所示:
      4
     /   
    2    
   / \   
  3   1    

v = 1

d = 3

输出: 
      4
     /   
    2
   / \    
  1   1
 /     \  
3       1
注意:
输入的深度值 d 的范围是：[1，二叉树最大深度 + 1]。
输入的二叉树至少有一个节点。
 */
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution623 {
	/**********广度优先搜索，利用队列***********/
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d==1){
            TreeNode newroot = new TreeNode(v);
            newroot.left = root;
            return newroot;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int depth = 1;
        //先找到需要添加的那一行的父节点
        while(depth<d-1){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
            depth++;
        }
        while(!q.isEmpty()){
            TreeNode curroot = q.poll();
            TreeNode temp = curroot.left;
            curroot.left = new TreeNode(v);
            curroot.left.left = temp;
            temp = curroot.right;
            curroot.right = new TreeNode(v);
            curroot.right.right = temp;
        }
        return root;
    }
    
    /************深度优先搜索 递归解法*************/
    public TreeNode addOneRow2(TreeNode root, int v, int d) {
        if(d==1){
            TreeNode newroot = new TreeNode(v);
            newroot.left = root;
            return newroot;
        }
        dfs(root,v,1,d);
        return root;
    }
    private void dfs(TreeNode node,int v,int layer,int d){
        if(node == null) return;
        if(layer==d-1){
            TreeNode temp = node.left;
            node.left = new TreeNode(v);
            node.left.left = temp;
            temp = node.right;
            node.right = new TreeNode(v);
            node.right.right = temp;
        }else{
            dfs(node.left,v,layer+1,d);
            dfs(node.right,v,layer+1,d);
        }

    }
}
