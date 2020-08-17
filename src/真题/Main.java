package 真题;

import java.util.Scanner;

public class Main{
    public int TimeOfgetBall(int N){
        //int []res = new int[zushu];
        /*int []Ball = new int[N];
        for(int i=0;i<N;i++){
            Ball[i] = i+1;
        }*/
        int left = 0;
        int right = N-1;
        int time = 0;
        if(N==2) return 2;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(mid!=0&&mid%2==0) mid++;
            time++;
            right = mid - 1;
        }
        return time;
    }
    /*
    public static void main(String[] args){
        Main s = new Main();
        //int zushu = 3;
        int zushu = 100;
        //int[] nums = new int[]{1,2,5};
        int[] nums = new int[]{926132445,546512853,453945346,597499272,329692904,433790040,795182487,841306922,813089400,155083133,230030645,654469109,251058223,877654447,466081258,554825791,376035835,782867496 ,21683297 ,506419530 ,708309421, 847545198 ,226074007,520225878 ,823366381 ,
        727105971 ,288086361, 84807114 ,571490231 ,134921158, 24638115 ,214395284 ,
        656940294 ,982075225 ,178978927 ,621703483 ,107974251 ,99538036 ,45993233 ,61620952 ,
        14679113 ,898699627 ,985103410 ,327055272 ,407287025 ,35607958 ,900952943 ,408901198,
        454747580 ,48260581 ,514233142 ,35183838 ,215219044 ,823994154 ,895173616 ,705495002 ,
        997266721 ,99381853 ,154466355, 601261034, 483622497 ,810664956 ,209642118 ,227374271 ,
        105947878, 195003955, 164388135, 376675 ,474266134 ,324578246, 578100336 ,916311318,
        839072183, 908536673, 960094713 ,912679605 ,77897555 ,845122565, 518091891 ,671690293,
        570183944 ,9497088 ,496729910, 63623253 ,455097315, 276784363, 465192733, 653771645,
        59177588 ,312776149 ,936235228 ,485757199, 181379471, 165457198 ,640765693, 865979387, 811843362 ,
        333253868, 360391294 ,192576912}; 
        for(int i=0;i<nums.length;i++) {
        	System.out.println(s.TimeOfgetBall(nums[i]));
        }
        //System.out.println(s.TimeOfgetBall(926132445));
        //System.out.println(s.TimeOfgetBall(546512853));
        //System.out.println(s.TimeOfgetBall(453945346));
        
    }*/
    public static void main(String[] args){
        Main s = new Main();
        Scanner sc = new Scanner(System.in);
        int zushu = sc.nextInt();
        int[] nums = new int[zushu];
        for(int i=0;i<zushu;i++) {
        	nums[i] = sc.nextInt();
        }
        for(int i=0;i<zushu;i++) {
        	System.out.println(s.TimeOfgetBall(nums[i]));
        }
        
    }
}
