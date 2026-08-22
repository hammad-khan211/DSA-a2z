import java.util.*;
class ValidSudoku
{
    static void solveSudoku(char[][] board)
    {
        generate(board);
    }
    static boolean generate(char[][] board)
    {
        for(int i = 0 ; i < 9 ; i++)
        {
            for(int j = 0 ; j < 9 ; j++)
            {
                if(board[i][j] == '.')
                {
                    for(char c = '1' ; c <= '9' ; c++)
                    {
                        if(isValid(board , i , j , c))
                        {
                            board[i][j] = c;
                            if(generate(board) == true)
                            {
                                return true;
                            }
                            else
                            {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    static boolean isValid(char[][] board , int row , int col , char c)
    {
        for(int i = 0 ; i < 9 ; i++)
        {
            if(board[row][i] == c) return false;
            if(board[i][col] == c) return false;
            if(board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] == c) return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[9][9];
        System.out.println("Enter 81 sudoku elements : ");
        for(int i = 0 ; i < 9 ; i++)
        {
            for(int j = 0 ; j < 9 ; j++)
            {
                board[i][j] = sc.next().charAt(0);
            }
            System.out.println();
        }
        solveSudoku(board);
        System.out.println("SUDOKU RESULT : ");
        for(int i = 0 ; i < 9 ; i++)
        {
            for(int j = 0 ; j < 9 ; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
