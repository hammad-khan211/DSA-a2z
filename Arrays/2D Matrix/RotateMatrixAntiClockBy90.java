import java.util.Scanner;
class RotateMatrixAntiClockBy90
{
    static void rotateBrute(int[][] matrix)//Time Complexity O(n^2) Space O(n^2)
    {
        int n = matrix.length;
        int[][] result = new int[n][n];
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                result[n - j - 1][i] = matrix[i][j];
            }
        }
        for(int[] X : result)
        {
            for(int Y : X)
            {
                System.out.print(Y + " ");
            }
            System.out.println("");
        }
    }

    static void rotateOptimal(int[][] matrix)//Time Complexity O(n^2) Space O(1)
    {
        int n = matrix.length;
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = i + 1 ; j < n ; j++) //transpose 
            {
                int temp1 = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp1;
            }
        }
        for(int j = 0 ; j < n ; j++)//then reverse columns elements
        {
            int start = 0 ;
            int end = n - 1;
            while(start < end)
            {
                int temp2 = matrix[start][j];
                matrix[start][j] = matrix[end][j];
                matrix[end][j] = temp2;
                start++;
                end--;
            }
        }
        for(int[] X : matrix)//print resultant matrix rotated by 90 degrees anti clockwise
        {
            for(int Y : X)
            {
                System.out.print(Y + " ");
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
        System.out.println("Matrix after being rotate by 90 Degrees Anti Clockwise : ");
        rotateOptimal(arr);
    }
}