package 链表;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution876 {
	/*************辅助栈***************/
    public ListNode middleNode(ListNode head) {
        Stack<ListNode> s = new Stack<ListNode>();
        ListNode p = head;
        int cnt = 0;
        while(p!=null){
            s.push(p);
            p = p.next;
            cnt++;
        } 
        cnt = cnt%2==0?cnt/2:(cnt+1)/2;
        ListNode ans = new ListNode(0);
        ListNode q = ans;
        q.next=null;
        while(cnt!=0){
            ListNode temp = s.pop();
            temp.next=q.next;
            q.next = temp;
            cnt--;
        }
        return ans.next;
    }
    /************快慢指针法************/
    public ListNode middleNode2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
