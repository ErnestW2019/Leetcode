package 华为机试;

import java.util.Scanner;

public class Main29{
    public static void main(String[ ] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.nextLine();
            String result1 = Encrypt(str1);
            System.out.println(result1);
            String str2 = sc.nextLine();
            String result2 = unEncrypt(str2);      
            System.out.println(result2);
        }

    }
    public static String Encrypt(String str){
        char[] aunPassword = str.toCharArray();
        for(int i=0;i<aunPassword.length;i++){
            if(aunPassword[i]>='a'&&aunPassword[i]<='z'){
                if(aunPassword[i]=='z') aunPassword[i] = 'A';
                else aunPassword[i] = Character.toUpperCase((char)(aunPassword[i]+1));
            }else if(aunPassword[i]>='A'&&aunPassword[i]<='Z'){
                if(aunPassword[i]=='Z') aunPassword[i] = 'a';
                else aunPassword[i] = Character.toLowerCase((char)(aunPassword[i]+1));
            }else if(Character.isDigit(aunPassword[i])){
                if(aunPassword[i]=='9') aunPassword[i] = '0';
                else aunPassword[i] = (char)(aunPassword[i]+1); 
            }
        }
        return String.valueOf(aunPassword);
    }
    public static String unEncrypt(String str){
        char[] Password = str.toCharArray();
        for(int i=0;i<Password.length;i++){
            if(Password[i]>='a'&&Password[i]<='z'){
                if(Password[i]=='a') Password[i] = 'Z';
                else Password[i] = Character.toUpperCase((char)(Password[i]-1));
            }else if(Password[i]>='A'&&Password[i]<='Z'){
                if(Password[i]=='A') Password[i] = 'z';
                else Password[i] = Character.toLowerCase((char)(Password[i]-1));
            }else if(Character.isDigit(Password[i])){
                if(Password[i]=='0') Password[i] = '9';
                else Password[i] = (char)(Password[i]-1); 
            }
        }
        return String.valueOf(Password);
    }
}