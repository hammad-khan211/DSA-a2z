import java.util.*;
class LongestSubarrayWithSumK
{
    static int longestSubarrayWithSumKBrute(int[] arr , int K)  //Time O(N^2)  //Space O(1)
    {
        int maxL = 0;
        int N = arr.length;
        for(int i = 0 ; i < N ; i++)
        {
            int sum = 0;
            for(int j = i ; j < N ; j++)
            {
                sum += arr[j];
                if(sum == K)
                {
                    int len = j - i + 1;
                    maxL = Math.max(maxL , len);
                }
            }
        }
        return maxL;
    }

    static int longestSubarrayWithSumKOptimal(int[] arr , int K)  //Time O(N) // Space O(N)
    {
        HashMap < Integer , Integer > mpp = new HashMap<>();
        int n = arr.length;
        int maxLength = 0;
        int sum = 0;
        for(int i = 0 ; i < n ; i++)
        {
            sum += arr[i];  //prefix sum 

            if(sum == K) // subarray from index 0 
            {
                maxLength = i + 1;
            }

            if(mpp.containsKey(sum - K)) //if any previous prefix sum exists x-k such that total x - (x - k) = k
            {
                int length = i - mpp.get(sum - K);
                maxLength = Math.max(length , maxLength);
            }

            if(!mpp.containsKey(sum)) //storing new sums in map
            {
                mpp.put(sum , i);
            }
        }
        return maxLength;
    } 
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter the " + size + " number of array elements : ");
        for(int i = 0 ; i < size ; i++)
        {
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter the value of K : ");
        int k = sc.nextInt();
        int result = longestSubarrayWithSumKOptimal(nums, k);
        System.out.println("The Longest subarray with sum " + k + " is of length : " + result);
        sc.close();
    }

}