package 链表;

public class Solution61 {
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0) return head;
        //计算链表的长度
        int len = 1;
        ListNode q = head;
        while(q.next!=null){
            len++;
            q = q.next;
        }
        
        k = k%len;
        if(k==0) return head;
        ListNode m = head;
        ListNode n = head;
        while(k-->0){
            n = n.next;
        }
        while(n!=q){
            m = m.next;
            n = n.next;
        }
        ListNode pHead = m.next;
        m.next = null;
        q.next = head;
        return pHead;
    }
}
