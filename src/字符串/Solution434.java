package 字符串;
/*
 * 434. 字符串中的单词数
难度
简单

统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
请注意，你可以假定字符串里不包括任何不可打印的字符。
示例:
输入: "Hello, my name is John"
输出: 5
解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 */
public class Solution434 {
    public int countSegments(String s) {
        
        if(s.length()==0) return 0;
        String trimed = s.trim();
        if(trimed.length()==0) return 0;
        String[] str = trimed.split("\\s+");
        return str.length;
    }

}
