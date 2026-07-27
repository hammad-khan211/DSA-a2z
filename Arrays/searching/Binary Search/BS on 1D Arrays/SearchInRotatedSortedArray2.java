import java.util.*;
class SearchInRotatedSortedArray2
{
    static boolean search(int[] nums , int target) //tc O(log n)
    {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high)
        {
            int mid = low + ((high - low) / 2);
            if(nums[mid] == target) return true;

            //edge case for finding sorted half
            if(nums[low] == nums[mid] && nums[mid] == nums[high])
            {
                low++;
                high--;
                continue;
            }
            //now check sorted half
            if(nums[low] <= nums[mid]) //means left half is sorted
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
            else //means right half is sorted
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
        return false;
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
        if(search(arr , t))
        {
            System.out.println("The target element is present in array");
        }
        else{
            System.out.println("Element not found");
        }
        sc.close();

    }
}