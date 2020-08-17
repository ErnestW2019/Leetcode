package 真题;

public class Solution {
    /**
     * 输入一个整形数值，返回一个整形值
     * @param n int整型 n>9
     * @return int整型
     */
    public int solution (int n) {
        // write code here
        if(n<10) return 10+n;
        int base = 1,res = 0;
        int min = Integer.MAX_VALUE;
        int temp = n;
        for(int i=9;i>1;i--){
            while(n%i==0){
                
                res += i*base; 
                base *= 10;
                n = n/i;
                
            }
            
        }
        if(n>1) return -1;
        else return res;
    }
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	System.out.println(solution.solution(36));
    }
}
