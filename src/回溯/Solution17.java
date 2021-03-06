package 回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 17. 电话号码的字母组合
难度
中等

给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例:
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class Solution17 {
    HashMap<Character,String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        if(digits.length()==0) return list;
        backtrack(sb,digits,list,0,map);
        return list;   
    }

    private void backtrack(StringBuilder sb,String digits,List<String> list,int index,Map<Character,String> map){        
        if(sb.length()==digits.length()){
            list.add(sb.toString());
            return;
        }
        String str = map.get(digits.charAt(index));
        for(int i=0;i<str.length();i++){
            sb.append(str.charAt(i));
            backtrack(sb,digits,list,index+1,map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
