package 数组;
/*
 * 565. 数组嵌套
难度
中等

索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
 
示例 1:
输入: A = [5,4,0,3,1,6,2]
输出: 4
解释: 
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

其中一种最长的 S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 
提示：
N是[1, 20,000]之间的整数。
A中不含有重复的元素。
A中的元素大小在[0, N-1]之间。
 */
public class Solution565 {
    public int arrayNesting(int[] nums) { //1735ms
        int cnt = 1;
        int max = 0;
        for(int i=0;i<nums.length;i++){
            int start = nums[i];
            int temp = start;
            while(nums[temp]!=start){
                cnt++;
                temp = nums[temp];
            }
            max = Math.max(max,cnt);
            cnt=1;
        }
        return max;

    }
    //优化，剪枝
    public int arrayNesting2(int[] nums) {//2ms
        int cnt = 1;
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                continue;
            }
            int start = nums[i];
            nums[i]=-1;
            int temp = start;
            while(temp>=0&&nums[temp]!=-1){
                int cur = temp;
                cnt++;
                temp = nums[temp];
                nums[cur]=-1;
                
            }
            max = Math.max(max,cnt);
            cnt=1;
        }
        return max;

    }
}
