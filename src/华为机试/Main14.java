package 华为机试;
import java.util.*;
public class Main14{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String [] str = new String[n];
        for(int i=0;i<n;i++){
        	
        	//str[i] = sc.nextLine();//把上一行的nextInt的换行符也算做了一个字符
        	str[i] = sc.next();
        	//System.out.println(str[i]);
        }
        
        Arrays.sort(str);
        for(int i=0;i<str.length;i++){
            System.out.println(str[i]);
        }
        
        
    }
}