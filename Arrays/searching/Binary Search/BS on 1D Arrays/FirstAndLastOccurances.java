import java.util.*;
class FirstAndLastOccurances
{
    static int[] brute(int[] nums , int target) //tc O(n) sc O(1)
    {
        int first = -1;
        int last = -1;
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(nums[i] == target)
            {
                if(first == -1)
                {
                    first = i;
                }
                last = i;
            }
        }
        return new int[]{first , last};
    }

    static int[] optimal1(int[] nums , int target) //tc O(log (base 2) n) sc O(1)
    {
        int lb = findLowerBound(nums, target);
        if(lb == nums.length || nums[lb] != target)
        {
            return new int[]{-1 , -1};
        }
        int ub = findUpperBound(nums, target);
        return new int[]{lb , ub - 1};
    }

    static int findLowerBound(int[] nums , int target)
    {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high)
        {
            int mid = low + ((high - low) / 2);
            if(nums[mid] >= target)
            {
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }

    static int findUpperBound(int[] nums , int target)
    {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high)
        {
            int mid = low + ((high - low) / 2);
            if(nums[mid] > target)
            {
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }

    static int[] optimal2(int[] nums , int target)
    {
        int low1 = 0;
        int high1 = nums.length - 1;
        while(low1 <= high1)
        {
            int mid1 = low1 + ((high1 - low1) / 2);
            if(nums[mid1] >= target)
            {
                high1 = mid1 - 1;
            }
            else
            {
                low1 = mid1 + 1;
            }
        }

        if(low1 == nums.length || nums[low1] != target) return new int[]{-1 , -1};

        int low2 = 0;
        int high2 = nums.length - 1;
        while(low2 <= high2)
        {
            int mid2 = low2 + ((high2 - low2) / 2);
            if(nums[mid2] <= target)
            {
                low2 = mid2 + 1;
            }
            else
            {
                high2 = mid2 - 1;
            }
        }

        return new int[]{low1 , high2};

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
        System.out.println("Enter the target : ");
        int t = sc.nextInt();
        int[] ans = optimal2(arr, t);
        System.out.println("First Occurance of " + t + " : " + ans[0]);
        System.out.println("Last Occurance of " + t + " : " + ans[1]);
        sc.close();

    }
}