package 链表;
/*
 * 234. 回文链表
难度
简单

请判断一个链表是否为回文链表。
示例 1:
输入: 1->2
输出: false
示例 2:
输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        //找到链表的中点
        ListNode f = head;
        ListNode s = head;
        while(f!=null&&f.next!=null){
            f = f.next.next;
            s = s.next;
        }
        //反转链表的后半部分
        ListNode tail = null;
        ListNode cur = s;
        f = cur.next;
        while(f!=null){
            cur.next = tail;
            tail = cur;
            cur = f;
            f = f.next;
        }
        cur.next = tail;
        tail = cur;
        while(head!=null&&tail!=null){
            if(head.val!=tail.val){
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return tail==null||tail.next==null;
    }
}
