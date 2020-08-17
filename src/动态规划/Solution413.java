package 动态规划;

import java.util.HashMap;
import java.util.Map;

public class Solution413 {
    public static int numberOfArithmeticSlices(int[] A) {
        //Arrays.sort(A);
        if(A.length==0) return 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int dp[] = new int[A.length];
        dp[0] = A[0];
        for(int i=1;i<A.length;i++){
            dp[i] = A[i]-A[i-1];
        }
        int cnt=1;
        int k=0;
        for(int i=2;i<dp.length;i++){
            if(dp[i]==dp[i-1]){
                cnt++;
            }else if(dp[i]!=dp[i-1]&&cnt>1){
                map.put(k,cnt);
                cnt = 1;
                k++;
            }
            if(i==dp.length-1) {
            	map.put(k, cnt);
                k++;
            }
        }
        int sum = 0;
        for(Map.Entry<Integer,Integer> entry :map.entrySet()){
            int n = entry.getValue();
            sum += n*(n-1)/2;
        }
        return sum;
    }
    //简化不用map
    public static int numberOfArithmeticSlices2(int[] A) {
        if(A.length==0) return 0;
        int dp[] = new int[A.length];
        dp[0] = A[0];
        for(int i=1;i<A.length;i++){
            dp[i] = A[i]-A[i-1];
        }
        int sum=0,cnt=1;
        for(int i=2;i<dp.length;i++){
            if(dp[i]==dp[i-1]){
                sum += cnt++;
            }else if(dp[i]!=dp[i-1]){
                cnt = 1;
            }

        }
        return sum;
    }
    //直接遍历，不用dp存储
    public static int numberOfArithmeticSlices3(int[] A) {
        if(A.length==0) return 0;
        int sum=0,cnt=1;
        for(int i=2;i<A.length;i++){
            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
                sum += cnt++;
            }else if(A[i]!=A[i-1]){
                cnt = 1;
            }

        }
        return sum;
    }

    public static void main(String[] args) {
    	int A[] = new int[] {1,2,3,4,6,8,10,12};
    	System.out.println(numberOfArithmeticSlices(A));
    }
}
