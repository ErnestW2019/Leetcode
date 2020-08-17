package 数组;

import java.util.Arrays;

public class Solution1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        /*
        int cnt = 0;
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2.length;j++){
                if(Math.abs(arr1[i]-arr2[j])<=d){
                    break;
                }
                if(j==arr2.length-1){
                    cnt++;
                }
            }
        }
        return cnt;
        */
        Arrays.sort(arr2);
        int cnt = 0;
        for(int i=0;i<arr1.length;i++){
            int l=0,r = arr2.length-1;
            while(l<=r){
                int mid = l+(r-l)/2;
                if(arr1[i]-arr2[mid]<0&&Math.abs(arr1[i]-arr2[mid])>d){
                    r = mid-1;
                }else if(arr1[i]-arr2[mid]>0&&Math.abs(arr1[i]-arr2[mid])>d){
                    l = mid+1;
                }else{
                    cnt++;
                    break;
                }
            }
        }
        return arr1.length-cnt;
    }
}
