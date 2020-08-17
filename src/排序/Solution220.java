package 排序;

import java.util.TreeSet;

/*
 * 220. 存在重复元素 III
难度
中等
在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的绝对值也小于等于 ķ 。
如果存在则返回 true，不存在返回 false。
 
示例 1:
输入: nums = [1,2,3,1], k = 3, t = 0
输出: true
示例 2:
输入: nums = [1,0,1,1], k = 1, t = 2
输出: true
示例 3:
输入: nums = [1,5,9,1,5,9], k = 2, t = 3
输出: false
 */
public class Solution220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //自平衡二叉查找树
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i=0;i<nums.length;i++){
            //查找大于等于nums[i]的最近的数
            Integer s = set.ceiling(nums[i]);
            if(s!=null&&s<=nums[i]+t) return true;
            //查找小于等于nums[i]的最近的数
            Integer g = set.floor(nums[i]);
            if(g!=null&&nums[i]<=t+g) return true;

            set.add(nums[i]);
            //维护一个k大小的窗口，始终在窗口里面查找
            if(set.size()>k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
