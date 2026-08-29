import java.util.*;
class CountSubsequencesWithSumK
{

    static int[] optimal(int[] nums , int target)
    {
        int[][] dp = new int[nums.length][target + 1];
        for(int[] row : dp)
        {
            Arrays.fill(row , -1);
        }
        int count = recursion(nums.length - 1 , nums , target);
        int count1 = memoization(nums.length - 1 , nums , target , dp);
        int count2 = tabulation(nums , target);
        int count3 = spaceOptimizedTabulation(nums , target);
        return new int[]{count , count1 , count2 , count3};
    }

    static int recursion(int index , int[] nums , int target)
    {
        if(index == 0)
        {
            if(target == 0 && nums[0] == 0)
            {
                return 2;
            }
            if(target == 0 || target == nums[0])
            {
                return 1;
            }
            return 0;
        }
        int take = 0;
        int nottake = recursion(index - 1 , nums , target);
        if(nums[index] <= target)
        {
            take = recursion(index - 1 , nums , target - nums[index]);
        }
        return take + nottake;
    }

    static int memoization(int index , int[] nums , int target , int[][] dp)
    {
        if(index == 0)
        {
            if(target == 0 && nums[0] == 0)
            {
                return 2;
            }
            if(target == 0 || target == nums[0])
            {
                return 1;
            }
            return 0;
        }
        if(dp[index][target] != -1)
        {
            return dp[index][target];
        }
        int take = 0;
        int nottake = recursion(index - 1 , nums , target);
        if(nums[index] <= target)
        {
            take = recursion(index - 1 , nums , target - nums[index]);
        }
        dp[index][target] = take + nottake;
        return dp[index][target];
    }

    static int tabulation(int[] nums , int target)
    {
        int[][] dp = new int[nums.length][target + 1];
        dp[0][0] = 0;
        if(nums[0] == 0)
        {
            dp[0][0] = 2;
        }
        else
        {
            dp[0][0] = 1;
        }
        if(nums[0] != 0 && nums[0] <= target)
        {
            dp[0][nums[0]] = 1;
        }
        for(int i = 1 ; i < nums.length ; i++)
        {
            for(int j = 0 ; j <= target ; j++)
            {
                int take = 0;
                int nottake = dp[i - 1][j];
                if(nums[i] <= j)
                {
                    take = dp[i - 1][j - nums[i]];
                }
                dp[i][j] = take + nottake;
            }
        }
        return dp[nums.length - 1][target];
    }

    static int spaceOptimizedTabulation(int[] nums , int target)
    {
        int[] prev = new int[target + 1];
        prev[0] = 0;
        if(nums[0] == 0)
        {
            prev[0] = 2;
        }
        else
        {
            prev[0] = 1;
        }
        if(nums[0] != 0 && nums[0] <= target)
        {
            prev[nums[0]] = 1;
        }
        for(int i = 1 ; i < nums.length ; i++)
        {
            int[] temp = new int[target + 1];
            for(int j = 0 ; j <= target ; j++)
            {
                int take = 0;
                int nottake = prev[j];
                if(nums[i] <= j)
                {
                    take = prev[j - nums[i]];
                }
                temp[j] = take + nottake;
            }
            prev = temp;
        }
        return prev[target];
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array : ");
        int n = sc.nextInt();
        int total = 1 << n;
        int[] arr = new int[n];
        System.out.println("Enter " + n + " number of array elements : ");
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter k : ");
        int k = sc.nextInt();
        int[] ans = optimal(arr, k);
        System.out.println("TOTAL SUBSET WITH SUM K EXISTS => " +  ans[0] + " USING REUCRSION");
        System.out.println("TOTAL SUBSET WITH SUM K EXISTS => " +  ans[1] + " USING MEMOIZATION");
        System.out.println("TOTAL SUBSET WITH SUM K EXISTS => " +  ans[2] + " USING TABULATION");
        System.out.println("TOTAL SUBSET WITH SUM K EXISTS => " +  ans[3] + " USING SPACE OPTIMIZED TABULATION");
    }
}