package 字符串;
/*
 * 551. 学生出勤记录 I
难度
简单

给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
'A' : Absent，缺勤
'L' : Late，迟到
'P' : Present，到场
如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
你需要根据这个学生的出勤记录判断他是否会被奖赏。
示例 1:
输入: "PPALLP"
输出: True
示例 2:
输入: "PPALLL"
输出: False
 */
public class Solution551 {
    public boolean checkRecord(String s) {
        int count=0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)=='A')
                count++;
        return count<2 && s.indexOf("LLL")<0;
    }
    /************不使用内置库函数************/
    public boolean checkRecord2(String s) {
        int num_A=0,num_L=0;
        boolean Has_L = false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='A'){
                num_A++;
            }
            else if(s.charAt(i)=='L'){
                num_L++;
                Has_L = true;
            }
            if(num_L<=2&&Has_L&&s.charAt(i)!='L'){
                num_L=0;
                Has_L = false;
            }
            if(num_A>1||num_L>2){
                return false;
            } 
        }
        return true;
    }

}
