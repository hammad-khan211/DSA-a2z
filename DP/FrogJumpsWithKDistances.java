import java.util.*;
class FrogJumpsWithKDistances
{
    static int[] findMinEnergy(int[] height , int k) 
    {
        int n = height.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp , -1);
        int ans1 = recursionSol(height , n - 1 , k);
        int ans2 = memoizationSol(height , n - 1 , k , dp);
        int ans3 = tabulationSol(height , n - 1 , k);
        return new int[]{ans1 , ans2 , ans3};

    }    

    static int recursionSol(int[] height , int n , int k) //tc O(2^(n * k)) sc O(n)
    {
        if(n == 0)
        {
            return 0;
        }

        int minEnergy = Integer.MAX_VALUE;
        for(int j = 1 ; j <= k ; j++)
        {
            if(n - j >= 0)
            {
                int jump = recursionSol(height , n - j , k) + Math.abs(height[n] - height[n - j]);
                minEnergy = Math.min(minEnergy , jump);
            }
        }
        return minEnergy;
    }

    static int memoizationSol(int[] height , int n , int k , int[] dp) //tc O(n * k) sc O(n) recursive stack O(n) dp array
    {
        if(n == 0)
        {
            return 0;
        }

        if(dp[n] != -1)
        {
            return dp[n];
        }

        dp[n] = Integer.MAX_VALUE;
        for(int j = 1 ; j <= k ; j++)
        {
            if(n - j >= 0)
            {
                int jump = memoizationSol(height, n - j , k, dp) + Math.abs(height[n - j] - height[n]);
                dp[n] = Math.min(dp[n] , jump);
            }
        }
        return dp[n];
    }

    static int tabulationSol(int[] height , int n , int k) //tc O(n * k) //sc O(n) for dp array
    {
        if(n == 0)
        {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;

        for(int i = 1 ; i <= n ; i++)
        {
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1 ; j <= k ; j++)
            {
                if(i - j >= 0)
                {
                    int jump = dp[i - j] + Math.abs(height[i - j] - height[i]);
                    dp[i] = Math.min(dp[i] , jump);
                }
            }
        }
        return dp[n];
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
        System.out.println("Enter k : ");
        int k = sc.nextInt();

        int[] ans = findMinEnergy(height , k);
        System.out.println("MINIMUM ENERGY Using RECURSION is : " + ans[0]);
        System.out.println("MINIMUM ENERGY Using Memoization ( TOP DOWN ) By DP is : " + ans[1]);
        System.out.println("MINIMUM ENERGY Using Tabulation ( BOTTOM UP ) By DP is : " + ans[2]);
    }
}
