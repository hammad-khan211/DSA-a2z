import java.util.*;
class MaximumProductSubArray
{
    static int brtueMaxProduct(int[] nums) //Time Complexity : O(n^2) Space COmplexity : O(1)
    {
        int maxProduct = nums[0];
        for(int i = 0 ; i < nums.length ; i++)
        {
            int product = 1;
            for(int j = i ; j < nums.length ; j++)
            {
                product *= nums[j];
                maxProduct = Math.max(maxProduct , product);
            }
        }
        return maxProduct;
    }

    static int optimal1MaxProduct(int[] nums) //Time Complexity : O(n) Space Complexity : O(1)
    {
        int ans = Integer.MIN_VALUE;
        int pref = 1;
        int suff = 1;
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(pref == 0) pref = 1;
            if(suff == 0) suff = 1;

            pref *= nums[i];
            suff *= nums[nums.length - i - 1];

            ans = Math.max(ans , Math.max(pref , suff));
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the " + n + " number of array elements : ");
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt();
        }
        int ans = optimal1MaxProduct(arr);
        System.out.print("Maximum Subarray Product of the Array is : " + ans);
    }
}