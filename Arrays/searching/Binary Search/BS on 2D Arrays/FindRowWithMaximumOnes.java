import java.util.*;
class FindRowWithMaximumOnes
{
    static int brute(int[][] mat)//tc O(n * m)
    {
        int index = -1;
        int max = 0;
        for(int i = 0 ; i < mat.length ; i++)
        {
            int count = 0;
            for(int j = 0 ; j < mat[i].length ; j++)
            {
                if(mat[i][j] == 1)
                {
                    count++;
                }
            }
            if(count > max)
            {
                max = count;
                index = i;
            }
        }
        return index;
    }

    static int optimal(int[][] mat)//tc O(n log(m))
    {
        int index = -1;
        int ans = 0;
        for(int i = 0 ; i < mat.length ; i++)
        {
            int low = 0;
            int high = mat[i].length - 1;
            while(low <= high)
            {
                int mid = low + ((high - low) / 2);
                if(mat[i][mid] >= 1)
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }
            }
            if(ans < mat[i].length - low)
            {
                ans = mat[i].length - low;
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
        int ans = optimal(mat);
        System.out.println("Maximum no. of ones are in row at index : " + ans);

    }
}