package 字符串;
/*
 * 459. 重复的子字符串
难度
简单
给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
示例 1:
输入: "abab"

输出: True

解释: 可由子字符串 "ab" 重复两次构成。
示例 2:
输入: "aba"

输出: False
示例 3:
输入: "abcabcabcabc"

输出: True

解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for(int i=1;i<=s.length()/2;i++){
            if(len%i==0){
                if(judge(s.substring(0,i),s)){
                    return true;
                }
            }
        }
        return false;
    }
    //判断s1是否能经过N次拼接而成为s2;
    private boolean judge(String s1,String s2){
        String res = "";
        for(int i=s1.length();i<s2.length();i++){
            if(s1.charAt(i%s1.length())!=s2.charAt(i)){
                return false;
            }
        }
        return true;
    } 
}
