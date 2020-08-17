package 校招真题_2018;

import java.util.Scanner;
import java.util.HashSet;
public class Main5{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            HashSet<Character> set = new HashSet<>();
            char[] ch = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            for(char c:ch){
                if(set.add(c)){
                    sb.append(c);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
