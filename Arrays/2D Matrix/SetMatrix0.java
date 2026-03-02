import java.util.Scanner;
class SetMatrix0
{
    static void markRow(int[][] matrix , int row)
    {
        for(int j = 0 ; j < matrix[row].length ; j++)
        {
            if(matrix[row][j] != 0)
            {
                matrix[row][j] = -1;
            }
        }
    }

    static void markColumn(int[][] matrix , int column)
    {
        for(int i = 0 ; i < matrix.length ; i++)
        {
            if(matrix[i][column] != 0)
            {
                matrix[i][column] = -1;
            }
        }
    }
    static void setMatrixZeroBrute(int[][] matrix) //Time Complexity O((n*m)*(n+m)) =>if square matrix O(n^2 * 2n)=> O(n^3) 
    {                                              //Space Complexity O(1)
        for(int i = 0 ; i < matrix.length ; i++)
        {
            for(int j = 0 ; j < matrix[i].length ; j++)
            {
                if(matrix[i][j] == 0)
                {
                    markRow(matrix , i);
                    markColumn(matrix , j);
                }
            }
        }
        for(int i = 0 ; i < matrix.length ; i++)
        {
            for(int j = 0 ; j < matrix[i].length ; j++)
            {
                if(matrix[i][j] == -1)
                {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    static void setMatrixZeroBetter(int[][] matrix) //Time Complexity O(n*m) Space Complexity o(n + m )
    {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] trackRow = new int[n];
        int[] trackCol = new int[m];
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < m ; j++)
            {
                if(matrix[i][j] == 0)
                {
                    trackRow[i] = 1;
                    trackCol[j] = 1;
                }
            }
        }
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < m ; j++)
            {
                if(trackRow[i] == 1 || trackCol[j] == 1)
                {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    static void setMatrixZeroOptimal(int[][] matrix) //Time Complexity O(n*m) Space Complexity O(1)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        int col0 = 1;
        // int[] trackRow = matrix[...][0]
        // int[] trackCol = matrix[0][...]
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < m ; j++)
            {
                if(matrix[i][j] == 0)
                {
                    matrix[i][0] = 0; //mark the ith row in trackRow
                    if(j != 0)
                    {
                        matrix[0][j] = 0; // mark the jth column in tackCol
                    }
                    else
                    {
                        col0 = 0;
                    }
                }
            }
        }
        for(int i = 1 ; i < n ; i++)
        {
            for(int j = 1 ; j < m ; j++)
            {
                if(matrix[i][j] != 0)
                {
                    if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        if(matrix[0][0] == 0)
        {
            for(int j = 0 ; j < m ; j++)
            {
                matrix[0][j] = 0;
            }
        }
        if(col0 == 0)
        {
            for(int i = 0 ; i < n ; i++)
            {
                matrix[i][0] = 0;
            }
        }
        
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows of the matrix : ");
        int n = sc.nextInt();
        System.out.println("Enter the number of columns for rach row : ");
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        System.out.println("Enter the " + (n*m) + " number of array elements : ");
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < m ; j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }
        setMatrixZeroOptimal(arr);
        System.out.println("Matrix after setting elements zero : ");
        {
            for(int i = 0 ; i < n ; i++)
            {
                for(int j = 0 ; j < m ; j++)
                {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println("");
            }
        }
    }
}