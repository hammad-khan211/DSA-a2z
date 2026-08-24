import java.util.*;
class MaxPointsFromCards
{
    static int optimal(int[] nums , int k) //tc O(2k) sc O(1)
    {
        int lsum = 0;
        for(int l = 0 ; l < k ; l++)
        {
            lsum += nums[l];
        }
        int maxSum = lsum;
        int r = nums.length - 1;
        int rsum = 0;
        for(int l = k - 1; l >= 0 ; l--)
        {
            lsum -= nums[l];
            rsum += nums[r];
            maxSum = Math.max(maxSum , lsum + rsum);
            r--;
        }
        return maxSum;
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
        int result1 = optimal(nums, k);
        System.out.println("Max Score : " + result1);
        sc.close();
    }    
}
