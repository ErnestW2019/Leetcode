package 笔试;


/**********华为2019秋招笔试***********/
//整数反转求和
public class huawei1 {
	public static void main(String[] args) {
		int a = 400;
		int b = 100;
		System.out.println(Integer.reverse(a));
		//System.out.println(reverseAdd(a,b));
	}
	public static int reverseAdd(int a,int b) {
		if(a<1||a>70000) return -1;
		if(b<1||b>70000) return -1;
		int ra = 0,rb = 0;
		while(a>0) {
			ra = ra*10+a%10;
			a = a/10;
		}
		while(b>0) {
			rb = rb*10+b%10;
			b = b/10;
		}
		return ra+rb;
	}
}
