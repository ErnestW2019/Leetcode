package 数组;

import java.util.ArrayList;
import java.util.List;

/*
 * 119. 杨辉三角 II
难度
简单

给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。

在杨辉三角中，每个数是它左上方和右上方的数的和。
示例:
输入: 3
输出: [1,3,3,1]
 */
public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        
        List<Integer> list = new ArrayList<Integer>();
        if (rowIndex==0){
            list.add(1);
            return list;
        }
        int row=1;
        List<Integer> prelist = new ArrayList<Integer>();
        while(row<=rowIndex){
           
            list = new ArrayList<Integer>();
            for(int i=0;i<=row;i++){
                if(i==0) list.add(1);
                else if(i>0&&i<row) list.add(prelist.get(i)+prelist.get(i-1));
                else if(i==row) list.add(1);
            }
            row++;
            prelist = list;

        }
        return list;

    }
}
