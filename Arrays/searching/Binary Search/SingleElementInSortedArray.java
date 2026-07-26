import java.util.*;
class SingleElementInSortedArray //lc540
{
    static int findSingle(int[] nums) //tc O(n) sc O(1)
    {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n - 1] != nums[n - 2]) return nums[n - 1];
        int low = 1;
        int high = n - 2;
        while(low <= high)
        {
            int mid = low + ((high - low) / 2);
            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
            {
                return nums[mid];
            }
            if((mid % 2 == 1 && nums[mid - 1] == nums[mid]) || (mid % 2 == 0 && nums[mid + 1] == nums[mid]))
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
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
        System.out.println("Enter the " + n + " number of array elements in sorted order  : ");
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt();
        }
        int ans = findSingle(arr);
        if(ans != -1)
        {
            System.out.println("The single element is : " + ans);
        }
        else{
            System.out.println("Single Element not found");
        }
        sc.close();
    }
}