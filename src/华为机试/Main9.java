package 华为机试;

import java.util.Scanner;

public class Main9 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(sc.hasNext()){
        	int num = sc.nextInt();
            String str = String.valueOf(num);
            int [] map = new int[10];
            for(int i=str.length()-1;i>=0;i--){
                map[str.charAt(i)-'0']++;
            }
            for(int i=str.length()-1;i>=0;i--){
                //if(str.charAt(i))
                if(map[str.charAt(i)-'0']>0){
                    sb.append(str.charAt(i));
                    map[str.charAt(i)-'0'] = 0;
                }
            }
            System.out.println(Integer.parseInt(sb.toString()));
        }
    }
}
