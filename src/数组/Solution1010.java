package 数组;
/*
 * 1010. 总持续时间可被 60 整除的歌曲
难度
简单


在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 
示例 1：
输入：[30,20,150,100,40]
输出：3
解释：这三对的总持续时间可被 60 整数：
(time[0] = 30, time[2] = 150): 总持续时间 180
(time[1] = 20, time[3] = 100): 总持续时间 120
(time[1] = 20, time[4] = 40): 总持续时间 60
示例 2：
输入：[60,60,60]
输出：3
解释：所有三对的总持续时间都是 120，可以被 60 整数。
 
提示：
1 <= time.length <= 60000
1 <= time[i] <= 500
 */
public class Solution1010 {
    public int numPairsDivisibleBy60(int[] time) {
    	//利用数组的特性，以对60取余的余数为索引，一出现的次数为值，构造数组
    	//则索引1和59这样的一对（其他如2和58，3和57等等），就是可以构成对60取余为0的歌曲对
        int[] record = new int[60];
        int count=0;
        for(int ti:time){
            record[ti%60]++;
        }
        if(record[0]!=0) count += record[0]*(record[0]-1)/2;
        for(int i=1,j=59;i<=30&&j>=30;i++,j--){
            if(i!=j) count += record[i]*record[j];
            if(i==j) count += record[i]*(record[i]-1)/2;
        }
        return count;
        
    }
}
