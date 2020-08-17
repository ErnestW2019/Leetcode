package 笔试;

import java.util.ArrayList;

/*
 * 消除重复数字
 */
public class huawei2 {
	public static void main(String[] args) {
		ArrayList<Character> list = new ArrayList<Character>();
		long a = 45323;
		String s = Long.toString(a);
		for(int i=0;i<s.length();i++) {
			list.add(s.charAt(i));
		}
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<i;j++) {
				if(list.get(i)==list.get(j)) {		
					if(list.get(j+1)>list.get(j)) {
						list.remove(j);
						i--;
						break;
					}else {
						list.remove(i);
						i--;
						break;
					}
						
				}
			}
		}
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i));
		}
		
		
	}
}
