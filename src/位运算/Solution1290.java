package 位运算;

import java.util.Stack;

/*
 * 1290. 二进制链表转整数
难度
简单

给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
请你返回该链表所表示数字的 十进制值 。
 
示例 1：

输入：head = [1,0,1]
输出：5
解释：二进制数 (101) 转化为十进制数 (5)
示例 2：
输入：head = [0]
输出：0
示例 3：
输入：head = [1]
输出：1
示例 4：
输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
输出：18880
示例 5：
输入：head = [0,0]
输出：0
 
提示：
链表不为空。
链表的结点总数不超过 30。
每个结点的值不是 0 就是 1。
 */
public class Solution1290 {
	public class ListNode {
		    int val;
		    ListNode next;
		    ListNode(int x) { val = x; }
		}
    public int getDecimalValue(ListNode head) {
        int num = head.val;
        ListNode p = head.next;
        while(p!=null){
            num = (num<<1)^p.val;
            p = p.next;
            
        }
        return num;
    }
    //方法二：借助栈，先进 的节点后出，可以按位进行转换
    public int getDecimalValue2(ListNode head) {
    	if(head==null) return 0;
    	Stack<Integer> s = new Stack<Integer>();
    	while(head!=null) {
    		s.push(head.val);
    		head = head.next;
    	}
    	int res = 0;
    	int i=0;
    	while(!s.isEmpty()) {
    		int temp = s.pop();
    		if(temp==1) {
    			res += Math.pow(2, i);
    			i++;
    		}else {
    			res += 0;
    			i++;
    		}
    	}
    	return res;
    }
}
