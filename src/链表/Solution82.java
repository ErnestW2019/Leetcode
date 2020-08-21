package 链表;

public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;
        ListNode pre = dummy;
        while(p!=null){
            if(p.next!=null&&p.next.val==p.val){
                while(p!=null&&p.next!=null&&p.next.val==p.val){
                    p=p.next;
                }
                pre.next=p.next;
            }
            else{             
                pre = p;
            }
            p=p.next;
        }
        return dummy.next;
    }
}
