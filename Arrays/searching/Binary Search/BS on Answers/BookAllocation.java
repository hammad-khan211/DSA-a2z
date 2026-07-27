import java.util.*;
class BookAllocation
{
    static int findMinPages(int[] nums , int student) //tc O(n log (sum - max))
    {
        if(student > nums.length) return -1;
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
            if(isMinPages(nums , student , mid))
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
    static boolean isMinPages(int[] nums , int student , int pages)
    {
        int s = 1;
        int currentPages = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(currentPages + nums[i] <= pages)
            {
                currentPages += nums[i];
            }
            else
            {
                s++;
                currentPages = nums[i];
            }
        }
        return s <= student;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of books : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the number pages of each book : ");
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the number of students : ");
        int s = sc.nextInt();
        int ans = findMinPages(arr, s);
        System.out.println("The maximum pages allocated to " + s + " students is minimum at : " + ans);
        sc.close();

    }   
}