package 校招真题_2018;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;
public class Main10{
    public static void main(String[] args){
        Queue<Integer> q = new LinkedList<Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int menu[][] = new int[n][2];
        for(int i=0;i<n;i++){
            if(sc.hasNext()){
                menu[i][0] = sc.nextInt();
                menu[i][1] = sc.nextInt();
            }
        }
        //结果数组
        int res[] = new int [n];
        //构造入度表
        int [] in = new int [n];
        int count = 0;
        for(int[] num:menu){
            in[num[0]]++; 
        }
        //寻找入度为0的点,加入到栈中
        for(int i=0;i<in.length;i++){
            if(in[i]==0) {
                q.offer(i);
            }
        }
        boolean flag = true;
        if(q.size()==0) {
        	flag = false;
        	System.out.println("None");
        }
        //去菜肴数组中找入度为0的菜，对应的后置菜肴
        while(!q.isEmpty()){
            int temp = q.poll();
            res[count++] = temp;
            for(int[] num:menu){
                if(num[1]==temp){
                    in[num[0]]--;
                    if(in[num[0]]==0){
                        q.offer(num[0]); 
                    } 
                }
            }
        }
        //检查是否入度都为0了
        for(int degree:in) {
        	if(degree!=0) {
        		System.out.println("None");
        		flag = false;   		
        		break;
        	}
        }
        if(flag) {
            for(int j=0;j<res.length-1;j++) {
            	System.out.print(res[j]+",");
            }
            System.out.print(res[res.length-1]);
            //System.out.println(Arrays.toString(res));	
        }

    }
}
