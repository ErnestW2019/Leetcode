package 数组;

public class Solution999 {
    public static int numRookCaptures(char[][] board) {
        int x=0,y=0;
        int count=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='R') {
                    x = i;
                    y = j;
                }
            }
        }
        for(int i=x;i<board.length;i++){
            if(board[i][y]=='B') break;
            else if(board[i][y]=='p') {
                count++;
                break;
            }
        }
         for(int i=x;i>=0;i--){
            if(board[i][y]=='B') break;
            else if(board[i][y]=='p') {
                count++;
                break;
            }
        }
        for(int j=y;j<board[0].length;j++){
            if(board[x][j]=='B') break;
            else if(board[x][j]=='p') {
                count++;
                break;
            }
        }
        for(int j=y;j>=0;j--){
            if(board[x][j]=='B') break;
            else if(board[x][j]=='p'){
                count++;
                break;
            } 
        }
        return count;
    }
    public static void main(String[] args) {
    	char A[][] = new char[][] {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','R','.','.','.','p'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};

    	int K=1;
    	System.out.println(numRookCaptures(A));
    }
}
