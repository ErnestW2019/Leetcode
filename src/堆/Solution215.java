package 堆;

import java.util.Arrays;

/*
 * 215. 数组中的第K个最大元素
难度
中等

在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
示例 1:
输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:
输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
说明: 
你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class Solution215 {
	/****************堆排序选择，提前break**************/
    public int findKthLargest(int[] nums, int k) {
        return heapSort(nums,nums.length,k);
        //return nums[nums.length-k];
    }
    private int heapSort(int[] nums,int n,int k){
        for(int i= n/2-1;i>=0;i--){
            adjustHeap(nums,i,n);
        }
        int times = 0;
        for(int j=n-1;j>0;j--){
            times++;
            if(times==k){
                return nums[0];
            }
            int tem = nums[j];
            nums[j] = nums[0];
            nums[0] = tem;           
            adjustHeap(nums,0,j);
        }
        return nums[0];
    }
    private void adjustHeap(int[] nums,int i,int n){
        int temp = nums[i];
        for(int k=2*i+1;k<n;k=2*k+1){
            if(k+1<n&&nums[k]<nums[k+1]){
                k++;
            }
            if(nums[k]>temp){
                nums[i] = nums[k];
                i = k;
            }else{
                break;
            }
        }
        nums[i] = temp;
    }
}
