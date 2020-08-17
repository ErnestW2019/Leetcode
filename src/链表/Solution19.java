package 链表;
/*
 * 19. 删除链表的倒数第N个节点
难度
中等

给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
示例：
给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：
给定的 n 保证是有效的。
进阶：
你能尝试使用一趟扫描实现吗？
 */
public class Solution19 {
	class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode pre = dumy;
        ListNode fast = head;
        ListNode slow = head;
        while(n-->0){
            fast = fast.next;
        }
        while(fast!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next; 
        }
        pre.next = slow.next;
        return dumy.next;
    }
}
