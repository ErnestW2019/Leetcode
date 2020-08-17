package 排序;


 // Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

public class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        if(head==null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur!=null){
            if(cur.val>=pre.val) {
                pre = cur;
                cur = cur.next;
            }else{
                ListNode p = dummy;
                while(p.next.val<cur.val){
                    p = p.next;
                }
                pre.next = cur.next;
                cur.next = p.next;
                p.next = cur;
                cur = pre.next;
            }
        }
        return dummy.next;
    }
}