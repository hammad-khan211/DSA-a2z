import java.util.*;
class HouseRobber //find max sum of subsequenes with no adjacent array elements
{
    static int[] findMaxMoney(int[] nums)
    {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp , -1);
        int ans1 = recursionSol(nums , nums.length - 1);
        int ans2 = memoizationSol(nums , nums.length - 1 , dp);
        int ans3 = tabulationSol(nums, nums.length - 1);
        int ans4 = spaceOptimizedTabulation(nums , nums.length - 1);
        return new int[]{ans1 , ans2 , ans3 , ans4};
    }     

    static int recursionSol(int[] nums , int n) //tc O(2 ^ n) sc O(n)
    {
        if(n == 0)
        {
            return nums[0];
        }
        if(n < 0) return 0;

        int pick = recursionSol(nums, n - 2) + nums[n];
        int notpick = recursionSol(nums, n - 1) + 0;
        return Math.max(pick , notpick);
    }

    static int memoizationSol(int[] nums , int n , int[] dp) //tc O(n) sc O(n) recursive stack O(n) dp array
    {
        if(n == 0) return nums[0];
        if(n < 0) return 0;

        if(dp[n] != -1)
        {
            return dp[n];
        }

        int pick = nums[n] + memoizationSol(nums, n - 2 , dp);
        int notpick = 0 + memoizationSol(nums, n - 1 , dp);

        dp[n] = Math.max(pick , notpick);
        return dp[n];
    }

    static int tabulationSol(int[] nums , int n) //tc O(n) sc O(n) for dp array
    {
        if(n == 0) return nums[0];
        if(n < 0) return 0;

        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        int neg = 0;

        for(int i = 1 ; i <= n ; i++)
        {
            int pick = nums[i];
            pick += i > 1 ? dp[i - 2] : neg;
            int notpick = 0 + dp[i - 1];
            dp[i] = Math.max(pick , notpick);
        }
        return dp[n];
    }

    static int spaceOptimizedTabulation(int[] nums , int n) //tc O(n) sc O(1)
    {
        if(n == 0)
        {
            return nums[0];
        }
        if(n < 0)
        {
            return 0;
        }

        int prev2 = 0;
        int prev1 = nums[0];

        for(int i = 1 ; i <= n ; i++)
        {
            int pick = nums[i];
            pick += i > 1 ? prev2 : 0;
            int notpick = 0 + prev1;
            int current = Math.max(pick , notpick);
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
        int[] nums = new int[n];
        System.out.println("Enter " + n + " array elements : ");
        for(int i = 0 ; i < n ; i++)
        {
            nums[i] = sc.nextInt();
        }

        int[] ans = findMaxMoney(nums);
        System.out.println("MAX MONEY LOOTED Using RECURSION is : " + ans[0]);
        System.out.println("MAX MONEY LOOTED Using Memoization ( TOP DOWN ) By DP is : " + ans[1]);
        System.out.println("MAX MONEY LOOTED Using Tabulation ( BOTTOM UP ) By DP is : " + ans[2]);
        System.out.println("MAX MONEY LOOTED Using Space Optimized Tabulation ( BOTTOM UP ) BY DP is : " + ans[3]);
    }
}
