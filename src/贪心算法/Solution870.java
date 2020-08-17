package 贪心算法;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/*
 * 870. 优势洗牌
难度
中等

给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
返回 A 的任意排列，使其相对于 B 的优势最大化。
 
示例 1：
输入：A = [2,7,11,15], B = [1,10,4,11]
输出：[2,11,7,15]
示例 2：
输入：A = [12,24,8,32], B = [13,25,32,11]
输出：[24,32,8,12]
 
提示：
1 <= A.length = B.length <= 10000
0 <= A[i] <= 10^9
0 <= B[i] <= 10^9
 */
public class Solution870 {
    public static int[] advantageCount(int[] A, int[] B) {
        int[] sortedA = A.clone();
        Arrays.sort(sortedA);
        int[] sortedB = B.clone();
        Arrays.sort(sortedB);
        HashMap<Integer,Deque<Integer>> map = new HashMap<>();
        Deque<Integer> deq = new LinkedList<>();
        Deque<Integer> remain = new LinkedList<>();
        for(int i=0,j=0;i<sortedA.length&&j<sortedB.length;i++){
            if(sortedA[i]>sortedB[j]){
                if(map.containsKey(sortedB[j])){
                    map.get(sortedB[j]).add(sortedA[i]);
                    
                }else{
                    deq = new LinkedList<>();
                    deq.add(sortedA[i]);
                    map.put(sortedB[j],deq);
                }
                j++;
            }else{
                remain.add(sortedA[i]);
            }
        }
        int [] res = new int[B.length];
        //int index = 0;
        for(int i=0;i<B.length;i++){
        	if(map.containsKey(B[i])&&map.get(B[i]).size()>0) res[i] = map.get(B[i]).pop();
            else {
                res[i] = remain.pop();
            }
        }
        return res;
    }
    public static void main(String[] args) {
    	int [] A = new int[] {1,2,0,2,2,4};
    	int [] B = new int[] {1,0,2,0,2,3};
    	System.out.println(Arrays.toString(advantageCount(A,B)));
    }
}
