package 真题;
/*
 *  拼多多2020校招部分编程题合集 企业提供原题 
00:55:54 
2/5
[编程题]多多的排列函数
时间限制：C/C++ 1秒，其他语言2秒
空间限制：C/C++ 256M，其他语言512M
数列 {An} 为N的一种排列。 
例如N=3，可能的排列共6种： 
1, 2, 3
1, 3, 2
2, 1, 3
2, 3, 1
3, 1, 2
3, 2, 1
定义函数F: 
F(x)=A
其中|X|表示X的绝对值。 

现在多多鸡想知道，在所有可能的数列 {An} 中，F(N)的最小值和最大值分别是多少。 

输入描述:
第一行输入1个整数T，表示测试用例的组数。
( 1 <= T <= 10 )
第二行开始，共T行，每行包含1个整数N，表示数列 {An} 的元素个数。
( 1 <= N <= 100,000 )

输出描述:
共T行，每行2个整数，分别表示F(N)最小值和最大值

输入例子1:
2
2
3

输出例子1:
1 1
0 2

例子说明1:
对于N=3：
- 当{An}为3，2，1时可以得到F(N)的最小值0
- 当{An}为2，1，3时可以得到F(N)的最大值2
 */
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int zushu = sc.nextInt();
        int N;
        for(int i=0;i<zushu;i++){
        	N = sc.nextInt();
        	get(N, zushu);
        }
    }
    public static void get(int N,int zushu) {
        int min=1,max=1;
        if(N==1||N==2){
            min = 1;
            max = 1;
            //System.out.println(min+" "+max);
        }
        int premin=min;
        for(int i=3;i<=N;i++){
            int temp = i%4;
            if(temp==1||temp==2){
                min = 1;
            }else{
                min = 0;
            }
            
            max = Math.abs(premin-N);
            premin = min;
            
        }
        System.out.println(min+" "+max);
    }
}
