import java.util.*;
class HouseRobber2 //find max sum of subsequenes with no adjacent array elements and no first and last element
{
    static int rob(int[] nums)
    {
        if(nums.length == 1) return nums[0];
        int[] temp1 = new int[nums.length - 1]; //exlude first element
        int[] temp2 = new int[nums.length - 1]; //exclude last element

        for(int i = 1 ; i < nums.length ; i++)
        {
            temp1[i - 1] = nums[i];
        }
        for(int i = 0 ; i < nums.length - 1 ; i++)
        {
            temp2[i] = nums[i];
        }

        int ans1 = solve(temp1 , temp1.length - 1);
        int ans2 = solve(temp2 , temp2.length - 1);
        return Math.max(ans1 , ans2);
    }

    static int solve(int[] nums , int n)
    {
        if(n == 0) return nums[0];
        if(n < 0) return 0;

        int prev2 = 0;
        int prev1 = nums[0];

        for(int i = 1 ; i <= n ; i++)
        {
            int take = nums[i];
            take += i > 1 ? prev2 : 0;
            int nottake = 0 + prev1;
            int current = Math.max(take , nottake);
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

        int ans = rob(nums);
        System.out.println("MAX MONEY LOOTED Using Space Optimized Tabulation ( BOTTOM UP ) BY DP is : " + ans);
    }
}
