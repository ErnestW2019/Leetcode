package 华为机试;

import java.util.Scanner;
/*
 * 动态规划求最大递增子序列，正向和反向，最后相加
 * 计算其位于正向递增子序列中的位置，则表示位于i前面，小于A[i]且保持递增的有多少个元素；
计算其位于反向递增子序列中的位置，则表示位于i后面，大于A[i]且保持递减的有多少个元素；
将每个元素所在正向递增子序列中的位置+所在反向递减子序列中的位置相加，取最大者对应的下标i，即为所求的分界点i。
 */

//相加的结果表示。当前自己如果为中间那个人，那么可以得到的最大的合唱队人数，并且自己加了2次，所以要剪掉一次

public class Main24 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
        	int n = sc.nextInt();
        	int[] height = new int[n];
            for(int i=0;i<n;i++){
                height[i] = sc.nextInt();
            }
            int[] left = left(height);
            int[] right = right(height);
            int max = 0;
            for(int i=0;i<n;i++){
                max = Math.max(left[i]+right[i]-1,max);
            }
            System.out.println(n-max);
        }
    }
    //左边最大递增子序列
    public static int[] left(int[] A){
        int[] left = new int[A.length];
        for(int i=0;i<A.length;i++){
            left[i] = 1;
            for(int j=0;j<i;j++){
                if(A[j]<A[i]){
                    left[i] = Math.max(left[i],left[j]+1);
                }
            }
        }
        return left;
    }
    public static int[] right(int[] A){
        int[] right = new int[A.length];
        for(int i=A.length-1;i>=0;i--){
            right[i] = 1;
            for(int j=A.length-1;j>i;j--){
                if(A[j]<A[i]){
                    right[i] = Math.max(right[i],right[j]+1);
                }
            }
        }
        return right;
    }
}