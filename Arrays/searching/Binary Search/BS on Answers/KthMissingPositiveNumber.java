import java.util.*;
class KthMissingPositiveNumber //lc1539
{
    static int brute(int[] nums , int k) // tc O(n) linear search
    {
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(nums[i] <= k) k++;
            else break;
        }
        return k;
    }

    static int optimal(int[] nums , int k) // tc O(log n) binary search
    {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high)
        {
            int mid = low + ((high - low) / 2);
            int missing = nums[mid] - (mid + 1);
            if(missing < k)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return low + k;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the " + n + " number of arrays : ");
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the value of k : ");
        int k = sc.nextInt();
        int ans = optimal(arr , k);
        System.out.println(k + " th " + " missing number is : " + ans);
        sc.close();

    }  
}