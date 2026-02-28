import java.util.*;
class LeadersofArray //Leader are those elements of array whose all elements on the right hand sode are smaller 
{
    static void printLeadersBrute(int[] nums) //Time O(n^2) Space O(1)
    {
        int n = nums.length;
        for(int i = 0 ; i < n ; i++)
        {
            boolean leader = true;
            for(int j = i + 1 ; j < n ; j++)
            {
                if(nums[j] >= nums[i]) leader = false;
            }
            if(leader) System.out.print(nums[i] + " ");            
        }
    }

    static void printLeadersOptimal(int[] nums) //Time O(n) Space O(1)
    {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = n - 1 ; i >= 0 ; i--)
        {
            if(nums[i] > max)
            {
                max = nums[i];
                System.out.print(nums[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the "  + n + " number of array elements : ");
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("The leaders of arrays are given as : ");
        printLeadersOptimal(arr);
    }
}