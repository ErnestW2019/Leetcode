package 华为机试;
/*
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ） 
最后一个数后面也要有空格 

输入描述:
输入一个long型整数
输出描述:
按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
示例1 
输入
复制
180
输出
复制
2 2 3 3 5
 */
import java.util.*;
public class Main6 {
	    public static void main(String[] args){
	        Scanner sc = new Scanner(System.in);
	        long num = sc.nextLong();
	        while(num!=1){
	            for(int i=2;i<=num;i++){
	                if(num%i==0) {
	                    num /= i;
	                    System.out.print(i+" ");
	                    break;
	                }
	            }
	        }
	        
	    }
}
