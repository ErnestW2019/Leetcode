package 数组;

public class Solution441 {
    //迭代求解
    public int arrangeCoins(int n) {  //14ms
        long sum=0;
        int cnt=0;
        for(int i=1;i<=n;i++){
            cnt++;
            sum += i;
            if(sum>n){
                cnt--;
                break;
            }
        }
        return cnt;
    }
    //二分查找
    public static int arrangeCoins2(int n) {
        long start = 0, end = (long) n / 2 + 1, mid;
        while (end - start > 1) {
            mid = (start + end) >>> 1;
            if (mid * (mid + 1) == (long) 2 * n) {
                return (int) mid;
            } else if (mid * (mid + 1) <= (long) 2 * n) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return (end * (end + 1) == (long) 2 * n) ? (int) end : (int) start;
    }
}
