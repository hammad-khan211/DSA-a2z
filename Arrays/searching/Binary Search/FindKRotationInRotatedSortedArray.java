import java.util.*;
class FindKRotationInRotatedSortedArray
{
    static int findKRotation(int[] nums)
    {
        int min = Integer.MAX_VALUE;
        int index = -1;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high)
        {
            int mid = low + ((high - low) / 2);

            if(nums[low] <= nums[high])
            {
                if(nums[low] < min)
                {
                    min = nums[low];
                    index = low;
                }
                break;
            }


            if(nums[low] <= nums[mid])
            {
                if(nums[low] < min)
                {
                    index = low;
                    min = nums[low];
                }
                low = mid + 1;
            }
            else
            {
                if(nums[mid] < min)
                {
                    index = mid;
                    min = nums[mid];
                }
                high = mid - 1;
            }
        }
        return index;
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
        int ans = findKRotation(arr);
        System.out.println("The number of rotations are  : " + ans);
        sc.close();
    }
}