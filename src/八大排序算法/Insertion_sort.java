package 八大排序算法;
/*
 * 在要排序的一组数中，假定前n-1个数已经排好序，
 * 现在将第n个数插到前面的有序数列中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
 */
import java.util.Arrays;

public class Insertion_sort {
	
	
	public static void main(String[] args) {
		int[] a = new int[] {4,2,5,6,1,0,3,7}; 
		insert_sort(a,8);
		System.out.println(Arrays.toString(a));
	}

	private static void insert_sort(int[] a, int size) {
		// TODO Auto-generated method stub
		for(int i=0;i<size-1;i++) {
			for(int j=i+1;j>0;j--) {
				if(a[j]<a[j-1]) {
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}else {
					break;
				}
			}
		}
	}

}
