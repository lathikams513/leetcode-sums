import java.util.*;

class Solution {

    int count = 0;

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }

        place(board, 0);
        return count;
    }

    public void place(char[][] board, int row){

        if(row == board.length){
            count++;
            return;
        }

        for(int col = 0; col < board.length; col++){

            if(isSafe(board, row, col)){

                board[row][col] = 'Q';

                place(board, row + 1);

                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(char[][] board, int row, int col){

        for(int i = 0; i < row; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == 'Q'){
                    if(Math.abs(row - i) == Math.abs(col - j)){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}