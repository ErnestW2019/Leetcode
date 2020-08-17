package 堆;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/*
 * 451. 根据字符出现频率排序
难度
中等

给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
示例 1:
输入:
"tree"

输出:
"eert"

解释:
'e'出现两次，'r'和't'都只出现一次。
因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
示例 2:
输入:
"cccaaa"

输出:
"cccaaa"

解释:
'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
注意"cacaca"是不正确的，因为相同的字母必须放在一起。
示例 3:
输入:
"Aabb"

输出:
"bbAa"

解释:
此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
注意'A'和'a'被认为是两种不同的字符。
 */
public class Solution451 {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        char[] str = s.toCharArray();
        for(char ch:str){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list,new Comparator<Character>(){
            @Override
            public int compare(Character o1,Character o2){
                return map.get(o2)-map.get(o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Character c:list){
            int time = map.get(c);
            while(time-->0){
                sb.append(c);
            }
            
        }
        return sb.toString();
    }
}
