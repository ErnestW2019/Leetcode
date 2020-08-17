package 字符串;

public class Solution1108 {
    public String defangIPaddr(String address) {
        //return address.replace(".","[.]");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<address.length();i++){
            if(address.charAt(i)=='.'){
                sb.append("[.]");
                continue;
            }
            sb.append(address.charAt(i));
        }
        return sb.toString();
    }
}
