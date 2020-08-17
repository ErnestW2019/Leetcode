package 深度优先搜素;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
/*
 * 559. N叉树的最大深度
难度
简单

给定一个 N 叉树，找到其最大深度。
最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
例如，给定一个 3叉树 :
 

 
我们应返回其最大深度，3。
说明:
树的深度不会超过 1000。
树的节点总不会超过 5000。
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class Solution559 {
	/***********递归法*************/
    /*public int maxDepth(Node root) {
        if(root==null) return 0;
        int depth=0;
        int children = root.children.size();
        for(int i=0;i<children;i++){
            depth = Math.max(maxDepth(root.children.get(i)),depth);
            
        }
        return depth+1;
    }*/
    /************迭代法*************/
    public int maxDepth(Node root) {
        if(root==null) return 0;
		Stack<Map<Node,Integer>> s = new Stack<>();
		HashMap<Node, Integer> map = new HashMap<Node,Integer>();
		map.put(root, 1);
        s.push(map);
		int depth = 0;
		while(!s.isEmpty()) {
			Map<Node,Integer> temp = s.pop();
            for(Map.Entry<Node, Integer> entry:temp.entrySet()){
                Node node = entry.getKey();
                int curdepth = entry.getValue();
                for(int i=0;i<node.children.size();i++){
                    map = new HashMap<Node,Integer>();
                    map.put(node.children.get(i),curdepth+1);
                    s.push(map);
                }
                depth = Math.max(curdepth,depth);
            }
		}
        return depth;
		
    }
}
