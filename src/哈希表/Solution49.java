package 哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 49. 字母异位词分组
难度
中等
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
示例:
输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：
所有输入均为小写字母。
不考虑答案输出的顺序。
 */
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        //List<List<String>> res = new ArrayList<List<String>>();
        Map<String,List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());               
            }   
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}
