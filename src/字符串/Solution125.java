package 字符串;
/*
 * 125. 验证回文串
难度
简单

给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
说明：本题中，我们将空字符串定义为有效的回文串。
示例 1:
输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:
输入: "race a car"
输出: false
 */
public class Solution125 {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l=0,r=s.length()-1;
        while(l<r){
            if(!Character.isLetter(s.charAt(l))&&!Character.isDigit(s.charAt(l))){
                l++;
            }else if(!Character.isLetter(s.charAt(r))&&!Character.isDigit(s.charAt(r))){
                r--;
            }else if(s.charAt(l)!=s.charAt(r)){
                return false;
            }else{
                l++;
                r--;
            }
        }
        return true;
    }
    public static void main(String[] args) {
    	String s = "race a car";
    	System.out.println(isPalindrome(s));
    }
}
