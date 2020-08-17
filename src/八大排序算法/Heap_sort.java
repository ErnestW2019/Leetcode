package 八大排序算法;

import java.util.Arrays;


public class Heap_sort {
	public static void main(String[] args) {
		int[] a = new int[] {4,2,5,6,1,0,3,7}; 
		heap_sort(a,8);
		System.out.println(Arrays.toString(a));
	}
/*******大顶堆******************/  //O(nlogn)
	private static void heap_sort(int[] a, int n) {
		// TODO Auto-generated method stub
		//建堆,从第一个非叶子节点从上至下调整，从优至左调整结构
		for(int i=n/2-1;i>=0;i--) {
			adjustHeap(a,i,n);
		}
		//每次找到堆顶最大元素后，沉到最尾端，调整堆结构
		for(int j=n-1;j>0;j--) {
			//swap(a,0,j);
			int temp2 = a[0];
			a[0]=a[j];
			a[j] = temp2;
			adjustHeap(a, 0, j);  //重新对剩下的元素进行调整
		}
	}

	//调整堆
	private static void adjustHeap(int[] a,int i,int n) {
		int temp = a[i]; //去除当前元素
		for(int k=2*i+1;k<n;k=2*k+1) { //从i节点开始，判断其子节点即2i+1是否大于父节点
			if(k+1<n&&a[k]<a[k+1]) {
				k++;
			}
			if(a[k]>temp) {
				a[i] = a[k];
				i = k;
			}else {
				break;
			}
		}
		a[i] = temp;
	}
}
