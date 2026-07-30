import java.util.*;
class PeakElement2
{
    static int[] findPeak(int[][] mat)//tc O(n log m)
    {
        int n = mat.length;
        int m = mat[0].length;

        if(m == 1) return new int[]{ findMax(mat , 0) , 0};

        int low = 0;
        int high = m - 1;
        while(low <= high)
        {
            int mid = low + ((high - low) / 2);
            int row = findMax(mat , mid);
            int left = (mid > 0) ? mat[row][mid - 1] : Integer.MIN_VALUE;
            int right = (mid < m - 1) ? mat[row][mid + 1] : Integer.MIN_VALUE;

            if(left < mat[row][mid] && mat[row][mid] > right)
            {
                return new int[]{row , mid};
            }
            else if(mat[row][mid] < right)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return new int[]{-1 , -1};
    }

    static int findMax(int[][] mat , int col)
    {
        int ans = mat[0][col];
        int index = 0;
        for(int i = 0 ; i < mat.length ; i++)
        {
            if(ans < mat[i][col])
            {
                ans = mat[i][col];
                index = i;
            }
        }
        return index;
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
        int[] ans = findPeak(mat);
        System.out.println("Peak Element found at : { " + ans[0] + " , " + ans[1] + " }");
    }
}