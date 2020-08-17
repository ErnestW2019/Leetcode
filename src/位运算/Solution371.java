package 位运算;
/*
 * 371. 两整数之和
难度
简单

不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
示例 1:
输入: a = 1, b = 2
输出: 3
示例 2:
输入: a = -2, b = 3
输出: 1
 */
public class Solution371 {
    public int getSum(int a, int b) {
        int bit = (a&b)<<1;  //得到进位位
        int sum = a^b;   //无进位相加
        while(bit!=0){
            int tempbit = (sum&bit)<<1;
            sum ^= bit;
            bit = tempbit;
        }
        return sum;
    }
}
