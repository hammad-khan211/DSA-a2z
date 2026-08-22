import java.util.*;
class WordSearch
{
    static boolean wordExists(char[][] board , String word)
    {
        for(int i = 0 ; i < board.length ; i++)
        {
            for(int j = 0 ; j < board[0].length ; j++)
            {
                if(dfs(board , word , i , j , 0))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    static boolean dfs(char[][] board , String word , int i , int j , int idx)
    {
        if(idx == word.length())
        {
            return true;
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(idx))
        {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = dfs(board , word , i + 1 , j , idx + 1) ||
                        dfs(board , word , i - 1 , j , idx + 1) ||
                        dfs(board , word , i , j + 1 , idx + 1) ||
                        dfs(board , word , i , j - 1 , idx + 1);

        board[i][j] = temp;
        return found;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of rows in board : ");
        int r = sc.nextInt();
        System.out.println("Enter the no. of columns in board : ");
        int c = sc.nextInt();
        char[][] board = new char[r][c];
        System.out.println("Enter the " + r * c + " number of array elements : ");
        for(int i = 0 ; i < r ; i++)
        {
            for(int j = 0 ; j < c ; j++)
            {
                board[i][j] = sc.next().charAt(0);
            }
        }
        System.out.println("Enter the word to be searched : ");
        String word = sc.next();
        if(wordExists(board, word))
        {
            System.out.println("True");
        }
        else
        {
            System.out.println("False");
        }

    }
}
