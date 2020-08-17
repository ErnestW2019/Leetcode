package 华为机试;

import java.util.*;

public class Main4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            process(s1);
            process(s2);
        }
	}
    private static void process(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        while(sb.length()<8){
            sb.append(0);
        }
        
        if(sb.length()==8) System.out.println(sb.substring(0,8).toString());
        if(sb.length()>8){
        	int i=0;
        	for(;i+8<sb.length();i+=8) {
        		System.out.println(sb.substring(i,i+8));
        	}
        	sb.append("00000000");
        	System.out.println(sb.substring(i,i+8));     	
        }
    }
}
