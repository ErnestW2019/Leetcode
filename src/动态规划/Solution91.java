package 动态规划;
/*
 * 91. 解码方法
难度
中等
一条包含字母 A-Z 的消息通过以下方式进行了编码：
'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。
示例 1:
输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2:
输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
/*********爬台阶变体(带约束)***************/
public class Solution91 {
    public int numDecodings(String s) {
        char[] ch = s.toCharArray();
        int[] dp = new int[ch.length+1];
        dp[0] = 1;
        for(int i=0;i<ch.length;i++){
            dp[i+1] = ch[i]=='0'?0:dp[i];
            if(i>0&&(ch[i-1]=='1'||(ch[i-1]=='2'&&ch[i]<='6'))){
                dp[i+1] += dp[i-1];
            }
        }
        return dp[ch.length];
    }
}
