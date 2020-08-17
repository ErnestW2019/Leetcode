package 链表;

import java.util.HashMap;

/*
 * 817. 链表组件
难度
中等

给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。
同时给定列表 G，该列表是上述链表中整型值的一个子集。
返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。
 
示例 1：
输入: 
head: 0->1->2->3
G = [0, 1, 3]
输出: 2
解释: 
链表中,0 和 1 是相连接的，且 G 中不包含 2，所以 [0, 1] 是 G 的一个组件，同理 [3] 也是一个组件，故返回 2。
示例 2：
输入: 
head: 0->1->2->3->4
G = [0, 3, 1, 4]
输出: 2
解释: 
链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
 
提示：
如果 N 是给定链表 head 的长度，1 <= N <= 10000。
链表中每个结点的值所在范围为 [0, N - 1]。
1 <= G.length <= 10000
G 是链表中所有结点的值的一个子集.
 */
public class Solution817 {
    public int numComponents(ListNode head, int[] G) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        ListNode p = head;
        for(int i=0;i<G.length;i++){
            map.put(G[i],map.getOrDefault(G[i],0)+1);
        }
        int cnt = 0;
        int k=0;
        while(p!=null){            
            if(map.containsKey(p.val)){
                k++;    
            }
            else if(k!=0){
                cnt++;
                k=0;
            } 
            p=p.next;
        }
        return k==0?cnt:cnt+1;
    }
}
