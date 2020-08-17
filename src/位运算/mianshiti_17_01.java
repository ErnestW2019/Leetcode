package 位运算;
/*
 * 面试题 17.01. 不用加号的加法
难度
简单

设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
示例:
输入: a = 1, b = 1
输出: 2
 
提示：
a, b 均可能是负数或 0
结果不会溢出 32 位整数
 */
public class mianshiti_17_01 {
    public int add(int a, int b) {
        //异或，不带进位位相加
        int sum = a^b;
        int carry = (a&b)<<1;
        while(carry!=0){
            a = sum;
            b = carry;
            sum = a^b;
            carry = (a&b)<<1;
        }
        return sum;
    }
}
