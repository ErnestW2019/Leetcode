package 字符串;
/*
 * 541. 反转字符串 II
难度
简单

给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 
示例:
输入: s = "abcdefg", k = 2
输出: "bacdfeg"
 
提示：
该字符串只包含小写英文字母。
给定字符串的长度和 k 在 [1, 10000] 范围内。
 */
public class Solution541 {
    public String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        for(int i=0;i<c.length;i=i+2*k){
            if(i+k>=c.length){
                reverse(c,i,c.length-1);
            }
            else{
                reverse(c,i,i+k-1);
            }
        }
        return String.valueOf(c);
    }
    private void reverse(char[] c,int m,int n){
        while(m<n){
            char temp = c[m];
            c[m] = c[n];
            c[n] = temp;
            m++;
            n--;
        }
    }
}
