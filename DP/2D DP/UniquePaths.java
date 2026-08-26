import java.util.*;
public class UniquePaths
{
    static int[] CountuniquePaths(int m , int n)
    {
        int[][] dp = new int[m][n];
        for(int[] row : dp)
        {
            Arrays.fill(row , -1);
        }
        int ans1 = recursion(m - 1 , n - 1);
        int ans2 = memoization(m - 1, n - 1, dp);
        int ans3 = tabulation(m , n);
        int ans4 = spaceOptimizedTabulation(m , n);
        return new int[]{ans1 , ans2 , ans3 , ans4};

    } 
    
    static int recursion(int m , int n)
    {
        if(m == 0 && n == 0)
        {
            return 1;
        }
        if(m < 0 || n < 0)
        {
            return 0;
        }

        int up = recursion(m - 1 , n);
        int left = recursion(m , n - 1);
        return up + left;
    }

    static int memoization(int m , int n , int[][] dp)
    {
        if(m == 0 && n == 0)
        {
            return 1;
        }
        if(m < 0 || n < 0)
        {
            return 0;
        }
        if(dp[m][n] != -1)
        {
            return dp[m][n];
        }

        int up = memoization(m - 1 , n , dp);
        int left = memoization(m , n - 1 , dp);
        dp[m][n] = up + left;
        return dp[m][n];
    }

    static int tabulation(int m , int n)
    {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for(int i = 0 ; i < m ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                if(i == 0 && j == 0)
                {
                    continue;
                }
                else
                {
                    int up = 0;
                    int left = 0;
                    if(i > 0) up = dp[i - 1][j];
                    if(j > 0) left = dp[i][j - 1];
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    static int spaceOptimizedTabulation(int m , int n)
    {
        int[] prev = new int[n];
        for(int i = 0 ; i < m ; i++)
        {
            int[] temp = new int[n];
            for(int j = 0 ; j < n ; j++)
            {
                if(i == 0 && j == 0)
                {
                    temp[j] = 1;
                }
                else
                {
                    int up = 0;
                    int left = 0;
                    if(i > 0)
                    {
                        up = prev[j];
                    }
                    if(j > 0)
                    {
                        left = temp[j - 1];
                    }
                    temp[j] = up + left;
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
        int[] ans = CountuniquePaths(m, n);
        System.out.println("NO. OF UNIQUE PATHS Using RECURSION is : " + ans[0]);
        System.out.println("NO. OF UNIQUE PATHS Using Memoization ( TOP DOWN ) By DP is : " + ans[1]);
        System.out.println("NO. OF UNIQUE PATHS Using Tabulation ( BOTTOM UP ) By DP is : " + ans[2]);
        System.out.println("NO. OF UNIQUE PATHS Using Space Optimized Tabulation ( BOTTOM UP ) BY DP is : " + ans[3]);
    }
}
