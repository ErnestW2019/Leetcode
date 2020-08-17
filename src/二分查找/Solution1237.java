package 二分查找;

import java.util.ArrayList;
import java.util.List;

public class Solution1237 {
	static class CustomFunction {
	    // Returns f(x, y) for any given positive integers x and y.
		// Note that f(x, y) is increasing with respect to both x and y.
	    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
	    public int f(int x, int y) {
	    	//return x+y;
	    	return x*y;
	    }
	}
    public static List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        /* //双重for循环遍历
        for(int x=1;x<=1000;x++){
            for(int y=1;y<=1000;y++){
                if(customfunction.f(x,y)==z){
                    list = new ArrayList();
                    list.add(x);
                    list.add(y);  
                    res.add(list);
                    break; 
                }
            }
        }
        return res;
        */
       //二分查找
        for(int x=1;x<=1000;x++){
            int left = 1,right = 1000;
            while(left<=right){
                int y = left+(right-left)/2;
                if(customfunction.f(x,y)==z){
                    list = new ArrayList();
                    list.add(x);
                    list.add(y);  
                    res.add(list);
                    break; 
                }else if(customfunction.f(x,y)>z){
                    right = y-1;
                }else{
                    left = y+1;
                }
            }
        }
        return res;
    }
    //双指针法
    public static List<List<Integer>> findSolution3(CustomFunction customfunction, int z) {
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
	    int left = 1,right = 1000;
	    while(left<=1000&&right>=1){
	        if(customfunction.f(left,right)==z){
	                list = new ArrayList();
	                list.add(left);
	                list.add(right);  
	                res.add(list);
	                left++;
	        }else if(customfunction.f(left,right)>z){
	                right--;
	        }else{
	                left++;
	        }
	    }
	    return res;
    }
    public static void main(String[] args) {
    	int z = 5;
    	CustomFunction customfunction = new CustomFunction();
    	System.out.println(findSolution(customfunction, z));
    }
}
