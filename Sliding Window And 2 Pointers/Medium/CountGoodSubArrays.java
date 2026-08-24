import java.util.*;
class CountGoodSubArrays
{
    static int brute(int[] nums , int K) //tc O(n^2) //sc O(1)
    {
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            int oddCount = 0;
            for(int j = i ; j < nums.length ; j++)
            {
                if(nums[j] % 2 == 1)
                {
                    oddCount++;
                }
                if(oddCount == K)
                {
                    count++;
                }
            }
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
        int sum = 0; // here sum in not exactly array elements sum it is denoting the count of odd numbers in array
        int count = 0;
        for(int r = 0 ; r < nums.length ; r++)
        {
            sum += (nums[r] % 2);
            while(sum > K)
            {
                sum -= (nums[l] % 2);
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
        int result3 = optimal(nums, k);
        System.out.println("The  number of Good Subarrays are : BRUTE : " + result1);
        System.out.println("The  number of Good Subarrays are : OPTIMAL : " + result3);
        sc.close();
    }
}
