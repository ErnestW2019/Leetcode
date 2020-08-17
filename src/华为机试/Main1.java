package 华为机试;

import java.util.*;
public class Main1 {
	    public static void main(String[] args){
	        Scanner sc = new Scanner(System.in);
	        String s = sc.nextLine();
	        String[] str = s.split("\\s+");
            System.out.println(str[str.length-1].length());
	    }
}
