import java.util.*;
class Fibonacci
{
    //Memoization Top Down
    static int memoization(int n , int[] dp) //tc O(n) //sc O(n) for recursion stack O(n) for DP array
    {
        if(n <= 1)
        {
            return n;
        }
        if(dp[n] != -1)
        {
            return dp[n]; //if subproblem has been computed previosuly , reuse the previously stored answer by memoization
        }
        dp[n] = memoization(n - 1 , dp) + memoization(n - 2 , dp);//if subproblem has not been solved previously , then compute it and store it 
        return dp[n];
    }   

    //Tabulation Bottom UP
    static int tabulation(int n) //tc O(n) sc O(n) for DP Array
    {
        int[] dp = new int[n + 1];

        dp[0] = 0;

        if(n >= 1)
        {
            dp[1] = 1;
        }

        for(int i = 2 ; i <= n ; i++)
        {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    static int tabulationOptimized(int n) //tc O(n) sc O(1)
    {
        if(n <= 1) return n;

        int prev2 = 0;
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
        int[] dp = new int[n + 1]; //memoization helps remembering whther the subproblem has already been solved , if solved then use the stored previous result
        Arrays.fill(dp , -1);
        int ans1 = memoization(n, dp);
        int ans2 = tabulation(n);
        int ans3 = tabulationOptimized(n);
        System.out.println(n + "th Fibonacci Number Using Memoization ( TOP DOWN ) By DP is : " + ans1);
        System.out.println(n + "th Fibonacci Number Using Tabulation ( BOTTOM UP ) By DP is : " + ans2);
        System.out.println(n + "th Fibonacci Number Using Optimized Tabulation By ( BOTTOM UP ) DP is : " + ans3);
    }
}
