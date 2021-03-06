package 排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.IntFunction;


/*
 * 1356. 根据数字二进制下 1 的数目排序
难度
简单
给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
请你返回排序后的数组。
 
示例 1：
输入：arr = [0,1,2,3,4,5,6,7,8]
输出：[0,1,2,4,8,3,5,6,7]
解释：[0] 是唯一一个有 0 个 1 的数。
[1,2,4,8] 都有 1 个 1 。
[3,5,6] 有 2 个 1 。
[7] 有 3 个 1 。
按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
示例 2：
输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
输出：[1,2,4,8,16,32,64,128,256,512,1024]
解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
示例 3：
输入：arr = [10000,10000]
输出：[10000,10000]
示例 4：
输入：arr = [2,3,5,7,11,13,17,19]
输出：[2,3,5,17,7,11,13,19]
示例 5：
输入：arr = [10,100,1000,10000]
输出：[10,100,10000,1000]
 
提示：
1 <= arr.length <= 500
0 <= arr[i] <= 10^4
 */
public class Solution1356 {
    /*public static int[] sortByBits(int[] arr) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	for(int num:arr) {
    		list.add(num);
    	}
        for(int i=0;i<arr.length;i++){
            //int geshu = calcu1(arr[i]);
            //map.put();
            Collections.sort(list,new Comparator<>(){
                @Override
                public int compare(Integer o1,Integer o2){
                    int c1 = calcu1(o1);
                    int c2 = calcu1(o2);
                    return c1==c2? o1-o2:c1-c2;
                }
            });
        }
        int res[] = new int[arr.length];
        int index = 0;
        for(Integer num:list) {
        	res[index++] = num;
        }
        return res;
    }*/
	public static int[] sortByBits(int[] arr) {
	    Integer []res = new Integer[arr.length];
	    for(int i=0;i<arr.length;i++){
	        res[i] = arr[i];
	    }
	    Arrays.sort(res,new Comparator<Integer>(){
	        @Override
	        public int compare(Integer o1,Integer o2){
	            int c1 = calcu1(o1);
	            int c2 = calcu1(o2);
	             return c1==c2? o1-o2:c1-c2;
	        }
	    });
	    for(int i=0;i<arr.length;i++){
	        arr[i] = res[i];
	    }
	    return arr;
	    
	
	}
    public static int calcu1(int num){
        int count = 0;
        //int num = arr[i];
        while(num!=0){
            num = num&(num-1);
            count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
    	int arr[] = new int [] {1024,512,256,128,64,32,16,8,4,2,1};
    	System.out.println(Arrays.toString(sortByBits(arr)));
    }
}
