package 数组;

public class Solution1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum1 = 0;
        int sum = 0;
        for(int i=0;i<distance.length;i++){
            sum += distance[i];
        }
        if(start<destination){
            for(int i=start;i<destination;i++){
                sum1 += distance[i];
            }
        }else{
            for(int i=destination;i<start;i++){
                sum1 += distance[i];
            }
        }

        return Math.min(sum1,sum-sum1);
    }
}
