package 华为机试;

import java.util.*;

public class Main20 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.next();
            if(check1(str)&&check2(str)&&check3(str)){
                System.out.println("OK");
            }
            else System.out.println("NG");
            
        }
        
    }

    public static boolean check1(String str){
            //长度超过8
            if(str.length()<=8){
                return false;
            }
            return true;
    }
    public static boolean check2(String str){
            //包括大小写字母，数字，其他符号以上四种中的至少三种
            int catagory=0;
            boolean Has[] = new boolean[4];
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                if(!Has[0]&&ch>='0'&&ch<='9') {
                    catagory++;
                    Has[0]=true;
                }
                else if(!Has[1]&&ch>='a'&&ch<='z'){
                    catagory++;
                    Has[1]=true;
                }
                else if(!Has[2]&&ch>='A'&&ch<='Z'){
                    catagory++;
                    Has[2]=true;
                }
                else if(!Has[3]&&!Character.isLetterOrDigit(ch)){
                    catagory++;
                    Has[3]=true;
                }
            }
        if(catagory<3) return false;
        return true;
     }
    
     public static boolean check3(String str){
            //不能有相同长度大于2的子串重复
            for(int i=0;i<str.length();i++){
                for(int j=i+3;j<str.length();j++){
                    if(str.substring(j).contains(str.substring(i,j))) return false;
                }
            }
            return true;
     }
}