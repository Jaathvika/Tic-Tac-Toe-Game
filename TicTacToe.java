import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        // Welcome message and player name input
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.print("Enter name for Player 1 (X): ");
        String player1 = sc.nextLine();
        System.out.print("Enter name for Player 2 (O): ");
        String player2 = sc.nextLine();

        System.out.println("\nGame started between " + player1 + " and " + player2);
        System.out.println("\nHow to play:");
        System.out.println("Enter your move as two numbers: row and column (0 to 2)");
        System.out.println("Example: 1 2 means row 1, column 2\n");

        // Make an empty 3x3 board
        char[][] board=new char[3][3];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(board[i], ' ');
        }

        // Player 1 always starts with 'X'
        char current='X';

        // Keep playing until someone wins or the board is full
        while(true)
         {
            printBoard(board);
            System.out.println((current=='X'?player1:player2)+"'s turn:");
            int row, col;
            // Get valid move input
            while(true) 
            {
                System.out.print("Enter row and column: ");
                row=sc.nextInt();
                col=sc.nextInt();

                // Check valid position
                if(row>=0 && row<3 && col>=0 && col<3) 
                {
                    if(board[row][col]==' ') 
                    {
                        break;
                    } 
                    else 
                    {
                        System.out.println("That spot is already taken.Try again!");
                    }
                }
                 else 
                 {
                    System.out.println("Invalid position! Enter numbers between 0 and 2.");
                }
            }

            // Place move on the board
            board[row][col]=current;

            // Check for win
            if(checkWinner(board,current)) 
            {
                printBoard(board);
                String winner=(current=='X'?player1:player2);
                System.out.println("Congratulations " + winner + "! You win! ");
                break;
            }

            // Check for draw
            if (draw(board)) 
            {
                printBoard(board);
                System.out.println("It's a draw!");
                break;
            }

            // Switch player turn
            current=(current=='X')?'O':'X';
        }

        // Ask to play again
        System.out.print("Do you want to play again? (yes/no): ");
        String again=sc.next();
        if (again.equalsIgnoreCase("yes")) 
        {
            main(null);
        } else {
            System.out.println("Thanks for playing!");
        }

    }

    // Shows the game board
    static void printBoard(char[][] board)
     {
        System.out.println("\nCurrent Board:");
        System.out.println("   0   1   2");
        for (int i=0;i<3;i++)
         {
            System.out.print(i+ " ");
            for(int j=0;j<3;j++)
             {
                System.out.print("| "+board[i][j] +" ");
            }
            System.out.println("|");
            if(i<2)
                System.out.println("  ---+---+---");
        }
        System.out.println();
    }

    // Checks if the current player has won
    static boolean checkWinner(char[][] board, char player) {
        // Check all rows and columns
        for(int i=0;i<3;i++)
         {
            if ((board[i][0]==player && board[i][1]==player && board[i][2]==player) ||
                (board[0][i]==player && board[1][i]==player && board[2][i]==player))
                return true;
        }

        // Check both diagonals
        if ((board[0][0]==player && board[1][1]==player && board[2][2]==player) ||
            (board[0][2]==player && board[1][1]==player && board[2][0]==player))
            return true;

        return false;
    }

    // Checks if the game ended in a draw (no empty cells left)
    static boolean draw(char[][] board) {
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(board[i][j]==' ')
                    return false;
        return true;
    }
}
