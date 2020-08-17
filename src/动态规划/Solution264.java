package 动态规划;
/*
 * 264. 丑数 II
难度
中等

编写一个程序，找出第 n 个丑数。
丑数就是质因数只包含 2, 3, 5 的正整数。
示例:
输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
说明:  
1 是丑数。
n 不超过1690。
 */
public class Solution264 {
    public int nthUglyNumber(int n) {
        int dp[] = new int[n];
        int ugly = 1;
        int i2=0,i3=0,i5=0;
        dp[0] = 1;
        for(int i=1;i<n;i++){
            ugly = Math.min(dp[i2]*2,Math.min(dp[i3]*3,dp[i5]*5));
            dp[i] = ugly;
            if(dp[i2]*2==ugly) ++i2;
            if(dp[i3]*3==ugly) ++i3;
            if(dp[i5]*5==ugly) ++i5;
        }
        return dp[n-1];
    }
}
