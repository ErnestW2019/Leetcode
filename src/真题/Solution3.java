package 真题;
/*
 *  vivo2020届春季校园招聘在线编程考试 企业提供原题 
01:31:04 
3/3
[编程题]vivo智能手机产能
时间限制：C/C++ 1秒，其他语言2秒
空间限制：C/C++ 256M，其他语言512M
在vivo产线上，每位职工随着对手机加工流程认识的熟悉和经验的增加，日产量也会不断攀升。 
假设第一天量产1台，接下来2天(即第二、三天)每天量产2件，接下来3天(即第四、五、六天)每天量产3件 ... ...  
以此类推，请编程计算出第n天总共可以量产的手机数量。 




输入例子1:
11

输出例子1:
35

例子说明1:
第11天工人总共可以量产的手机数量
 */
public class Solution3 {
    /**
     * 
     * @param n int整型 第n天
     * @return int整型
     */
    /*public int solution (int n) {
        // write code here
        int res = 0;
        int day = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i&&day<n;j++){
                res += i;
                day++;
            }
        }
        return res;
    }*/
    public int solution (int n) {
    	int dp[] = new int[n+1];
    	dp[0] = 0;
    	int num = 1;
    	int count =1;
    	for(int i=1;i<=n;i++) {
    		dp[i] = dp[i-1]+num;
    		
    		if(num == count) {
    			num++;
    			count = 0;
    		}
    		count++;
    		
    	}
    	return dp[n];
    }
    public static void main(String[] args) {
    	Solution3 solution3 = new Solution3();
    	System.out.println(solution3.solution (15));
    }
    
}