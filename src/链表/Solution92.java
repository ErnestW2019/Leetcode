package 链表;
/*
 * 92. 反转链表 II
难度
中等

反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
说明:
1 ≤ m ≤ n ≤ 链表长度。
示例:
输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL
 */
public class Solution92 {
	public class ListNode {
		int val;
        ListNode next;
	    ListNode(int x) { val = x; }
	}
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode p = head;
        //ListNode tail = null;
        int k = 1;
        while(k++<m){
            p=p.next;
            pre=pre.next;
        }
        k--;
        //两两交换
        while(k++<n){
            ListNode temp = p.next;
            p.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;

        }
        return dummy.next;
    }
}
