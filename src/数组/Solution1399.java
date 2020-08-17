package 数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1399 {
    public static int countLargestGroup(int n) { //19ms
        HashMap<Integer,List<Integer>> map  = new HashMap<Integer,List<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=1;i<=n;i++){
        	int temp = sumbit(i);
            if(map.containsKey(temp)){
                map.get(temp).add(i);
                //map.put(temp,list);
            }else{
                list = new ArrayList<Integer>();
                list.add(i);
                map.put(temp,list);
            }   
        }
        int max = 0;
        int count = 1;
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            if(entry.getValue().size()>max){
                max = entry.getValue().size();
                count=1;
            }else if(entry.getValue().size()==max){
                count++;
            }
        }
        return count;
    }
    private static int sumbit(int x){
        int sum=0;
        while(x>0){
            sum += x%10;
            x /= 10; 
        }
        return sum;
    }
    public static void main(String[] args) {
    	int n = 10000;
    	System.out.println(countLargestGroup(n));
    	System.out.println(countLargestGroup(n));
    }
}
