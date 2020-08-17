package 八大排序算法;

import java.util.Arrays;

public class MergeSort {
	public static void merge(int[] a,int first,int mid, int last) {
		int[] temp = new int[a.length];
		int i=first,j = mid+1;
		int index = first;
		while(i<=mid&&j<=last) {
			if(a[i]<=a[j]) {
				temp[index++] = a[i++]; 
			}else {
				temp[index++] = a[j++];
			}
		}
		while(i<=mid) {
			temp[index++] = a[i++]; 
		}
		while(j<=last) {
			temp[index++] = a[j++];
		}
		for(int k=first;k<=last;k++) {
			a[k] = temp[k];
		}
	}
	public static void merge_sort(int[] a,int first,int last) {
		if(first>=last) return;
		int mid = (first+last)/2;
		merge_sort(a,first, mid);
		merge_sort(a,mid+1, last);
		merge(a,first, mid, last);
	}
	public static void main(String[] args) {
		int[] a = new int[] {36,20,17,13,28,36,23,15};
		merge_sort(a,0,a.length-1);
		System.out.println(Arrays.toString(a));
	}
}
