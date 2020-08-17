package 栈;
/*
 * 331. 验证二叉树的前序序列化
难度
中等
序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
示例 1:
输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
输出: true
示例 2:
输入: "1,#"
输出: false
示例 3:
输入: "9,#,#,1"
输出: false
 */
public class Solution331 {

	/*********************递归解法*******************/
    public static boolean isValidSerialization(String preorder) {
        String[] cs = preorder.split(",");
        int s = Solution331.check(cs,0);
        return s==-1||s<=cs.length-1?false:true;
    }
    public static int check(String[] cs,int s){
        if(s>=cs.length){//还需子节点，但是已经没有字符了
            return -1;
        }
        if("#".equals(cs[s])){//遇到空节点了
            return ++s;
        }
        //合法的节点，判断左子树
        s=check(cs,++s);
        if(s==-1) return s;
        //判断右子树
        s=check(cs,s);
        return s;
    }
    
    /****************槽填充法****************/
    /*
    public boolean isValidSerialization2(String preorder) {
        String[] str  = preorder.split(",");
        int slot = 1;
        for(String s:str){
            --slot;
            if(slot<0) return false;
            if(!s.equals("#")){
                slot += 2;
            }
        }
        return slot==0;
    }*/
    public static void main(String[] args) {
    	String preorder = "9,3,4,#,#,#,#,#,2,#,6,#,#";
    	System.out.println(isValidSerialization(preorder));
    }
    
}
