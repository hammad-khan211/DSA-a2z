import java.util.*;
class MaxConsecutiveOnes //find max length subarray of consecutive ones if you can flip at most k zeroes 
{
    static int brute(int[] nums , int k) //tc O(n^2) sc O(1)
    {
        int maxLen = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            int zero = 0;
            for(int j = i ; j < nums.length ; j++)
            {
                if(nums[j] == 0) zero++;
                if(zero <= k)
                {
                    maxLen = Math.max(maxLen , j - i + 1);
                }
                else
                {
                    break;
                }
            }
        }
        return maxLen;
    }

    static int optimal(int[] nums , int k) //tc O(n) sc O(1)
    {
        int l = 0;
        int maxLen = 0;
        int zero = 0;
        for(int r = 0 ; r < nums.length ; r++)
        {
            if(nums[r] == 0)
            {
                zero++;
            }
            if(zero <= k)
            {
                maxLen = Math.max(maxLen , r - l + 1);
            }
            else
            {
                while(nums[l] != 0)
                {
                    l++;
                }
                l++;
                zero--;
            }
        }
        return maxLen;
    }
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size : ");
        int size = sc.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter " + size + " array elements : ");
        for(int i = 0 ; i < nums.length ; i++)
        {
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter K : ");
        int k = sc.nextInt();
        int ans = optimal(nums, k);
        System.out.println("Longest SubArray of consecutive ones after flipping at most " + k + " zeros are : " + ans);
        sc.close();
    }
}
