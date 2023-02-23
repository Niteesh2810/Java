import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
            System.out.println("\nLet's play tic tac toe");

            //Creating an array with three rows of '_' characters.
            char[][] board=new char[3][3];
            for (int i=0;i<3;i++){
              for (int j=0;j<3;j++){
                board[i][j]='_';
              }
            }
            //Calling the function printBoard();
            printBoard(board);
            int[] spot=new int[2];
            for (int i=0;i<9;i++){
              if (i%2==0){
                System.out.println("\nTurn: X");
                spot=askUser(board);
                board[spot[0]][spot[1]]='X';
                printBoard(board);
              }
              else{
                System.out.println("\nTurn: O");
                spot=askUser(board);
                board[spot[0]][spot[1]]='O';
                printBoard(board);
              }

              int count=checkWin(board);
              if (count==3){
                System.out.println("\nX Wins!");
                break;
              }
              else if (count==-3){
                System.out.println("\nO Wins!");
                break;
              }
              else{
                int check=0;
                for (int j=0;j<3;j++){
                 for (int k=0;k<3;k++){
                   if ('_'!=board[j][k]){
                     check+=1;
                   }
                 }
                }
               if (check==9){
                 System.out.println("\nIt's a tie!");
               }
              }
            }
            
              /*
              { Loop through turns.

                  if (X) turn {
                     call askUser(). 
                     populate the board using askUser's return value.
                  } else {
                      call askUser(). 
                      populate the board using askUser's return value. Then, print it.

                  }
                
                

                Call the function.
                   if return value == 3 {
                     print: X wins and break the loop
                  } else if return value == -3 {
                     print: O wins and break the loop
                  }

              } 
              */

            scan.close();
        }


    /** A function that prints the board.
     * Function name - printBoard()
     * @param board (char[][])
     * 
     * Inside the function:
     *   1. print a new line.
     *   2. print the board.
     *      • separate each row by two lines. 
     *      • each row precedes a tab of space
     *      • each character in the grid has one space from the other character
     */        
    
     public static void printBoard(char[][] board){
        System.out.println("\n");
        for(int i=0;i<3;i++){
          System.out.print("\t");
          for(int j=0;j<3;j++){
            System.out.print(board[i][j]+" ");
          }
          System.out.print("\n");
        }


    }
   /** A function that lets the user choose a spot
     * Function name – askUser
     * @param board (char[][] board)
     * @return spot (int[])
     * 
     * Inside the function
     *   1. Asks the user: - pick a row and column number: 
     *   2. Check if the spot is taken. If so, let the user choose again.
     *   3. Return the row and column in an int[] array.
     * 
     */
    public static int[] askUser(char[][] board){
      System.out.print("- pick a row and column number:");
      int[] spot=new int[2];
      spot[0]=scan.nextInt();
      spot[1]=scan.nextInt();
      while (true){
        if (board[spot[0]][spot[1]]=='X' || board[spot[0]][spot[1]]=='O' ||spot[0]>2 || spot[0]<0 || spot[1]>2 || spot[1]<0){
          System.out.print("Spot take, try again:");
          spot[0]=scan.nextInt();
          spot[1]=scan.nextInt();
        }
        else{
          break;
        }
      }
      return spot;
    }

    /** A function that determines the winner
     * Function name - checkWin 
     * @param board (char[][])
     * @return count (int)
     * 
     * Inside the function:
     *   1. Make a count variable that starts at 0.
     *   2. Check every row for a straight X or straight O (Task 7).
     *   3. Check every column for a straight X or straight O (Task 8).
     *   4. Check the left diagonal for a straight X or straight O (Task 9).
     *   5. Check the right diagonal for a straight X or straight O (Task 10).
     */

     public static int checkWin(char[][] board){
      int count=0;
      for (int i=0;i<3;i++){
        count=0;
        for(int j=0;j<3;j++){
          if (board[i][j]=='X'){
            count+=1;
          }
          else if(board[i][j]=='O'){
            count-=1;
          }
        }
        if (count==3 || count==-3){
          return count;
        }        
      }

      for (int i=0;i<3;i++){
        count=0;
        for(int j=0;j<3;j++){
          if (board[j][i]=='X'){
            count+=1;
          }
          else if(board[j][i]=='O'){
            count-=1;
          }
        }
        if (count==3 || count==-3){
          return count;
        }  
      }
      count=0;
      for (int i=2;i>=0;i--){
        
        if (board[i][2-i]=='X'){
          count+=1;
        }
        else if(board[i][2-i]=='O'){
          count-=1;
        }
      } 
      if (count==3 || count==-3){
        return count;
      }        
      
      count=0;
      for (int i=0;i<3;i++){
        if (board[i][i]=='X'){
          count+=1;
        }
        else if(board[i][i]=='O'){
          count-=1;
        }
      }
      if (count==3 || count==-3){
        return count;
      }  
      
      
      return 0;
    }
}
