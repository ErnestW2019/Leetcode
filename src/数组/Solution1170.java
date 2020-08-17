package 数组;

import java.util.ArrayList;

public class Solution1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int num1[] = new int[queries.length];
        int num2[] = new int[words.length];

        for(int i=0;i<queries.length;i++){
            
            num1[i] = transfer(queries[i]);
        }
        for(int i=0;i<words.length;i++){
            num2[i] = transfer(words[i]);
        }
        int count = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<queries.length;i++){
            for(int j=0;j<words.length;j++){
                if(num1[i]<num2[j]){
                    count++;
                }
            }
            list.add(count);
            count = 0;
        }
        int res[] = new int[list.size()];
        for(int i=0;i<res.length;i++){
            res[i] = list.get(i);
        }
        return res;

    }
    private int transfer(String str){
        int [] bucket = new int[26];
        int res = 0;
        for(int i=0;i<str.length();i++){
            bucket[str.charAt(i)-'a']++;
        }
        for(int i=0;i<bucket.length;i++){
            if(bucket[i]!=0) {
                res = bucket[i];
                break;
            }
        }
        return res;
    }
}
