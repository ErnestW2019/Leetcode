package 华为机试;

import java.util.*;
public class Main26 {
	//　next()不会吸取字符前/后的空格/Tab键，只吸取字符，开始吸取字符（字符前后不算）直到遇到空格/Tab键/回车截止吸取；
	//nextLine()吸取字符前后的空格/Tab键，回车键截止。
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNext()){
            String str = sc.nextLine();
            List<Character> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            char[] ch = str.toCharArray();
            for(char c:ch){
                if(Character.isLetter(c)) list.add(c);
            }
            Collections.sort(list,new Comparator<Character>(){
                @Override
                public int compare(Character o1,Character o2){
                    return Character.toLowerCase(o1)-Character.toLowerCase(o2);
                }
            });
            int index = 0;
            for(int i=0;i<ch.length;i++){
                if(Character.isLetter(ch[i])&&index<list.size()) sb.append(list.get(index++));
                else{
                    sb.append(ch[i]);
                }
            }
            System.out.println(sb.toString());
        }
    }
}

