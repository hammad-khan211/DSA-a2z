import java.util.*;
class CountBinarySubArrayWithSumK
{
    static int brute(int[] nums , int K) //tc O(n^2) //scO(1)
    {
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            int sum = 0;
            for(int j = i ; j < nums.length ; j++)
            {
                sum += nums[j];
                if(sum == K) count++;
            }
        }
        return count;
    }    

    static int better(int[] nums , int K) //tc O(N) scO(n)
    {
        HashMap < Integer , Integer > mpp = new HashMap<>(); //sum : frequency
        int count = 0;
        int sum = 0;
        mpp.put(0 , 1);
        for(int i = 0 ; i < nums.length ; i++)
        {
            sum += nums[i];
            count += mpp.getOrDefault(sum - K , 0);
            mpp.put(sum , mpp.getOrDefault(sum , 0) + 1);
        }
        return count;
    }

    static int optimal(int[] nums , int K) //tc O(n) sc O(1)
    {
        return solve(nums , K) - solve(nums , K - 1);
    }

    static int solve(int[] nums , int K) //count subarray <= K using SD + 2P
    {
        if(K < 0) return 0;
        int l = 0;
        int sum = 0;
        int count = 0;
        for(int r = 0 ; r < nums.length ; r++)
        {
            sum += nums[r];
            while(sum > K)
            {
                sum -= nums[l];
                l++;
            }
            count += (r - l + 1);
        }
        return count;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter the " + size + " number of binary array elements : ");
        for(int i = 0 ; i < size ; i++)
        {
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter the value of K : ");
        int k = sc.nextInt();
        int result1 = brute(nums, k);
        int result2 = better(nums, k);
        int result3 = optimal(nums, k);
        System.out.println("The  number of subarrays with sum " + k + " are : BRUTE : " + result1);
        System.out.println("The  number of subarrays with sum " + k + " are : BETTER : " + result2);
        System.out.println("The  number of subarrays with sum " + k + " are : OPTIMAL : " + result3);
        sc.close();
    }
}
