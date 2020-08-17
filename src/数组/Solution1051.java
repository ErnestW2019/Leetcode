package 数组;

import java.util.Arrays;

public class Solution1051 {
	/***********方法一，快排，比较*******************/
    public int heightChecker1(int[] heights) {
        int count = 0;
        int []clo = heights.clone();
        Arrays.sort(clo);
        for(int i=0;i<heights.length;i++){
            if(clo[i]!=heights[i]) {
                count++;
            }
        }
        return count;
    }
    /************方法二，桶排序****************/
    //以数组下标作为自然计数
    public int heightChecker2(int[] heights) {
        int[] arr = new int[101];
        for (int height : heights) {
            arr[height]++;
        }
        int count = 0;
        for (int i = 1, j = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                if (heights[j++] != i) count++;
            }
        }
        return count;
    }

}
