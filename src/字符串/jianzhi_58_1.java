package 字符串;

public class jianzhi_58_1 {
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String []strs = s.trim().split("\\s+");
        int l=0,r=strs.length-1;
        while(l<r){
            String temp = strs[l];
            strs[l] = strs[r];
            strs[r] = temp;
            l++;
            r--;
        }
        for(String str:strs){
            sb.append(str+" ");
        }
        return sb.toString().substring(0,sb.length()-1);

    }
    public static void main(String[] args) {
    	String s = "  hello world!  ";
  
    	System.out.println(reverseWords(s));
    }
}
