import java.util.*;
class FindElementIn2DSortedArray2 //lc240
{
    static boolean optimal(int[][] mat , int target) //tc O(n * m)
    {
        int n = mat.length;
        int m = mat[0].length;

        int row = 0;
        int col = mat[0].length - 1;

        while(row < n && col >= 0)
        {
            if(mat[row][col] == target) return true;
            else if(mat[row][col] < target) row++;
            else col--;
        }
        return false;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of rows in matrix : ");
        int r = sc.nextInt();
        System.out.println("Enter the no. of columns in matrix : ");
        int c = sc.nextInt();
        System.out.println("Enter the " + r * c + " number of matrix elements : ");
        int[][] mat = new int[r][c];
        for(int i = 0 ; i < r ; i++)
        {
            for(int j = 0 ; j < c ; j++)
            {
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the target value : ");
        int t = sc.nextInt();
        if(optimal(mat , t)) System.out.println(t + " exists in matrix");
        else
        {
            System.out.println(t + " does not exists in matrix");
        }


    }
}