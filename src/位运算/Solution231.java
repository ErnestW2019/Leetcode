package 位运算;
/*
 * 231. 2的幂
难度
简单

给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
示例 1:
输入: 1
输出: true
解释: 20 = 1
示例 2:
输入: 16
输出: true
解释: 24 = 16
示例 3:
输入: 218
输出: false
 */
public class Solution231 {
	/************调用计算二进制位1的个数的函数*************************/
    /*public boolean isPowerOfTwo(int n) {
    	if(n<0) return false;
        return bit1(n)==1;
    }
    private int bit1(int n){
        int count = 0;
        while(n!=0){
            n = n&(n-1);
            count++;
        }
        return count;
    }*/
    
    /****************一条语句*********************/
    public boolean isPowerOfTwo(int n) {
    	return (n>0)&&(n&(n-1))==0?true:false;
    }
    public static void main(String[] args) {
    	int n = -2147483648;
    	Solution231 solution231 = new Solution231();
    	System.out.println(solution231.isPowerOfTwo(n));
    }
}
