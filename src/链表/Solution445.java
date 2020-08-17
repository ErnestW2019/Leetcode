package 链表;

import java.util.Stack;

/*
 * 445. 两数相加 II
难度
中等


给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 
进阶：
如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 
示例：
输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 8 -> 0 -> 7
 */
public class Solution445 {
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        while(p1!=null){
            s1.push(p1.val);
            p1 = p1.next;
        }
        while(p2!=null){
            s2.push(p2.val);
            p2 = p2.next;
        }
        ListNode tail = null;
        int sum = 0;
        int carry = 0;
        while(!s1.isEmpty()||!s2.isEmpty()){
            if(s1.isEmpty()){
                sum = s2.pop()+carry;
            }
            else if(s2.isEmpty()){
                sum = s1.pop()+carry;
            }
            else sum = s1.pop()+s2.pop()+carry;
            
            ListNode temp = new ListNode(sum%10);
            carry = sum/10; 
            temp.next = tail;
            tail = temp;

        }
        if(carry==1){
            ListNode temp = new ListNode(1);
            temp.next = tail;
            tail = temp;
        }
        return tail;
    }
}
