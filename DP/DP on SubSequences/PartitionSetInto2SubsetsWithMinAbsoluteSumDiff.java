import java.util.*;
class PartitionSetInto2SubsetsWithMinAbsoluteSumDiff
{
    static int findMinDiffTabulation(int[] nums)
    {
        int n = nums.length;
        int sum = 0;
        for(int x : nums)
        {
            sum += x;
        }
        boolean[][] dp = new boolean[n][sum + 1];
        for(int i = 0 ; i < n ; i++)
        {
            dp[i][0] = true;
        }
        if(nums[0] <= sum)
        {
            dp[0][nums[0]] = true;
        }

        for(int i = 1 ; i < n ; i++)
        {
            for(int target = 1 ; target <= sum ; target++)
            {
                boolean take = false;
                boolean nottake = dp[i - 1][target];
                if(nums[i] <= target)
                {
                    take = dp[i - 1][target - nums[i]];
                }
                dp[i][target] = take || nottake;
            }
        }

        int minDiff = Integer.MAX_VALUE;
        for(int target = 0 ; target <= sum / 2 ; target++)
        {
            if(dp[n - 1][target])
            {
                int s1 = target;
                int s2 = sum - target;
                minDiff = Math.min(minDiff , Math.abs(s1 - s2));
            }
        }
        return minDiff;
    }    

    static int findMinDiffSpaceOptimization(int[] nums)
    {
        int n = nums.length;
        int sum = 0;
        for(int x : nums)
        {
            sum += x;
        }
        boolean[] prev = new boolean[sum + 1];
        if(nums[0] <= sum)
        {
            prev[nums[0]] = true;
        }

        for(int i = 1 ; i < n ; i++)
        {
            boolean[] temp = new boolean[sum + 1];
            temp[0] = true;
            for(int target = 1 ; target <= sum ; target++)
            {
                boolean take = false;
                boolean nottake = prev[target];
                if(nums[i] <= target)
                {
                    take = prev[target - nums[i]];
                }
                temp[target] = take || nottake;
            }
            prev = temp;
        }

        int minDiff = Integer.MAX_VALUE;
        for(int target = 0 ; target <= sum / 2 ; target++)
        {
            if(prev[target])
            {
                int s1 = target;
                int s2 = sum - target;
                minDiff = Math.min(minDiff , Math.abs(s1 - s2));
            }
        }
        return minDiff;
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
        int ans1 = findMinDiffTabulation(nums);
        int ans = findMinDiffSpaceOptimization(nums);
        System.out.println("MIN ABSOLUTE DIFF => " +  ans1 + " USING TABULATION");
        System.out.println("MIN ABSOLUTE DIFF => " +  ans + " USING SPACE OPTIMIZED TABULATION");
    }
}
