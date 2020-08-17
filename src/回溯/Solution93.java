package 回溯;

import java.util.ArrayList;
import java.util.List;

/*
 * 93. 复原IP地址
难度
中等
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 
示例:
输入: "25525511135"
输出: ["255.255.11.135", "255.255.111.35"]
 */
public class Solution93 {
    public final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<>();
    int[] segment;
    public List<String> restoreIpAddresses(String s) {
        segment = new int[4];
        dfs(s,0,0);
        return ans;
    }
    private void dfs(String s,int segId,int start){
        //找到一个满足条件的的IP地址
        if(segId==SEG_COUNT){
            if(start == s.length()){
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<segment.length;i++){
                    sb.append(segment[i]);
                    if(i!=segment.length-1){
                        sb.append(".");
                    }
                }
                ans.add(sb.toString());
            }
            return;
        }
        if(start==s.length()) return;
        //考虑出现0的情况
        if(s.charAt(start)=='0'){
            segment[segId] = 0;
            dfs(s,segId+1,start+1);
        }
        //普通情况，
        int val = 0;
        for(int end = start;end<s.length();end++){
            val = val*10+s.charAt(end)-'0';
            if(val>0&&val<=0xFF){
                segment[segId] = val;
                dfs(s,segId+1,end+1);
            }else{
                break;
            }
        }
    }
    
    public static void main(String[] args) {
    	String s = "25525511135";
    	Solution93 solution93 = new Solution93();
    	System.out.println(solution93.restoreIpAddresses(s));
    }
}
