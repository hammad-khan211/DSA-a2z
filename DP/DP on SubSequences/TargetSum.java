import java.util.*;
class TargetSum //lc 494
{
    static int findCount(int[] nums , int target) // return the number of ways in which + , - signs can be arranged before every element such that it evaluates to target
    {
        int totalSum = 0;
        for(int x : nums)
        {
            totalSum += x;
        }
        //S1 - S2 = target
        //totalSum -S2 - S2 = target
        //totalSum - 2 S2 = target
        // S2 = ( totalSum - target ) / 2
        if(totalSum - target < 0 || (totalSum - target) % 2 == 1)
        {
            return 0;
        }
        return countSubSequencesWithSumK(nums , ( totalSum - target ) / 2);
    }

    static int countSubSequencesWithSumK(int[] nums , int k)
    {
        int[] prev = new int[k + 1];
        if(nums[0] == 0)
        {
            prev[0] = 2;
        }
        else
        {
            prev[0] = 1;
        }
        if(nums[0] != 0 && nums[0] <= k)
        {
            prev[nums[0]] = 1;
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
                    take = prev[j - nums[i]];
                }
                temp[j] = take + nottake;
            }
            prev = temp;
        }
        return prev[k];
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " number of array elements : ");
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter k : ");
        int k = sc.nextInt();
        int ans = findCount(arr, k);
        System.out.println("TOTAL WAYS IN WHICH + and - CAN BE ARRANGED BEFORE EACH ELEMENT TO REACH " + k + " ARE => " +  ans);
    }
}
