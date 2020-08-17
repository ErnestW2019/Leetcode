package 字符串;
/*
 * 709. 转换成小写字母
难度
简单

实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 
示例 1：
输入: "Hello"
输出: "hello"
示例 2：
输入: "here"
输出: "here"
示例 3：
输入: "LOVELY"
输出: "lovely"
 */
public class Solution709 {
    public String toLowerCase(String str) {
        //return str.toLowerCase();
        char[] strs = str.toCharArray();
        for(int i=0;i<strs.length;i++){
            if(strs[i]<=90&&strs[i]>=65){
                strs[i] += 32;
            }
        }
        return String.valueOf(strs);
    }
}
