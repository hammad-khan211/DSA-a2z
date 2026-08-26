import java.util.*;
class MinimumPathSum
{
    static int[] minSumPath(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp)
        {
            Arrays.fill(row , -1);
        }
        int ans1 = recursion(m - 1 , n - 1 , grid);
        int ans2 = memoization(m - 1, n - 1, dp , grid);
        int ans3 = tabulation(grid);
        int ans4 = spaceOptimizedTabulation(grid);
        return new int[]{ans1 , ans2 , ans3 , ans4};

    } 
    
    static int recursion(int i , int j , int[][] grid) //tc O(2^(m + n)) sc O(m + n) recursive stack
    {
        if(i == 0 && j == 0)
        {
            return grid[0][0];
        }
        if(i < 0 || j < 0)
        {
            return 1000000009;
        }

        int up = grid[i][j] + recursion(i - 1 , j , grid);
        int left = grid[i][j] + recursion(i , j - 1 , grid);
        return Math.min(up , left);
    }

    static int memoization(int i , int j , int[][] dp , int[][] grid) //tc O(m * n) sc O(m + n) recursive stack O(m * n) dp array
    {
        if(i == 0 && j == 0)
        {
            return grid[0][0];
        }
        if(i < 0 || j < 0)
        {
            return 1000000009;
        }
        if(dp[i][j] != -1) return dp[i][j];

        int up = grid[i][j] + memoization(i - 1 , j , dp ,grid);
        int left = grid[i][j] + memoization(i , j - 1 , dp ,grid);
        dp[i][j] =  Math.min(up , left);
        return dp[i][j];
    }

    static int tabulation(int[][] grid) //tc O(m * n) sc O(m + n) dp array
    {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for(int i = 0 ; i < m ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                if(i == 0 && j == 0)
                {
                    dp[0][0] = grid[0][0];
                }
                else
                {
                    int up = 1000000009;
                    int left = 1000000009;
                    if(i > 0) up = grid[i][j] + dp[i - 1][j];
                    if(j > 0) left = grid[i][j] + dp[i][j - 1];
                    dp[i][j] = Math.min(up , left);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    static int spaceOptimizedTabulation(int[][] grid) //tc O(m * n) sc O(n)
    {
        int m = grid.length;
        int n = grid[0].length;
        int[] prev = new int[n];
        for(int i = 0 ; i < m ; i++)
        {
            int[] temp = new int[n];
            for(int j = 0 ; j < n ; j++)
            {
                if(i == 0 && j == 0)
                {
                    temp[j] = grid[i][j];
                }
                else
                {
                    int up = 1000000009;
                    int left = 1000000009;
                    if(i > 0)
                    {
                        up = grid[i][j] + prev[j];
                    }
                    if(j > 0)
                    {
                        left = grid[i][j] + temp[j - 1];
                    }
                    temp[j] = Math.min(up , left);
                }
            }
            prev = temp;
        }
        return prev[n - 1];
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter m : ");
        int m = sc.nextInt();
        System.out.println("Enter n : ");
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        System.out.println("Enter grid elements : ");
        for(int i = 0 ; i < m ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                grid[i][j] = sc.nextInt();
            }
        }
        int[] ans = minSumPath(grid);
        System.out.println("MIN PATH SUM Using RECURSION is : " + ans[0]);
        System.out.println("MIN PATH SUM Using Memoization ( TOP DOWN ) By DP is : " + ans[1]);
        System.out.println("MIN PATH SUM Using Tabulation ( BOTTOM UP ) By DP is : " + ans[2]);
        System.out.println("MIN PATH SUM Using Space Optimized Tabulation ( BOTTOM UP ) BY DP is : " + ans[3]);
    }    
}
