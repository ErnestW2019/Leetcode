package 字符串;

public class Solution443 {
    public static int compress(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }
    public static void main(String[] args) {
    	char[] chars = new char[] {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
    	//char[] chars = new char[] {'a','a','a','b','b','a','a'};
    	System.out.println(compress(chars));
    }
}
