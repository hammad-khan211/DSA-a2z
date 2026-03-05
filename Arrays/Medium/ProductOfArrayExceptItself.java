import java.util.*;
class ProductOfArrayExceptItself
{
    static int[] brute(int[] nums)//Time Complexity O(n^2) Space Complexity O(n)
    {
        int n = nums.length;
        int[] result = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            int product = 1;
            for(int j = 0 ; j < n ; j++)
            {
                if(i != j)
                {
                    product *= nums[j];
                }
            }
            result[i] = product;
        }
        return result;
    }

    static int[] better(int[] nums)//Time COmplexity O(n) Space O(n)
    {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] result = new int[n];
        prefix[0] = 1;
        for(int i = 1 ; i < n ; i++)
        {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        suffix[n - 1] = 1;
        for(int i = n - 2 ; i >= 0 ; i--)
        {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        for(int i = 0 ; i < n ; i++)
        {
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }

    static int[] optimal(int[] nums)//Time COmplexity O(n) Space O(1)
    {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for(int i = 1 ; i < n ; i++)
        {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int suffix = 1;
        for(int i = n - 1 ; i >= 0 ; i--)
        {
            result[i] *= suffix;
            suffix *= nums[i];
        }
        return result;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the " + size + " number of array elements : ");
        for(int i = 0 ; i < size ; i++)
        {
            arr[i] = sc.nextInt();
        }
        int[] bruteAns = brute(arr);
        int[] betterAns = better(arr);
        int[] OptimalAns = optimal(arr);
        System.out.println("Brute Solution : ");
        for(int X : bruteAns)
        {
            System.out.print(X + " ");
        }
        System.out.println("");
        System.out.println("Better Solution : ");
        for(int Y : betterAns)
        {
            System.out.print(Y + " ");
        }
        System.out.println("");
        System.out.println("Optimal Solution : ");
        for(int Z : OptimalAns)
        {
            System.out.print(Z + " ");
        }
    }
}