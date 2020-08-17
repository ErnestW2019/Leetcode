package 哈希表;

import java.util.Arrays;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Deque;

public class Solution739 {
	/******************暴力法********************/ //1249ms，47.9MB
    /*public static int[] dailyTemperatures(int[] T) {
        //List<Integer> list = new ArrayList<Integer>();
        int res[] = new int [T.length];
        int index = 0;
        for(int i=0;i<T.length;i++){
            for(int j=i;j<T.length;j++){
                if(T[j]>T[i]) {
                    //list.add(j-i);
                    res[index] = j-i;
                    index += 1;
                    break;
                }
                else if(j==T.length-1){
                    res[index] = 0;
                    index += 1;
                }
            }
        }
        return res;
    }*/
	/*******利用map和栈********************/
    /*public static int[] dailyTemperatures2(int[] T) { //24ms,47.9MB
        Stack<int[]> s = new Stack<int[]>();
        int [] res = new int[T.length];
        //HashMap<Integer,Integer> map = new Hashap<Integer,Integer>();
        int map[][] = new int[T.length][2];
        for(int i=0;i<T.length;i++){
            map[i][0] = T[i];
            map[i][1] = i;
        }
        s.push(map[0]);
        //int cnt = 0;
        for(int i=1;i<T.length;){
        	//s.push(map[i]);
        	while(!s.isEmpty()) {
                int[]temp = s.peek();
                if(T[i]>temp[0]) {
                	s.pop();
                	res[temp[1]] = i-temp[1];
                }else {
                	s.push(map[i]);
                	i++;
                }
                if(i==T.length) break;
                
        	}
        	if(i==T.length) break;
        	s.push(map[i]);
        	i++;
        }
        return res;
    
    }*/
    /*****************优化法二，可舍去map来存储值和索引改为栈直接存储索引***********/
    public static int[] dailyTemperatures3(int[] T) {
        int length = T.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
    /******************倒序遍历法******************/
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        //从后面开始查找
        for (int i = res.length - 1; i >= 0; i--) {
            int j = i + 1;
            while (j < res.length) {
                if (T[j] > T[i]) {
                    //如果找到就停止while循环
                    res[i] = j - i;
                    break;
                } else if (res[j] == 0) {
                    //如果没找到，并且res[j]==0。说明第j个元素后面没有
                    //比第j个元素大的值，因为这一步是第i个元素大于第j个元素的值，
                    //那么很明显这后面就更没有大于第i个元素的值。直接终止while循环。
                    break;
                } else {
                    //如果没找到，并且res[j]！=0说明第j个元素后面有比第j个元素大的值，
                    //然后我们让j往后挪res[j]个单位，找到那个值，再和第i个元素比较
                    j += res[j];
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
    	int []T= new int[] {73,74,75,71,69,72,76,73};
    	System.out.println(Arrays.toString(dailyTemperatures3(T)));
    }
}
