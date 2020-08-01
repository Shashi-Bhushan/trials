import java.io.*;
import java.util.*;

class Solution {
  private static Set<Character>[] rows;
  private static Set<Character>[] cols;
  private static Set<Character>[] blocks;

  static boolean sudokuSolve(char[][] board) {
    rows = new HashSet[9];
    cols = new HashSet[9];
    blocks = new HashSet[9];
    
    for (int i = 0 ; i < board.length; i++) {
      rows[i] = new HashSet<Character>();
      
      for (int j = 0; j < board[i].length; j++) {
        if (i == 0) {
          cols[j] = new HashSet<Character>();
        }
        
        int blockNumber = (i / 3) * 3 + (j / 3);
        
        if (blocks[blockNumber] == null) {
          blocks[blockNumber] = new HashSet<Character>();
        }
        
        if (board[i][j] != '.') {
          rows[i].add(board[i][j]);
          cols[j].add(board[i][j]);
          blocks[blockNumber].add(board[i][j]);
        }
      }
    }
    
    return helper(board, 0);
  }
  
  private static boolean helper(char[][] board, int index) {
    if (index == 81) return true;
    else {
      int i = index / 9;
      int j = index % 9;
      int blockNumber = (i / 3) * 3 + (j / 3);
      
      // notEmpty
      if (board[i][j] != '.') {
        // can't place any number here
        return helper(board, index + 1);
      } else {
        // try placing a number by backtracking now
        
        for (char x = '1'; x <= '9'; x++) {
          if (!rows[i].contains(x) && !cols[j].contains(x) && !blocks[blockNumber].contains(x)) {
            rows[i].add(x);
            cols[j].add(x);
            blocks[blockNumber].add(x);
            
            board[i][j] = x;
            
            if (helper(board, index + 1)) {
              return true;
            }
            
            board[i][j] = '.';
            blocks[blockNumber].remove(x);
            cols[j].remove(x);
            rows[i].remove(x);
          }
        }
        
        return false;
      }
    }
  }

  public static void main(String[] args) {
    char[][] board = new char[9][9];
    
    Scanner input = new Scanner(System.in);
    
    //for (int i)
  }

}
