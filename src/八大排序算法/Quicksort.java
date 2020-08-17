
package 八大排序算法;
/*
 * 先从数列中取出一个数作为key值；
将比这个数小的数全部放在它的左边，大于或等于它的数全部放在它的右边；
对左右两个小数列重复第二步，直至各区间只有1个数。
通过一趟排序将序列分成左右两部分，其中左半部分的的值均比右半部分的值小，
然后再分别对左右部分的记录进行排序，直到整个序列有序。
 */
import java.util.Arrays;


public class Quicksort {
	public static void main(String[] args) {
		int[] a = new int[] {4,2,5,6,1,0,3,7}; 
		quick_sort(a,0,7);
		System.out.println(Arrays.toString(a));
	}
	/*
	private static void quick_sort(int[] a, int l,int r) {
		// TODO Auto-generated method stub
		if(l>=r) return;
		int key = a[l];
		int i=l,j=r;
		while(i<j) {
			while(i<j&&a[j]>=key) {  //从右向左找第一个小于key的数
				j--;
			}
			if(i<j) {
				a[i]=a[j];
				i++;
			}
			while(i<j&&a[i]<key) {  //从左向右找第一个大于key的数
				i++;
			}
			if(i<j) {
				a[j]=a[i];
				j--;
			}
		}
		a[i] = key;
		quick_sort(a,l,i-1);
		quick_sort(a,i+1,r);
	}*/
	public static int partion(int []a,int l,int r) {
		int key = a[l];
		while(l<r) {
			while(l<r&&a[r]>=key) r--;
			if(l<r) a[l++] = a[r];
			while(l<r&&a[l]<key) l++;
			if(l<r) a[r--] = a[l];
		}
		a[l] = key;
		return l;
	}
	public static void quick_sort(int[] a, int l,int r) {
		if(l>=r) return;
		int k = partion(a,l,r);
		quick_sort(a, l, k-1);
		quick_sort(a, k+1, r);
		
	}
}
