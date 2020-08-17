package 链表;
/*
 * 24. 两两交换链表中的节点
难度
中等

给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 
示例:
给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Solutiom24 {
    public ListNode swapPairs(ListNode head) {
        if(head==null) return null;
        ListNode dummy = new ListNode(0);
        ListNode du = dummy;
        du.next = head;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            du.next = cur;
            pre.next = null;
            du = pre;
            pre = temp;
            if(temp==null) break;
            cur = temp.next;
        }
        if(pre!=null) du.next = pre;
        return dummy.next;
    }
    
    /***********官方解法*****************/
    public ListNode swapPairs2(ListNode head) {

        // Dummy node acts as the prevNode for the head node
        // of the list and hence stores pointer to the head node.
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevNode = dummy;

        while ((head != null) && (head.next != null)) {

            // Nodes to be swapped
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // Swapping
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Reinitializing the head and prevNode for next swap
            prevNode = firstNode;
            head = firstNode.next; // jump
        }

        // Return the new head node.
        return dummy.next;
    }
}
