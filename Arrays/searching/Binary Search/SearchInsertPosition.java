import java.util.*;
class SearchInsertPosition
{
    static int searchPos(int[] nums , int target)
    {
        int ans = nums.length;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high)
        {
            int mid = low + ((high - low) / 2);
            if(nums[mid] >= target)
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return ans;
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
        System.out.println("Enter the target to find its search insert position : ");
        int t = sc.nextInt();
        int ans = searchPos(arr, t);
        if(ans < n && arr[ans] == t)
        {
            System.out.println("Target element " + t + " found at index : " + ans);
        }
        else
        {
            System.out.println("Element not found");
            System.out.println("It should have been inserted at index : " + ans);
        }
        sc.close();

    }
}