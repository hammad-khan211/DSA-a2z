import java.util.Scanner;
class MaximumSubarraySum
{
    static int maxSubarraySumBrute(int[] arr) //Time O(n^2) Space O(1)
    {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++)
        {
            int sum = 0;
            for(int j = i ; j < n ; j++)
            {
                sum += arr[j];
                maxSum = Math.max(maxSum , sum);
            }
        }
        return maxSum;
    }

    static int maxSubarraySumOptimal(int[] arr) //Time O(n) Space O(1) //Kadane's Theorem
    {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0 ; i < n ; i++)
        {
            sum += arr[i];
            maxSum = Math.max(maxSum , sum);
            if(sum < 0)
            {
                sum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter the " + size + " number of array elements : ");
        for(int i = 0 ; i < size ; i++)
        {
            nums[i] = sc.nextInt();
        }
        int brute = maxSubarraySumBrute(nums);
        int optimal = maxSubarraySumOptimal(nums);
        System.out.println("Maximumm Subarray Sum using Brute : " + brute);
        System.out.println("Maximumm Subarray Sum using Optimal : " + optimal);
        sc.close();
    }
}