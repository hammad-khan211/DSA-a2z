import java.util.*;
public class FrogJumps
{
    static int[] findMinEnergy(int[] height) 
    {
        int n = height.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp , -1);
        int ans1 = recursionSol(height , n - 1);
        int ans2 = memoizationSol(height , n - 1 , dp);
        int ans3 = tabulationSol(height , n - 1);
        int ans4 = spaceOptimizedTabulation(height , n - 1);
        return new int[]{ans1 , ans2 , ans3 , ans4};

    }

    static int recursionSol(int[] height , int n) //tc O(2^n) sc O(n)
    {
        if(n == 0)
        {
            return 0;
        }

        int left = recursionSol(height , n - 1) + Math.abs(height[n] - height[n - 1]);
        int right = Integer.MAX_VALUE;
        if(n > 1)
        {
            right = recursionSol(height , n - 2) + Math.abs(height[n] - height[n - 2]);
        }
        return Math.min(left , right);
    }

    static int memoizationSol(int[] height , int n , int[] dp) // tc O(n) sc O(n) Dp array O(n) recursive stack
    {
        if(n == 0)
        {
            return 0;
        }

        if(dp[n] != -1)
        {
            return dp[n];
        }

        int left = memoizationSol(height, n - 1 , dp) + Math.abs(height[n] - height[n - 1]);
        int right = Integer.MAX_VALUE;
        if(n > 1)
        {
            right = memoizationSol(height, n - 2 , dp) + Math.abs(height[n - 2] - height[n]);
        }

        dp[n] = Math.min(left , right);
        return dp[n];
    }

    static int tabulationSol(int[] height , int n) //tc O(n) sc O(n) Dp Array
    {
        if(n == 0)
        {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for(int i = 1 ; i <= n ; i++)
        {
            int left = dp[i - 1] + Math.abs(height[i] - height[i - 1]);
            int right = Integer.MAX_VALUE;
            if(i > 1)
            {
                right = dp[i - 2] + Math.abs(height[i] - height[i - 2]);
            }
            dp[i] = Math.min(left , right);
        }
        return dp[n];
    }

    static int spaceOptimizedTabulation(int[] height , int n) //tc O(n) sc O(1)
    {
        if(n == 0)
        {
            return 0;
        }
        int prev2 = 0;
        int prev1 = 0;

        for(int i = 1 ; i <= n ; i++)
        {
            int left = prev1 + Math.abs(height[i - 1] - height[i]);
            int right = Integer.MAX_VALUE;
            if(i > 1)
            {
                right = prev2 + Math.abs(height[i - 2] - height[i]);
            }
            int current = Math.min(left , right);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = sc.nextInt();
        int[] height = new int[n];
        System.out.println("Enter " + n + " array elements : ");
        for(int i = 0 ; i < n ; i++)
        {
            height[i] = sc.nextInt();
        }

        int[] ans = findMinEnergy(height);
        System.out.println("MINIMUM ENERGY Using RECURSION is : " + ans[0]);
        System.out.println("MINIMUM ENERGY Using Memoization ( TOP DOWN ) By DP is : " + ans[1]);
        System.out.println("MINIMUM ENERGY Using Tabulation ( BOTTOM UP ) By DP is : " + ans[2]);
        System.out.println("MINIMUM ENERGY Using Space Optimized Tabulation ( BOTTOM UP ) BY DP is : " + ans[3]);
    }

}
