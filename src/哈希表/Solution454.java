package 哈希表;
/*
 * 454. 四数相加 II
难度
中等
给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
例如:
输入:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

输出:
2

解释:
两个元组如下:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
import java.util.HashMap;
import java.util.Map;

public class Solution454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> map1 = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> map2 = new HashMap<Integer,Integer>();
        for(int i=0,k=0;i<A.length&&k<C.length;i++,k++){
            for(int j=0,l=0;j<B.length&&l<D.length;j++,l++){
                map1.put(A[i]+B[j],map1.getOrDefault(A[i]+B[j],0)+1);
                map2.put(C[k]+D[l],map2.getOrDefault(C[k]+D[l],0)+1);
            }
        }
        int cnt=0;
        for(Map.Entry<Integer,Integer> entry:map1.entrySet() ){
            int temp = entry.getKey()*-1;
            if(map2.containsKey(temp)){
                //cnt += Math.min(entry.getValue(),map2.get(temp));
                cnt += entry.getValue()*map2.get(temp);
            }
        }
        return cnt;
    }
    /*************优化，一个map*****************///93ms
    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        //Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0;i<A.length;i++){
            for(int j= 0;j<B.length;j++){
                int sumAB = A[i]+B[j];
                if(map.containsKey(sumAB)) map.put(sumAB,map.get(sumAB)+1);
                else map.put(sumAB,1);
            }
        }

        for(int i = 0;i<C.length;i++){
            for(int j = 0;j<D.length;j++){
                int sumCD = -(C[i]+D[j]);
                if(map.containsKey(sumCD)) res += map.get(sumCD);
            }
        }
        return res;
    }
}
