package 排序;
/*922. 按奇偶排序数组 II
难度
简单
给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
你可以返回任何满足上述条件的数组作为答案。
 
示例：
输入：[4,2,5,7]
输出：[4,5,2,7]
解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 
提示：
2 <= A.length <= 20000
A.length % 2 == 0
0 <= A[i] <= 1000
 * 
 */
import java.util.Arrays;

public class Solution922 {
	/**********开辟额外数组空间*****************/
    /*public static int[] sortArrayByParityII(int[] A) {
        int res[] = new int[A.length];
        int i=0,j=1; 
        for(int num:A){
            if(num%2==0){
                res[i] = num;
                i+=2;
            }else{
                res[j] = num;
                j+=2;
            }
        }
        return res;

    }*/
	/***********双指针****************/
	public static int[] sortArrayByParityII(int[] A) {
		int i=0,j=1; //用两个指针，i指向奇数，j指向偶数
        for(; i<A.length&&j<A.length;i+=2){   //原地变换
            if(A[i]%2==1){
                while(A[j]%2==1){
                    j+=2;
                }
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        return A;
	}

	public static void main(String[] args) {
		int A[] = new int [] {1,3,5,7,9,2,4,6,8,10};
		System.out.println(Arrays.toString(sortArrayByParityII(A)));
		
	}
}
