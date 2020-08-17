package 位运算;
/*
 * 762. 二进制表示中质数个计算置位
难度
简单

给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
（注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）
示例 1:
输入: L = 6, R = 10
输出: 4
解释:
6 -> 110 (2 个计算置位，2 是质数)
7 -> 111 (3 个计算置位，3 是质数)
9 -> 1001 (2 个计算置位，2 是质数)
10-> 1010 (2 个计算置位，2 是质数)
示例 2:
输入: L = 10, R = 15
输出: 5
解释:
10 -> 1010 (2 个计算置位, 2 是质数)
11 -> 1011 (3 个计算置位, 3 是质数)
12 -> 1100 (2 个计算置位, 2 是质数)
13 -> 1101 (3 个计算置位, 3 是质数)
14 -> 1110 (3 个计算置位, 3 是质数)
15 -> 1111 (4 个计算置位, 4 不是质数)
注意:
L, R 是 L <= R 且在 [1, 10^6] 中的整数。
R - L 的最大值为 10000。
 */
public class Solution762 {
    public int countPrimeSetBits(int L, int R) {
        int sum = 0;
        for(int i=L;i<=R;i++){
            if(get(i)==2||get(i)==3||get(i)==5||get(i)==7||get(i)==11||get(i)==13||get(i)==17||get(i)==19||get(i)==23||get(i)==31){
                sum++;
            }
        }
        return sum;
    }
    private int get(int n){
        int count = 0;
        while(n!=0){
            count++;
            n = n&(n-1);
        }
        return count;
    }
    /****************内置函数****************/
    /*public int countPrimeSetBits(int L, int R) {
        int ans = 0;
        for (int x = L; x <= R; ++x)
            if (isSmallPrime(Integer.bitCount(x)))
                ans++;
        return ans;
    }
    public boolean isSmallPrime(int x) {
        return (x == 2 || x == 3 || x == 5 || x == 7 ||
                x == 11 || x == 13 || x == 17 || x == 19);
    }*/
    /*******************更快的解法**************/
    public int countPrimeSetBits2(int L, int R) {
        //0-20的质数列表，prime[i]为1，则i为质数
        int[] primes = {0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1};
        int res = 0;
        for (int i = L; i <= R; i++) {
            int t = Integer.bitCount(i);
            res += primes[t];
        }
        return res;
    }
}
