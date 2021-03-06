package 数组;
/*
 * 289. 生命游戏
难度
中等
根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 
示例：
输入： 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
输出：
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]
 
进阶：
你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
 */
public class Solution289 {
    /*
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int res[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==0){//死细胞
                    //判断其周围八个位置是否正好有三个活细胞
                    if(check(board,i,j)==3){
                        res[i][j] = 1;
                    }
                }
                else{
                    if(check(board,i,j)==2||check(board,i,j)==3){
                        res[i][j] = 1;
                    }else if(check(board,i,j)<2||check(board,i,j)>3){
                        res[i][j] = 0;
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j] = res[i][j];
            }
        }
    }
    //计算i，j位置相邻的八个位置活细胞数目
    public int check(int[][]board,int i,int j){
        int sum = 0;
        if(i<board.length-1&&board[i+1][j]==1) sum++;
        if(i<board.length-1&&j>0&&board[i+1][j-1]==1) sum++;
        if(i<board.length-1&&j<board[0].length-1&&board[i+1][j+1]==1) sum++;
        if(j>0&&board[i][j-1]==1) sum++;
        if(j<board[0].length-1&&board[i][j+1]==1) sum++;
        if(i>0&&board[i-1][j]==1) sum++;
        if(i>0&&j>0&&board[i-1][j-1]==1) sum++;
        if(i>0&&j<board[0].length-1&&board[i-1][j+1]==1) sum++;
        return sum;
    }
    */
    public void gameOfLife(int[][] board) {
        //用-1表示状态从活到死，2表示原先为死现在为活，其余不变
        int m = board.length;
        int n = board[0].length;
        
        int[][] dic = {{1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,0},{-1,-1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int liveCell=0;
                //判断当前细胞的周围八个细胞状态
                for(int k=0;k<8;k++){
                    int row = i+dic[k][0];
                    int col = j+dic[k][1];
                    if(row>=0&&row<m&&col>=0&&col<n&&Math.abs(board[row][col])==1){
                        liveCell++;
                    }
                }
                if(board[i][j]==1){
                    //生存定律1和3
                    if(liveCell>3||liveCell<2) board[i][j] = -1;
                    //生存定律2
                    if(liveCell==3||liveCell==2) board[i][j] = 1;
                }
                if(board[i][j]==0){
                    //生存定律4
                    if(liveCell==3) board[i][j] = 2;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==-1){
                    board[i][j] = 0;
                }else  if(board[i][j]==2){
                    board[i][j] = 1;
                }
            }
        }
  
    }
}
