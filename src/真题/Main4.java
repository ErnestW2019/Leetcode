package 真题;

import java.util.Scanner;
public class Main4{
	/*
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //String s = sc.nextLine();
        	String s = sc.next();
            String str = "";
            for(int i=0;i<s.length();i++){
                if((i==0||i==1)&&s.charAt(i)=='0'||s.charAt(i)=='x') continue;
                str += s.charAt(i);
            }
            System.out.println(Long.toString(Long.parseLong(str, 16)));
        }
        
        
    }*/
	/*
	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
		while (sc.hasNext()){
			String str=sc.next();
			System.out.println(Integer.decode(str));
			}
		}
	}*/
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(convert(str));
    }
    private static String convert(String s){
        //int count = 0;
        int ans = 0;
        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            if(ch>='0'&&ch<='9'){
                ans += (ch-'0')*Math.pow(16,s.length()-1-i);
            }else if(ch>='A'&&ch<='F'){
                ans += (ch-'A'+10)*Math.pow(16,s.length()-1-i);
            }else if(ch>='a'&&ch<='f'){
                ans += (ch-'A'+10)*Math.pow(16,s.length()-1-i);
            }else{
                break;
            }
        }
        return String.valueOf(ans);
    }
}
