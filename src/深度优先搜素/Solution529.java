package 深度优先搜素;
/*
 * 529. 扫雷游戏
难度
中等

让我们一起来玩扫雷游戏！
给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
如果在此次点击中，若无更多方块可被揭露，则返回面板。
 
示例 1：
输入: 

[['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'M', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E']]

Click : [3,0]

输出: 

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

 */
public class Solution529 {
    int xshift[] = new int[]{-1,-1,-1,0,0,1,1,1};
    int yshift[] = new int[]{-1,0,1,-1,1,-1,0,1};
    public char[][] updateBoard(char[][] board, int[] click) {
        int i=click[0];
        int j=click[1];
        if(board[i][j]=='M') {
            board[i][j] = 'X';
            return board;
        }
        dfs(board,i,j);
        return board;
    }
    public void dfs(char[][] board, int i,int j){
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!='E') return;
        //计算相邻的八个方向的地雷数目
        int neighborSum = 0;
        for(int l=0;l<8;l++){
            int x = i+xshift[l];
            int y = j+yshift[l];
            if(x>=0&&y>=0&&x<board.length&&y<board[0].length&&board[x][y]=='M') neighborSum++;
        }
        //条件2，没有相邻地雷的方块'E'被挖出，修改为'B'
        if(neighborSum==0){
            board[i][j] = 'B';
            for(int k=0;k<8;k++){
                dfs(board,i+xshift[k],j+yshift[k]);
            }         
        }
        //条件3，相邻位置有地雷的'E'方块被挖出，则将它修改为地雷数
        else if(neighborSum!=0){
            board[i][j] = (char)(neighborSum+48);
        }
        //return;
    }
}
