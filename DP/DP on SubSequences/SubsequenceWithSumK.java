import java.util.*;
class SubsequenceWithSumK
{
    static boolean[] doesSubsetExists(int[] arr , int k)
    {
        int[][] dp = new int[arr.length][k + 1];
        for(int[] row : dp)
        {
            Arrays.fill(row , -1);
        }
        boolean ans1 = recursion(arr.length - 1 , arr , k);
        boolean ans2 = memoization(arr.length - 1 , arr, k, dp);
        boolean ans3 = tabulation(arr , k);
        boolean ans4 = spaceOptimizedTabulation(arr , k);
        return new boolean[]{ans1 , ans2 , ans3 , ans4};
    } 
    
    static boolean recursion(int index , int[] arr , int target)
    {
        if(target == 0)
        {
            return true;
        }
        if(index == 0)
        {
            return (arr[index] == target);
        }

        boolean nottake = recursion(index - 1 , arr , target);
        boolean take = false;
        if(arr[index] <= target)
        {
            take = recursion(index - 1 , arr , target - arr[index]);
        }
        return take | nottake;
    }

    static boolean memoization(int index , int[] arr , int target , int[][] dp)
    {
        if(target == 0)
        {
            return true;
        }
        if(index == 0)
        {
            return (arr[index] == target);
        }
        if(dp[index][target] != -1)
        {
            return dp[index][target] == 1;
        }

        boolean nottake = memoization(index - 1 , arr , target , dp);
        boolean take = false;
        if(arr[index] <= target)
        {
            take = memoization(index - 1 , arr , target - arr[index] , dp);
        }
        boolean ans = take | nottake; 
        dp[index][target] = ans ? 1 : 0;
        return ans;  
    }

    static boolean tabulation(int[] arr , int k)
    {
        int[][] dp = new int[arr.length][k + 1];
        for(int i = 0 ; i < arr.length ; i++)
        {
            dp[i][0] = 1;
        }
        if(arr[0] <= k) dp[0][arr[0]] = 1;
         
        for(int index = 1 ; index < arr.length ; index++)
        {
            for(int target = 1 ; target < k + 1 ; target++)
            {
                boolean notTake = dp[index - 1][target] == 1 ? true : false;
                boolean take = false;
                if(arr[index] <= target)
                {
                    take = dp[index - 1][target - arr[index]] == 1 ? true : false;
                }
                boolean ans = notTake | take;
                dp[index][target] = ans ? 1 : 0;
            }
        }
        return dp[arr.length - 1][k] == 1 ? true : false;
    }

    static boolean spaceOptimizedTabulation(int[] arr , int k)
    {
        int[] prev = new int[k + 1];
        prev[0] = 1;
        if(arr[0] <= k) prev[arr[0]] = 1;
         
        for(int index = 1 ; index < arr.length ; index++)
        {
            int[] temp = new int[k + 1];
            temp[0] = 1;
            for(int target = 1 ; target < k + 1 ; target++)
            {
                boolean notTake = prev[target] == 1 ? true : false;
                boolean take = false;
                if(arr[index] <= target)
                {
                    take = prev[target - arr[index]] == 1 ? true : false;
                }
                boolean ans = notTake | take;
                temp[target] = ans ? 1 : 0;
            }
            prev = temp;
        }
        return prev[k] == 1 ? true : false;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size : ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter " + n + " array elements : ");
        for(int i = 0 ; i < n ; i++)
        {
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter target value : ");
        int k = sc.nextInt();
        boolean[] ans = doesSubsetExists(nums, k);
        System.out.println("SUBSET WITH SUM K EXISTS ? => " +  ans[0] + " USING REUCRSION");
        System.out.println("SUBSET WITH SUM K EXISTS ? => " +  ans[1] + " USING MEMOIZATION");
        System.out.println("SUBSET WITH SUM K EXISTS ? => " +  ans[2] + " USING TABULATION");
        System.out.println("SUBSET WITH SUM K EXISTS ? => " +  ans[3] + " USING SPACE OPTIMIZED TABULATION");
    }
}
