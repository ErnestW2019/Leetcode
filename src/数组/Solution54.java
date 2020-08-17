package 数组;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {
	/********解法一，记圈*************************/
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> list = new ArrayList<>();
        if(matrix.length==0) return list;
        int m = matrix.length;
        int n = matrix[0].length;
        int circle = (Math.min(m,n)+1)/2;
        int i = 0;
        while(i<circle){
            //从左到右
            for(int j=i;j<n-i;j++){
                list.add(matrix[i][j]);
            }
            //从上到下
            for(int j=i+1;j<m-i;j++){
                list.add(matrix[j][n-1-i]);
            }
            //从右到左
            for(int j=n-2-i;j>=i&&list.size()<m*n;j--){
                list.add(matrix[m-1-i][j]);
            }
            //从下到上
            for(int j=m-2-i;j>i&&list.size()<m*n;j--){
                list.add(matrix[j][i]);
            }
            i++;
        }
        return list;
    }
    /********解法二，记层*************************/
    public List<Integer> spiralOrder2(int[][] matrix) {
	    List<Integer> list = new ArrayList<>();
	    if(matrix.length==0) return list;
	    int m = matrix.length;
	    int n = matrix[0].length;
	    int up = 0,down = m-1,left = 0,right = n-1;
	    while(up<=down&&left<=right){
	        for(int j=left;j<=right;j++){
	            list.add(matrix[up][j]);
	        }
	        up++;
	        for(int j=up;j<=down;j++){
	            list.add(matrix[j][right]);
	        }
	        right--;
	        for(int j=right;j>=left&&up<=down;j--){
	            list.add(matrix[down][j]);
	        }
	        down--;
	        for(int j=down;j>=up&&left<=right;j--){
	            list.add(matrix[j][left]);
	        }
	        left++;
	    }
	    return list;
	}
}
