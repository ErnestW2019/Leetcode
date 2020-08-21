package 回溯;
/*
 * 79. 单词搜索
难度
中等

给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 
示例:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false
 
提示：
board 和 word 中只包含大写和小写英文字母。
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3
 */
public class Solution79 {
    public boolean exist(char[][] board, String word) {
        int m= board.length;
        int n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(dfs(board,word,i,j,0,visited)) return true;
            }
        }      
        return false;
    }
    public boolean dfs(char[][] board,String word,int i,int j,int start,boolean[][] visited){
        if(start==word.length()) return true;
        if(i<0||j<0||i>=board.length||j>=board[0].length||visited[i][j]||board[i][j]!=word.charAt(start)) return false;
        visited[i][j] = true;
        if(dfs(board,word,i-1,j,start+1,visited)||dfs(board,word,i+1,j,start+1,visited)||dfs(board,word,i,j-1,start+1,visited)||dfs(board,word,i,j+1,start+1,visited)){
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
