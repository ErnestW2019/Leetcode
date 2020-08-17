package 数组;

import java.util.Arrays;

public class Solution1300 {
	/*************枚举+二分搜索****************/  //12ms
    /*public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int len = arr.length;
        //预处理前缀和
        int pre[] = new int [arr.length];
        pre[0] = 0;
        for(int i=1;i<pre.length;i++){   
            pre[i] = pre[i-1]+arr[i-1];
        }
        int diff = target;
        int ans = 0;
        boolean flag = false;
        for(int i=target/len;i<=arr[len-1];i++){
            int index = Arrays.binarySearch(arr,i);
            if(index<0){
                index = -index-1;
            }
            int sum = pre[index]+i*(len-index);
            if(Math.abs(target-sum)<diff){
                flag = true;
                ans = i;
                diff = Math.abs(target-sum);
            }else{
                flag = false;   
            }
            if(flag==false){   //因为是在找到最小值前都是单调递减的函数，所以碰到第一个最小值后，如果下一次遇见的不是最小值就跳出循环，输出前一值，减少遍历量
                break;
            }
        }
        return ans;
    }*/
    /*************非排序二分搜索************/  //3ms
    public int findBestValue(int[] arr, int target) {
        
        int l = target/arr.length;
        int maxr = 0;
        //找最大值，作为数轴的右边界
        for(int i=0;i<arr.length;i++){
            maxr = Math.max(maxr,arr[i]);
        }
        int r = maxr;
        while(l<=r){
            int mid = l+(r-l)/2;
            int res = sum(arr,mid);
            if(res == target){
                return mid;
            }else if(res<target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return Math.abs(sum(arr,l)-target)>=Math.abs(sum(arr,r)-target)?r:l;

    }
    private int sum(int[] arr,int max){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum += Math.min(arr[i],max);
        }
        return sum;
    }
}
