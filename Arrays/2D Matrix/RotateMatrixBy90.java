import java.util.Scanner;
class RotateMatrixBy90
{
    static void rotateBrute(int[][] matrix) //Time Complexity O(n^2) Space Complexity O(n^2)
    {
        int n = matrix.length;
        int[][] result = new int[n][n];
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                result[j][n - i - 1] = matrix[i][j];
            }
        }
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                System.out.print(result[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    static void rotateOptimal(int[][] matrix) //Time Complexity O(n^2) Space O(1)
    {
        int n = matrix.length;
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = i+1 ; j < n ; j++)
            {
                int temp1 = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp1;   
            }
        }
        for(int i = 0 ; i < n ; i++)
        {
           int start = 0 ;
           int end = n - 1;
           while(start < end)
           {
            int temp = matrix[i][start];
            matrix[i][start] = matrix[i][end];
            matrix[i][end] = temp;
            start++;
            end--;
           }
        }
        for(int[] x : matrix)
        {
            for(int y : x)
            {
                System.out.print(y + " ");
            }
            System.out.println("");
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the square matrix : ");
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        System.out.println("Enter the " + (n*n) + " number of array elements : ");
        
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }
        System.err.println("");
        System.out.println("Matrix after being rotate by 90 Degrees : ");
        rotateOptimal(arr);
    }
}