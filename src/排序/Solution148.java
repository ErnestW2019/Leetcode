package 排序;
/*
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
示例 1:

输入: 4->2->1->3
输出: 1->2->3->4

示例 2:

输入: -1->5->3->4->0
输出: -1->0->3->4->5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution148 {
	class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
    public ListNode sortList(ListNode head) {
        return head==null ? null:mergeSort(head);
    }
    private ListNode mergeSort(ListNode head){
        if(head.next==null) return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while(fast!=null&&fast.next!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(slow);
        return merge(l,r);
    }
    private ListNode merge(ListNode l,ListNode r){
        ListNode dummy = new ListNode(0);
        //dummy.next = head;
        ListNode cur = dummy;
        while(l!=null&&r!=null){
            if(l.val<=r.val){
                cur.next = l;
                cur = cur.next;
                l = l.next;
            }else{
                cur.next = r;
                cur = cur.next;
                r = r.next;
            }
            if(l!=null){
                cur.next = l;
            }
            if(r!=null){
                cur.next = r;
            }
        }
        return dummy.next;

    }
}
