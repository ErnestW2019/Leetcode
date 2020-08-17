package 数组;

import java.util.ArrayList;
import java.util.List;

/*
 * 118. 杨辉三角
难度
简单

给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。

在杨辉三角中，每个数是它左上方和右上方的数的和。
示例:
输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(numRows==0) return res;
        list.add(1);
        res.add(list);
        int n=2;
        int num=1;
        while(n<=numRows){
            list = new ArrayList<Integer>();
            list.add(1);
            for(int i=1;i<n;i++){ 
                if(i==n-1){
                    list.add(1);
                    res.add(list);
                } 
                else list.add(res.get(n-2).get(i-1)+res.get(n-2).get(i));
                
            }
            n++;
        }
        return res;
    }
}
