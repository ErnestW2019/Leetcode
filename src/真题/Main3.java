package 真题;

import java.util.TreeSet;
import java.util.Iterator;
import java.util.Scanner;
public class Main3{
    public static void main(String[] args){
        TreeSet<Integer> set = new TreeSet<Integer>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
        	int len = sc.nextInt();
            for(int i=0;i<len;i++){
                int k = sc.nextInt();
                set.add(k);
            }
            Iterator<Integer> itSet = set.iterator();
            while(itSet.hasNext()) {
            	System.out.println(itSet.next());
            }
            set.clear();
            
        }
    }
}