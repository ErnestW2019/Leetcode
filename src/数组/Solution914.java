package 数组;

import java.util.HashMap;

public class Solution914 {
    public static boolean hasGroupsSizeX(int[] deck) {
        if(deck.length<2) return false;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<deck.length;i++){
            map.put(deck[i],map.getOrDefault(deck[i],0)+1);
        }
        int t = 0;
        for(int a:map.values()){
            t = gcd(t,a);
        }
        return t>=2;

    }
    //求最大公约数
    private static int gcd(int a,int b){
        return b==0?a:gcd(b,a%b); 
    }
    public static void main(String[] args) {
    	int deck[] = new int[] {1,1,2,2,2,2}; 
    	System.out.println(hasGroupsSizeX(deck));
    }
}
