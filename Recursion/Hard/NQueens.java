import java.util.*;
class NQueens
{
    static List < List < String > > solveNQueens(int n)
    {
        List < List < String > > ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                board[i][j] = '.';
            }
        }
        generate(0 , board , ans , n);
        return ans;
    }

    static void generate(int column , char[][] board , List < List < String > > ans , int n)
    {
        if(column == n)
        {
            ArrayList < String > temp = new ArrayList<>();
            for(int i = 0 ; i < n ; i++)
            {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }
        for(int row = 0 ; row < n ; row++)
        {
            if(isSafe(row , column , board , n))
            {
                board[row][column] = 'Q';
                generate(column + 1 , board , ans , n);
                board[row][column] = '.';
            }
        }
    }

    static boolean isSafe(int row , int column , char[][] board , int n)
    {
        //check left
        for(int j = 0 ; j < column ; j++)
        {
            if(board[row][j] == 'Q') return false;
        }

        //check upper left diagonal
        for(int i = row , j = column ; i >= 0 && j >= 0 ; i-- , j--)
        {
            if(board[i][j] == 'Q') return false;
        }

        //check lower left diagonal
        for(int i = row , j = column ; i < n && j >= 0 ; i++ , j--)
        {
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = sc.nextInt();
        List < List < String > > ans = solveNQueens(n);
        for(List < String > X : ans)
        {
            System.out.print("[");
            for(String Y : X)
            {
                System.out.print(" " + Y + " ,");
            }
            System.out.print("]");
            System.out.println(",");
        }
    }
}