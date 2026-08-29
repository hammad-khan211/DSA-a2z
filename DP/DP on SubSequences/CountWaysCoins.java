import java.util.*;
class CountWaysCoins //COunt ways in which coins can be taken to build up the given amount
{
    static int[] findCount(int[] coins , int amount)
    {
        int[][] dp = new int[coins.length][amount + 1];
        for(int[] row : dp)
        {
            Arrays.fill(row , -1);
        }
        int ans1 = recursion(coins.length - 1 , coins , amount);
        int ans2 = memoization(coins.length - 1 , coins , amount , dp);
        int ans3 = tabulation(coins, amount);
        int ans4 = spaceOptimizedTabulation(coins, amount);
        return new int[]{ans1 , ans2 , ans3 , ans4};
    }    

    static int recursion(int index , int[] nums , int k)
    {
        if(index == 0)
        {
            if(k % nums[0] == 0)
            {
                return 1;
            }
            return 0;
        }
        int take = 0;
        int nottake = recursion(index - 1 , nums , k);
        if(nums[index] <= k)
        {
            take = recursion(index , nums , k - nums[index]);
        }
        return nottake + take;
    }

    static int memoization(int index , int[] nums , int k , int[][] dp)
    {
        if(index == 0)
        {
            if(k % nums[0] == 0)
            {
                return 1;
            }
            return 0;
        }
        if(dp[index][k] != -1)
        {
            return dp[index][k];
        }
        int take = 0;
        int nottake = memoization(index - 1 , nums , k , dp);
        if(nums[index] <= k)
        {
            take = memoization(index , nums , k - nums[index] , dp);
        }
        dp[index][k] = nottake + take;
        return dp[index][k];
    }

    static int tabulation(int[] nums , int k)
    {
        int[][] dp = new int[nums.length][k + 1];
        for(int j = 0 ; j <= k ; j++)
        {
            if(j % nums[0] == 0)
            {
                dp[0][j] = 1;
            }
            else
            {
                dp[0][j] = 0;
            }
        }

        for(int i = 1 ; i < nums.length ; i++)
        {
            for(int j = 0 ; j <= k ; j++)
            {
                int take = 0;
                int nottake = dp[i - 1][j];
                if(nums[i] <= j)
                {
                    take = dp[i][j - nums[i]];
                }
                dp[i][j] = nottake + take; 
            }
        }
        return dp[nums.length - 1][k];
    }

    static int spaceOptimizedTabulation(int[] nums , int k)
    {
        int[] prev = new int[k + 1];
        for(int j = 0 ; j <= k ; j++)
        {
            if(j % nums[0] == 0)
            {
                prev[j] = 1;
            }
            else
            {
               prev[j] = 0;
            }
        }

        for(int i = 1 ; i < nums.length ; i++)
        {
            int[] temp = new int[k + 1];
            for(int j = 0 ; j <= k ; j++)
            {
                int take = 0;
                int nottake = prev[j];
                if(nums[i] <= j)
                {
                    take = temp[j - nums[i]];
                }
                temp[j] = nottake + take; 
            }
            prev = temp;
        }
        return prev[k];
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " number of different coins : ");
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter amount : ");
        int k = sc.nextInt();
        int[] ans = findCount(arr, k);
        System.out.println("NUMBER OF WAYS IN WHICH COINS CAN BE TAKEN TO BUILD THE GIVEN AMOUNT => " +  ans[0] + " USING REUCRSION");
        System.out.println("NUMBER OF WAYS IN WHICH COINS CAN BE TAKEN TO BUILD THE GIVEN AMOUNT => " +  ans[1] + " USING MEMOIZATION");
        System.out.println("NUMBER OF WAYS IN WHICH COINS CAN BE TAKEN TO BUILD THE GIVEN AMOUNT=> " +  ans[2] + " USING TABULATION");
        System.out.println("NUMBER OF WAYS IN WHICH COINS CAN BE TAKEN TO BUILD THE GIVEN AMOUNT => " +  ans[3] + " USING SPACE OPTIMIZED TABULATION");
    }
}
