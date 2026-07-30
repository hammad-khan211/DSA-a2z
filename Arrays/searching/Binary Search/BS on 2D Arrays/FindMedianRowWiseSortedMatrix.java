import java.util.*;
class FindMedianRowWiseSortedMatrix
{
    
    static int findMin(int[][] mat , int col) //tc O(n logm * log(max - min))
    {
        int min = mat[0][col];
        for(int i = 0 ; i < mat.length ; i++)
        {
            min = Math.min(min , mat[i][col]);
        }
        return min;
    }
    
    static int findMax(int[][] mat , int col)
    {
        int max = mat[0][col];
        for(int i = 0 ; i < mat.length ; i++)
        {
            max = Math.max(max , mat[i][col]);
        }
        return max;   
    }
    
    static int findSmallerEquals(int[][] mat , int x)
    {
        int n = mat.length;
        int m = mat[0].length;
        
        int count = 0;
        for(int i = 0 ; i < n ; i++)
        {
            int low = 0;
            int high = m - 1;
            while(low <= high)
            {
                int mid = low + ((high - low) / 2);
                if(mat[i][mid] <= x)
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }
            count += low;
        }
        return count;
    }
    
    static int median(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int low = findMin(mat , 0);
        int high = findMax(mat , m - 1);
        
        while(low <= high)
        {
            int mid = low + ((high - low) / 2);
            int smallerEquals = findSmallerEquals(mat , mid);
            
            if(smallerEquals <= ((n * m) / 2))
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;    
            }
        }
        return low;
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

        int ans = median(mat);
        System.out.println("Median of Row Wise Sorted 2D Matrix is : " + ans);

    }
}