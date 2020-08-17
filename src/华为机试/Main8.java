package 华为机试;

import java.util.*;
public class Main8{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int pair = sc.nextInt();
        for(int i=0;i<pair;i++){
            int index = sc.nextInt();
            int value = sc.nextInt();
            if(map.containsKey(index)){
                map.put(index,map.get(index)+value);
            }
            else map.put(index,value);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        
    }
}