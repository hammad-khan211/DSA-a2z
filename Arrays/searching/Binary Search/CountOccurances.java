import java.util.*;
class CountOccurances
{
    static int[] findOccurances(int[] nums , int target)
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

    static int count(int[] nums , int target) //tc O(log n)
    {
        int[] occur = findOccurances(nums, target);
        if(occur[0] != -1)
        {
            return occur[1] - occur[0] + 1;
        }
        return 0;
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
        int ans = count(arr, t);
        System.out.println(t + " occurs " + ans + " times");
        sc.close();

    }
}