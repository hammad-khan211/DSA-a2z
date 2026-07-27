import java.util.*;
class SearchInRotatedSortedArray
{
    static int search(int[] nums , int target) //tc O(log n) sc O(1)
    {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high)
        {
            int mid = low + ((high - low) / 2);
            if(nums[mid] == target)
            {
                return mid;
            }
            //search for sorted half
            if(nums[low] <= nums[mid]) //left half is sorted
            {
                if(nums[low] <= target && target <= nums[mid])
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }
            }
            else // right half is sorted
            {
                if(nums[mid] <= target && target <= nums[high])
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the " + n + " number of rotated sorted array elements : ");
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the target to be searched : ");
        int t = sc.nextInt();
        int ans = search(arr , t);
        if(ans != -1)
        {
            System.out.println("The target element is located at : " + ans + " array position");
        }
        else{
            System.out.println("Element not found");
        }
        sc.close();

    }
}