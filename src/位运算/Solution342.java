package 位运算;
/*
 * 342. 4的幂
难度
简单

给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
示例 1:
输入: 16
输出: true
示例 2:
输入: 5
输出: false
进阶：
你能不使用循环或者递归来完成本题吗？
 */
public class Solution342 {
    public boolean isPowerOfFour(int num) {
        if(num<0||(num&(num-1))!=0) return false;
        while(num>0){
            if(num==1) return true;
            num = num>>2;
            
        }
        return false;
    }
    //return num>0&&(num&(num-1))==0&&num%3==1; 方法二
    //return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0);方法三
}
