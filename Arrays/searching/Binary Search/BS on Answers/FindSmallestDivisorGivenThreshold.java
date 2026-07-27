import java.util.*;
class FindSmallestDivisorGivenThreshold //lc1283
{
    static int findSmallestDivisor(int[] nums , int threshold)//tc O(n log(max))
    {
        int max = nums[0];
        for(int num : nums)
        {
            max = Math.max(max , num);
        }
        int low = 1;
        int high = max;
        while(low <= high)
        {
            int mid = low + ((high - low) / 2);
            if(isValidDivisor(nums , threshold , mid))
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return low;
    }

    static boolean isValidDivisor(int[] nums , int threshold , int d)
    {
        int sum = 0;
        for(int num : nums)
        {
            sum += (num + d - 1) / d;
        }
        return sum <= threshold;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements : ");
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the threshold value : ");
        int t = sc.nextInt();
        int ans = findSmallestDivisor(arr, t);
        System.out.println("Smallest Divisor : " + ans);

        sc.close();

    }   
}