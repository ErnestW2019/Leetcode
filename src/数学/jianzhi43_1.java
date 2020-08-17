package 数学;
/*
 * 剑指 Offer 43. 1～n整数中1出现的次数
难度
中等

输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 
示例 1：
输入：n = 12
输出：5
示例 2：
输入：n = 13
输出：6
 
限制：
1 <= n < 2^31
 */
public class jianzhi43_1 {
    public int countDigitOne(int n) {
        int digit = 1;
        int res = 0;
        int high = n/10,cur = n%10,low = 0;
        while(n/digit>0){
            if(cur==0){
                res += high*digit;
            }else if(cur==1){
                res += high*digit+1+low;
            }else if(cur>1&&cur<=9){
                res += (high+1)*digit;
            }
            low += cur*digit;
            cur = high%10;
            high = high/10;
            digit *= 10;
        }
        return res;
    }
}
