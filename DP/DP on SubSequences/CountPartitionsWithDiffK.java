import java.util.Scanner;

class CountPartitionsWithDiffK
{
    static int countPartitions(int[] nums , int k)
    {
        int tSum = 0;
        for(int x : nums)
        {
            tSum += x;
        }
        if(tSum - k < 0 || (tSum - k) % 2 == 1)
        {
            return 0;
        }
        return spaceOptimizedTabulation(nums , (tSum - k) / 2);
    }    

    static int spaceOptimizedTabulation(int[] nums , int target)
    {
        int[] prev = new int[target + 1];
        prev[0] = 0;
        if(nums[0] == 0)
        {
            prev[0] = 2;
        }
        else
        {
            prev[0] = 1;
        }
        if(nums[0] != 0 && nums[0] <= target)
        {
            prev[nums[0]] = 1;
        }
        for(int i = 1 ; i < nums.length ; i++)
        {
            int[] temp = new int[target + 1];
            for(int j = 0 ; j <= target ; j++)
            {
                int take = 0;
                int nottake = prev[j];
                if(nums[i] <= j)
                {
                    take = prev[j - nums[i]];
                }
                temp[j] = take + nottake;
            }
            prev = temp;
        }
        return prev[target];
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " number of array elements : ");
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter k : ");
        int k = sc.nextInt();
        int ans = countPartitions(arr, k);
        System.out.println("TOTAL POSSIBLE PARTITIONS OF ARRAY IN S1 AND S2 SUBSETS SUCH THAT SUM OF S1 >= S2 IS => " +  ans);
    }
}
