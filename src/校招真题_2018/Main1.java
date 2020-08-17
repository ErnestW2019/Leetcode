package 校招真题_2018;

import java.util.Scanner;
public class Main1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        //找出三个最大的正数，或者一个最大的正数两个最小的负数。
        long max1=0,max2=0,max3=0;
        long min1=0,min2=0;
        for(int num:nums){
            if(num>max1){
                max3 = max2;
                max2 = max1;
                max1 = num;
            }else if(num>max2&&num<=max1){ //以防测试用例中出现两个一样的数
                max3 = max2;
                max2 = num;
            }else if(num>max3&&num<=max2){
                max3 = num;
            }
            if(num<min1){
                min2 = min1;
                min1 = num;
            }else if(num<min2&&num>min1){
                min2 = num;
            }
        }
        long maxres1 = max1*max2*max3;
        long maxres2 = max1*min1*min2;
        System.out.println(Math.max(maxres1,maxres2));
    }
}