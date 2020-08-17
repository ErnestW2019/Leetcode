package 笔试;

import java.util.Arrays;
import java.util.Scanner;

/******输入1-50个数字，求出最小数和最大数的和，输入以逗号隔开*/
public class S4 {
	/*public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String iString = scanner.nextLine();
		String[] array = iString.split(",");
		int nums[] = new int[array.length];
		for(int i=0;i<array.length;i++) {
			nums[i] = Integer.parseInt(array[i]);
		}
		Arrays.sort(nums);
		System.out.println(nums[0]+nums[nums.length-1]);
		
	}*/
	public static void changeStr(String str) {
		str="welcome";
	}
	public static void main(String[] args) {
		String str = "1234";
		changeStr(str);
		System.out.println(str);
	}
}
