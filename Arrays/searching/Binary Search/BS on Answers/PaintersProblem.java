import java.util.*;
class PaintersProblem //lc410
{
    static boolean isValidTime(int[] nums , int k , int t)
    {
        int currentTime = 0;
        int painters = 1;
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(currentTime + nums[i] <= t)
            {
                currentTime += nums[i];
            }
            else
            {
                painters++;
                currentTime = nums[i];
            }
        }
        return painters <= k;
    }
    static int findMinTime(int[] nums , int k) //tc O(n log (sum - max))
    {
        int max = nums[0];
        int sum = 0;
        for(int x : nums)
        {
            max = Math.max(max , x);
            sum += x;
        }
        int low = max;
        int high = sum;
        while(low <= high)
        {
            int mid = low + ((high - low) / 2);
            if(isValidTime(nums , k , mid))
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

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of boards to be painted : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the length of each board : ");
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the number of painters : ");
        int p = sc.nextInt();
        int ans = findMinTime(arr, p);
        System.out.println("The maximum time taken to paint all boards by " + p + " painters is minimum at : " + ans);
        sc.close();

    } 
}