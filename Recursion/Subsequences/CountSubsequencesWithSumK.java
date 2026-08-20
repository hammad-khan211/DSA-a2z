import java.util.*;
class CountSubsequencesWithSumK
{

    static int optimal(int[] nums , int target)
    {
        int count = generate(nums , 0 , 0 , target);
        return count;
    }

    static int generate(int[] nums , int index , int sum , int k)
    {
        if(index == nums.length)
        {
            if(sum == k)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        sum += nums[index];
        int left = generate(nums , index + 1 , sum , k);
        sum -= nums[index];
        int right = generate(nums , index + 1 , sum , k);
        return left + right;
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
        int ans = optimal(arr , k);
        System.out.println("NUMBER OF SUBSEQUENCES WITH SUM " + k + " ARE : " + ans);
    }
}