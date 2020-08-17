package 字符串;

import java.util.HashSet;

public class Solution824 {
	public static String toGoatLatin(String S) {
		//S.toLowerCase();
		String[] str = S.split(" ");
		StringBuilder sb = new StringBuilder();
		HashSet<Character> set = new HashSet<Character>() {{
			 add('a');
			 add('e');
			 add('i');
			 add('o');
			 add('u');
		 }};
		 for(int i=0;i<str.length;i++) {
			 char ch = str[i].charAt(0);
			 int index = i+1;
			 char temp = Character.toLowerCase(ch);
			 if(set.contains(temp)) {
				 sb.append(str[i]+"ma");
			 } 
			 else {
				 sb.append(str[i].substring(1));
				 sb.append(ch+"ma");
			 }
			 while(index-->0) {
				 sb.append("a");
			 }
			 sb.append(" ");
		 }	 
		 return sb.substring(0,sb.length()-1).toString();
	}
	public static void main(String[] args) {
		//String S = "The quick brown fox jumped over the lazy dog";
		String S = "I open the door";

		System.out.println(toGoatLatin(S));
	}
}
