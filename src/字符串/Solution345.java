package 字符串;

import java.util.HashSet;

/*
 * 345. 反转字符串中的元音字母
难度
简单
编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
示例 1:
输入: "hello"
输出: "holle"
示例 2:
输入: "leetcode"
输出: "leotcede"
说明:
元音字母不包含字母"y"。
 */
public class Solution345 {
    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int l = 0,r = s.length()-1;
        HashSet<Character> set = new HashSet<Character>(){{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};
        while(l<r){
            if(set.contains(c[l])&&set.contains(c[r])){
                char temp = c[l];
                c[l]=c[r];
                c[r]=temp;
                l++;
                r--;
            }else if(!set.contains(c[l])){
                l++;
            }else if(!set.contains(c[r])){
                r--;
            }
        }
        return new String(c);
    }
}
