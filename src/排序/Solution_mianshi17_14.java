package 排序;

import java.util.Arrays;


/*
 * 面试题 17.14. 最小K个数
难度
中等

设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
示例：
输入： arr = [1,3,5,7,2,4,6,8], k = 4
输出： [1,2,3,4]
提示：
0 <= len(arr) <= 100000
0 <= k <= min(100000, len(arr))
 */
public class Solution_mianshi17_14 {
    public int[] smallestK(int[] arr, int k) {
        quicksort(arr,0,arr.length-1,k);
        int[] res = Arrays.copyOfRange(arr,0,k);
        return res;
    }
    private void quicksort(int[] arr,int l,int r,int k){
        if(l>=r) return;
        int kk = partion(arr,l,r);
        if(kk+1==k) return;
        else if(kk+1>k) quicksort(arr,l,kk-1,k);
        else{
            quicksort(arr,kk+1,r,k);
        }
    }
    private int partion(int[] arr,int l,int r){
        int key = arr[l];
        while(l<r){
            while(l<r&&arr[r]>=key) r--;
            if(l<r) arr[l++] = arr[r];
            while(l<r&&arr[l]<key) l++;
            if(l<r) arr[r--] = arr[l];
        }
        arr[l] = key;
        return l;
    }
    public static void main(String[] args) {
    	int arr[] = new int[] {1,3,5,7,2,4,6,8};
    	int k=4;
    	Solution_mianshi17_14 solution_mianshi17_14 = new Solution_mianshi17_14();
    	System.out.println(Arrays.toString(solution_mianshi17_14.smallestK(arr, k)));
    	//solution_mianshi17_14.quicksort(arr,0,arr.length-1,4);
    	//System.out.println(Arrays.toString(arr));
    }
}
