import java.util.*;
class BinarySearch
{
    static int normalBinarySearch(int[] nums , int target) //Time O(log n)
    {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high)
        {
            int mid = low + (( high - low ) / 2);        
            if(nums[mid] == target)
            {
                return mid;   
            }
            else if(target < nums[mid])
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return -1;
    }

    static int recursiveBinarySearch(int[] nums , int start , int end  , int target)
    {
        if(start > end) return -1;

        int mid = start + ((end - start) / 2);
        if(nums[mid] == target) return mid;
        else if(target < nums[mid])
        {
            return recursiveBinarySearch(nums , start , mid - 1 , target);
        }
        else
        {
            return recursiveBinarySearch(nums, mid + 1 , end , target);
        }
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
        System.out.println("Enter the target to be searched : ");
        int t = sc.nextInt();
        int ans = recursiveBinarySearch(arr , 0 , n - 1 , t);
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