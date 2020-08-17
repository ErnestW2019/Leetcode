package 真题;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Main1 m = new Main1();
        Scanner sc = new Scanner(System.in);
        int n;
        while(sc.hasNext()){
            n = sc.nextInt();
            if(n>0) System.out.println(m.get(n));
        }
    }
    public int get(int n){
        if(n==1) return 0;
        if(n==2) return 1;
        return n/3+get(n/3+n%3);
    }
}
