package 华为机试;

import java.util.Scanner;

public class Main10 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(sc.hasNext()){
        	String str = sc.nextLine();
            int [] map = new int[128];
            int cnt = 0;
            for(int i=str.length()-1;i>=0;i--){
                if(map[str.charAt(i)]==0){
                    map[str.charAt(i)]++;
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}