package 字符串;
/*
 * 1071. 字符串的最大公因子
难度
简单

对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 
示例 1：
输入：str1 = "ABCABC", str2 = "ABC"
输出："ABC"
示例 2：
输入：str1 = "ABABAB", str2 = "ABAB"
输出："AB"
示例 3：
输入：str1 = "LEET", str2 = "CODE"
输出：""
 
提示：
1 <= str1.length <= 1000
1 <= str2.length <= 1000
str1[i] 和 str2[i] 为大写英文字母
 */
public class Solution1071 {
	/*  //利用字符串的拼接
    public String gcdOfStrings(String str1, String str2) {
        if(!((str1+str2).equals(str2+str1))){
            return "";
        }
        return str1.substring(0,gcd(str1.length(),str2.length()));
    }
    private int gcd(int m,int n){
        if(n==0) return m; 
        return gcd(n,m%n);
    }*/
    /**************朴素解法********************/
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int yueshu = gcd(len1,len2);
        int time1 = len1/yueshu;
        int time2 = len2/yueshu;
        if(check(str1,str1.substring(0,yueshu),time1)&&check(str2,str1.substring(0,yueshu),time2)){
            return str1.substring(0,yueshu);
        }
        else{
            return "";
        }
    }
    private boolean check(String str,String s,int time){
        String res = "";
        while(time-->0){
            res += s;
        }
        if(res.equals(str)) return true;
        return false;
    }
    private int gcd(int m,int n){
        if(n==0) return m; 
        return gcd(n,m%n);
    }
}
