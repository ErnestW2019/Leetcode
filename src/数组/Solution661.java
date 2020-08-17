package 数组;
/*
 * 661. 图片平滑器
难度
简单

包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
示例 1:
输入:
[[1,1,1],
 [1,0,1],
 [1,1,1]]
输出:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
解释:
对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
注意:
给定矩阵中的整数范围为 [0, 255]。
矩阵的长和宽的范围均为 [1, 150]。
 */
public class Solution661 {
    public int[][] imageSmoother(int[][] M) {
        int sum = 0;
        int res[][] = new int[M.length][M[0].length];
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M[0].length;j++){
                sum = M[i][j];
                int num = 1;
                if(i>0&&j>0){
                    sum += M[i-1][j-1];
                    num++;
                }
                if(i>0&&j<M[0].length-1){
                    sum += M[i-1][j+1];
                    num++;
                }
                if(j<M[0].length-1){
                    sum += M[i][j+1];
                    num++;
                }
                if(i<M.length-1){
                    sum += M[i+1][j];
                    num++;
                }
                if(i>0){
                    sum += M[i-1][j];
                    num++;
                }
                if(j>0){
                    sum += M[i][j-1];
                    num++;
                }
                if(i<M.length-1&&j>0){
                    sum += M[i+1][j-1];
                    num++;
                }
                if(i<M.length-1&&j<M[0].length-1){
                    sum += M[i+1][j+1];
                    num++;
                }
                res[i][j] = sum/num;
            }
        }
        return res;
        
    }
}
