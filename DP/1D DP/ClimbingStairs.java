import java.util.*;
class ClimbingStairs
{
    static int recursion(int n) //tc O(2^n) sc O(n)
    {
        if(n <= 1)
        {
            return 1;
        }
        return recursion(n - 1) + recursion(n - 2);
    }    

    static int memoization(int n , int[] dp) //tc O(n) sc O(n) for DP Array O(n) for recursive stack
    {
        if(n <= 1)
        {
            return 1;
        }

        if(dp[n] != -1)
        {
            return dp[n];
        }

        dp[n] = memoization(n - 1 , dp) + memoization(n - 2 , dp);
        return dp[n];
    }

    static int tabulation(int n) //tc O(n) sc O(n) for DP Array
    {
        if(n <= 1)
        {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2 ; i <= n ; i++)
        {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];

    }

    static int spaceOptimizedTabulation(int n) //tc O(n) sc O(1)
    {
        if(n <= 1)
        {
            return 1;
        }

        int prev2 = 1;
        int prev1 = 1;

        for(int i = 2 ; i <= n ; i++)
        {
            int current = prev1 + prev2;
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
        int[] dp = new int[n + 1]; //memoization helps remembering whether the subproblem has already been solved , if solved then use the previously stored result
        Arrays.fill(dp , -1);
        int ans1 = recursion(n);
        int ans2 = memoization(n, dp);
        int ans3 = tabulation(n);
        int ans4 = spaceOptimizedTabulation(n);
        System.out.println("Number of ways to climb " + n + " stairs Using RECURSION is : " + ans1);
        System.out.println("Number of ways to climb " + n + " stairs Using Memoization ( TOP DOWN ) By DP is : " + ans2);
        System.out.println("Number of ways to climb " + n + " stairs Using Tabulation ( BOTTOM UP ) By DP is : " + ans3);
        System.out.println("Number of ways to climb " + n + " stairs Using Optimized Tabulation By ( BOTTOM UP ) DP is : " + ans4);
    }

}
