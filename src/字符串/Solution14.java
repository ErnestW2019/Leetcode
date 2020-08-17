package 字符串;

public class Solution14 {
    public String longestCommonPrefix(String[] strs) { //14ms
        String res = "";
        if(strs.length==0) return res;
        for(int j=0;j<strs[0].length();j++){
            int i=0;
            for(;i<strs.length-1;i++){
                if(j>strs[i+1].length()-1||strs[i].charAt(j)!=strs[i+1].charAt(j)){
                    return res;
                }
            }
            if(i==strs.length-1) res += strs[i].charAt(j);
        }
        return res;
    }
    public static String longestCommonPrefix2(String[] strs) { //1ms
        if(strs.length==0) return "";
        for(int i=0;i<strs[0].length();i++){
            //提取要比较的字符
            char ch = strs[0].charAt(i);
            for(int j = 1;j<strs.length;j++){
                if(i==strs[j].length()||ch!=strs[j].charAt(i)){
                	 return strs[0].substring(0,i);
                }
            }
           
        }
        return strs[0];
    }
}
