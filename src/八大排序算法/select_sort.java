package 八大排序算法;
/*
 * 在长度为N的无序数组中，第一次遍历n-1个数，找到最小的数值与第一个元素交换；
第二次遍历n-2个数，找到最小的数值与第二个元素交换；
。。。
第n-1次遍历，找到最小的数值与第n-1个元素交换，排序完成。
 */
import java.util.Arrays;

//时间复杂度O（n2）
public class select_sort {
	private static void select_sort(int[] a, int size) {
		// TODO Auto-generated method stub
		for(int i=0;i<size-1;i++) {
			int minIndex = i;
			for(int j=i+1;j<size;j++) {
				if(a[j]<a[minIndex]) {
					minIndex = j;
				}
			}
			int temp = a[i];
			a[i] = a[minIndex];
			a[minIndex] = temp;
		}
	}
	
	
	public static void main(String[] args) {
		int[] a = new int[] {4,2,5,6,1,0,3,7}; 
		select_sort(a,8);
		System.out.println(Arrays.toString(a));
	}


}
