import java.util.*;
class FloorAndCeil
{
    static int findFloor(int[] nums , int target) //tc O(log base(2) n) sc O(1)
    {
        int ans = -1;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high)
        {
            int mid = low + ((high - low) / 2);
            if(nums[mid] <= target)
            {
                ans = nums[mid];
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return ans;
    }

    static int findCeil(int[] nums , int target)
    {
        int ans = -1;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high)
        {
            int mid = low + ((high - low) / 2);
            if(nums[mid] >= target)
            {
                ans = nums[mid];
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
        System.out.println("Enter the target to find the floor and Ceil value : ");
        int t = sc.nextInt();
        int floor = findFloor(arr , t);
        int ceil = findCeil(arr , t);
        if(floor != -1)
        {
            System.out.println("Floor Value for given target : " + floor);
        }
        else
        {
            System.out.println("Floor value doesnt exist for this target");
        }
        if(ceil != -1)
        {
            System.out.println("Ceil Value for given target : " + ceil);
        }
        else
        {
            System.out.println("Ceil value doesnt exist for this target");
        }
        sc.close();
    }
}