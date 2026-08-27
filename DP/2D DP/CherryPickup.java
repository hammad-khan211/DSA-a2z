import java.util.*;
class CherryPickup
{
    static int[] findMaxCherries(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for(int[][] arr : dp)
        {
            for(int[] row : arr)
            {
                Arrays.fill(row , - 1);
            }
        }
        int ans1 = recursion(0 , 0 , n - 1 , grid);
        int ans2 = memoization(0 , 0 , n - 1 , grid , dp);
        int ans3 = tabulation(grid);
        return new int[]{ans1 , ans2 , ans3};
    }    

    static int recursion(int i , int j1 , int j2 , int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        if(j1 < 0 || j2 < 0 || j1 >= n || j2 >= n)
        {
            return -1000000009;
        }
        if(i == m - 1)
        {
            if(j1 == j2)
            {
                return grid[i][j1];
            }
            else
            {
                return grid[i][j1] + grid[i][j2];
            }
        }
        int max = -1000000009;
        for(int dj1 = -1 ; dj1 <= 1 ; dj1++)
        {
            for(int dj2 = -1 ; dj2 <= 1 ; dj2++)
            {
                int value = 0;
                if(j1 == j2)
                {
                    value = grid[i][j1];
                }
                else
                {
                    value = grid[i][j1] + grid[i][j2];
                }
                value += recursion(i + 1 , j1 + dj1 , j2 + dj2 , grid);
                max = Math.max(max , value);
            }
        }
        return max;
    }

    static int memoization(int i , int j1 , int j2 , int[][] grid , int[][][] dp)
    {
        int m = grid.length;
        int n = grid[0].length;
        if(j1 < 0 || j2 < 0 || j1 >= n || j2 >= n)
        {
            return -1000000009;
        }
        if(i == m - 1)
        {
            if(j1 == j2)
            {
                return grid[i][j1];
            }
            else
            {
                return grid[i][j1] + grid[i][j2];
            }
        }
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        int max = -1000000009;
        for(int dj1 = -1 ; dj1 <= 1 ; dj1++)
        {
            for(int dj2 = -1 ; dj2 <= 1 ; dj2++)
            {
                int value = 0;
                if(j1 == j2)
                {
                    value = grid[i][j1];
                }
                else
                {
                    value = grid[i][j1] + grid[i][j2];
                }
                value += memoization(i + 1 , j1 + dj1 , j2 + dj2 , grid , dp);
                max = Math.max(max , value);
            }
        }
        dp[i][j1][j2] = max;
        return dp[i][j1][j2];
    }

    static int tabulation(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for(int j1 = 0 ; j1 < n ; j1++)
        {
            for(int j2 = 0 ; j2 < n ; j2++)
            {
                if(j1 == j2)
                {
                    dp[m - 1][j1][j2] = grid[m - 1][j1];
                }
                else
                {
                    dp[m - 1][j1][j2] = grid[m - 1][j1] + grid[m - 1][j2];
                }
            }
        }
        for(int i = m - 2 ; i >= 0 ; i--)
        {
            for(int j1 = 0 ; j1 < n ; j1++)
            {
                for(int j2 = 0 ; j2 < n ; j2++)
                {
                    int max = -1000000009;
                    for(int dj1 = -1 ; dj1 <= 1 ; dj1++) //explore all possible combos of both robots
                    {
                        for(int dj2 = -1 ; dj2 <= 1 ; dj2++)
                        {
                            int value = 0;
                            if(j1 == j2)
                            {
                                value = grid[i][j1];
                            }
                            else
                            {
                                value = grid[i][j1] + grid[i][j2];
                            }
                            if(j1 + dj1 >= 0 && j1 + dj1 < n && j2 + dj2 >= 0 && j2 + dj2 < n)
                            {
                                value += dp[i + 1][j1 + dj1][j2 + dj2];
                            }
                            else
                            {
                                value += -1000000009;
                            }
                            max = Math.max(max , value);
                            dp[i][j1][j2] = max;
                        }
                    }
                }
            }
        }
        return dp[0][0][n - 1];
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows : ");
        int r = sc.nextInt();
        System.out.println("Enter columns : ");
        int c = sc.nextInt();
        int[][] m = new int[r][c];
        System.out.println("Enter " + r*c + " grid elements");
        for(int i = 0 ; i < r ; i++)
        {
            for(int j = 0 ; j < c ; j++)
            {
                m[i][j] = sc.nextInt();
            }
        }
        int[] ans = findMaxCherries(m);
        System.out.println("MAX CHERRIES PICKED UP Using RECURSION is : " + ans[0]);
        System.out.println("MAX CHERRIES PICKED UP Using Memoization ( TOP DOWN ) By DP is : " + ans[1]);
        System.out.println("MAX CHERRIES PICKED UP Using Tabulation ( BOTTOM UP ) By DP is : " + ans[2]);
        // System.out.println("MAX CHERRIES PICKED UP Using Space Optimized Tabulation ( BOTTOM UP ) BY DP is : " + ans[3]);
    }
}
