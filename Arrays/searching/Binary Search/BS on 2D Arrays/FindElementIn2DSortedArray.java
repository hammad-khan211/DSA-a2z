import java.util.*;
class FindElementIn2DSortedArray//lc 74
{
    static boolean brute(int[][] mat , int target) //tc O(n * m)
    {
        for(int i = 0 ; i < mat.length ; i++)
        {
            for(int j = 0 ; j < mat[i].length ; j++)
            {
                if(mat[i][j] == target)
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    static boolean better1(int[][] mat , int target) // tc O(n log m)
    {
        for(int i = 0 ; i < mat.length ; i++)
        {
            if(mat[i][0] <= target && target <= mat[i][mat[i].length - 1])
            {
                int low = 0;
                int high = mat[i].length - 1;
                while(low <= high)
                {
                    int mid = low + ((high - low) / 2);
                    if(mat[i][mid] == target)
                    {
                        return true;
                    }
                    else if(mat[i][mid] < target)
                    {
                        low = mid + 1;
                    }
                    else
                    {
                        high = mid - 1;
                    }
                }
            }
        }
        return false;
    }

    static boolean better2(int[][] matrix , int target) //tc O(logn + logm)
        {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int low1 = 0;
        int high1 = n - 1;
        while(low1 <= high1)
        {
            int mid1 = low1 + ((high1 - low1) / 2);
            if(matrix[mid1][0] <= target)
            {
                low1 = mid1 + 1;
            }
            else
            {
                high1 = mid1 - 1;
            }
        }
        if(high1 < 0) return false;

        int low2 = 0;
        int high2 = m - 1;
        while(low2 <= high2)
        {
            int mid2 = low2 + ((high2 - low2) / 2);
            if(matrix[high1][mid2] == target)
            {
                return true;
            }
            else if(matrix[high1][mid2] < target)
            {
                low2 = mid2 + 1;
            }
            else
            {
                high2 = mid2 - 1;
            }
        }
        return false;
    }

    static boolean optimal(int[][] mat , int target) //tc O(log(m * n))
    {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0;
        int high = (n * m - 1);

        while(low <= high)
        {
            int mid = low + ((high - low) / 2);
            {
                int row = mid / m;
                int col = mid % m;

                if(mat[row][col] == target) return true;
                else if(mat[row][col] < target) low = mid + 1;
                else high = mid - 1;
            }
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