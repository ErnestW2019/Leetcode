package 字符串;
/*
 * 917. 仅仅反转字母
难度
简单

给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 

示例 1：
输入："ab-cd"
输出："dc-ba"
示例 2：
输入："a-bC-dEf-ghIj"
输出："j-Ih-gfE-dCba"
示例 3：
输入："Test1ng-Leet=code-Q!"
输出："Qedo1ct-eeLg=ntse-T!"
 
提示：
S.length <= 100
33 <= S[i].ASCIIcode <= 122 
S 中不包含 \ or "
 */
public class Solution917 {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int i=0,j=S.length()-1;
        while(i<j){
            if(Character.isLetter(S.charAt(i))&&Character.isLetter(S.charAt(j))){
                char ch1 = chars[i];
                chars[i]=chars[j];
                chars[j]=ch1;
                i++;
                j--;
            }else if(!Character.isLetter(chars[i])){
                i++;
            }else if(!Character.isLetter(chars[j])){
                j--;
            }
        }
        return String.valueOf(chars);
    }
}
