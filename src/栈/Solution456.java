package 栈;

import java.util.Stack;

/*
 * 456. 132模式
难度
中等

给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
注意：n 的值小于15000。
示例1:
输入: [1, 2, 3, 4]

输出: False

解释: 序列中不存在132模式的子序列。
示例 2:
输入: [3, 1, 4, 2]

输出: True

解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
示例 3:
输入: [-1, 3, 2, 0]

输出: True

解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
 */
public class Solution456 {
    /*算法思想：第一步构建左边最小的数字数组，作为子序列的第一个数字使用
    *从后往前遍历，遍历的当前数字作为子序列中间数字使用
    *通过一个栈，判断是否存在符合条件的第三个数字
    */
    public boolean find132pattern(int[] nums) {
        if(nums.length==0) return false;
        //构建左侧最小数
        int min = nums[0];
        int []leftmin = new int[nums.length]; 
        for(int i=0;i<nums.length;i++){
           min = Math.min(nums[i],min);
           leftmin[i] = min;

           
        }
        Stack<Integer> s = new Stack<Integer>();
        //从后往前遍历
        for(int i=nums.length-1;i>=0;i--){
            while(!s.isEmpty()&&s.peek()<=leftmin[i]){
                s.pop();
            }
            if(!s.isEmpty()&&nums[i]>s.peek()){
               return true;
            }
            s.push(nums[i]);
        }
        return false;
    }
}
