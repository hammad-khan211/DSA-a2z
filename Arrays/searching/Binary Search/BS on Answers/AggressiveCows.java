import java.util.*;
class AggressiveCows
{
    static int findDistance(int[] nums , int cows) //tc O(n log(n) + n log(max - min))
    {
        Arrays.sort(nums);
        int low = 1;
        int high = nums[nums.length - 1] - nums[0];
        while(low <= high)
        {
            int mid = low + ((high - low) / 2);
            if(isValidDistance(nums , cows , mid))
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return high;
    }

    static boolean isValidDistance(int[] nums , int cows , int d)
    {
        int cowCount = 1;
        int last = nums[0];
        for(int i = 1 ; i < nums.length ; i++)
        {
            if(nums[i] - last >= d)
            {
                cowCount++;
                last = nums[i];
            }
        }
        if(cowCount >= cows) return true;
        return false;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of stalls : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the number of each stall : ");
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the number of cows : ");
        int c = sc.nextInt();
        int ans = findDistance(arr, c);
        System.out.println("The minimum distance between " + c + " cows is maximum at : " + ans);
        sc.close();

    }   
}