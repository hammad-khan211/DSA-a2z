import java.util.*;
class UpperBound // upper boound is index of element which is strictly greater than target
{
    static int findUpperBound(int[] nums , int target)
    {
        int ans = nums.length;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high)
        {
            int mid = low + ((high - low) / 2);
            if(nums[mid] <= target)
            {
                low = mid + 1;
            }
            else
            {
                ans = mid;
                high = mid -1;
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
        System.out.println("Enter the target to find the upper bound : ");
        int t = sc.nextInt();
        int ans = findUpperBound(arr , t);
        if(ans == n)
        {
            System.out.println("No upper bound exists !");
        }
        else
        {
            System.out.println("The upper bound is at index : " + ans);
        }
        sc.close(); 
    }
}