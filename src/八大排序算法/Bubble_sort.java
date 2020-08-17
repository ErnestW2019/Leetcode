package 八大排序算法;
/*
 * 比较相邻的两个数据，如果第二个数小，就交换位置。
 从前向后两两比较，一直到比较最后两个数据。最终最大数被交换到末尾位置，这样最大数的位置就排好了。
继续重复上述过程，依次将第2.3...n-1个最小数排好位置。
 */
import java.util.Arrays;

/**************冒泡排序*******************/  //O(n2)
public class Bubble_sort {
	public static void bubble_sort(int[] a,int size) {
		for(int i=0;i<size-1;i++) {
			for(int j=0;j<size-i-1;j++) {
				if(a[j]>a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		int[] a = new int[] {4,2,5,6,1,0,3,7}; 
		bubble_sort(a,8);
		System.out.println(Arrays.toString(a));
	}
}
