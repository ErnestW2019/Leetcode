package 数组;

import java.util.HashMap;

/*
 * 1128. 等价多米诺骨牌对的数量
难度
简单

给你一个由一些多米诺骨牌组成的列表 dominoes。
如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 
示例：
输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
输出：1
 
提示：
1 <= dominoes.length <= 40000
1 <= dominoes[i][j] <= 9
 */
public class Solution1128 {
    public int numEquivDominoPairs(int[][] dominoes) {  //3ms
    	//也可以用数组作为map,因为数组中每一个值都小于9，所以能构成的最大数为99，
    	//所以map数组最大为100就够了。
    	int map[] = new int[100];
    	int count = 0 ;
    	for(int [] dominoe:dominoes) {
    		int temp = dominoe[0]>dominoe[1]?dominoe[0]*10+dominoe[1]:dominoe[1]*10+dominoe[0];
    		count += map[temp];
    		map[temp]++;
    		
    	}
    	return count;
    	
    }
    	/******************HashMap法*******************/ //17ms
    public int numEquivDominoPairs2(int[][] dominoes) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int count = 0;
        for(int[] dominoe:dominoes){
            int temp = dominoe[0]>dominoe[1]?dominoe[0]*10+dominoe[1]:dominoe[1]*10+dominoe[0];
            //map.put(temp,map.getOrDefault(temp,0)+1);
            if(map.containsKey(temp)){
                
                count += map.get(temp);
                map.put(temp,map.get(temp)+1);
            }else{
                map.put(temp,1);
            }
        }
        return count;
    }
}
