import java.util.*;
class MinimumInRotatedSortedArray
{
    static int findMinimum(int[] nums) //tc O(logg n) sc O(1)
    {
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high)
        {
            int mid = low + ((high - low) / 2);
            if(nums[low] <= nums[high])
            {
                min = Math.min(min , nums[low]);
                break;
            }
   
            if(nums[low] <= nums[mid])
            {
                min = Math.min(min , nums[low]);
                low = mid + 1;
            }
            else
            {
                min = Math.min(min , nums[mid]);
                high = mid - 1;
            }
        }
        return min;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the " + n + " number of array elements in sorted order  : ");
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt();
        }
        int ans = findMinimum(arr);
        System.out.println("The minimum element is : " + ans);
        sc.close();
    }
}