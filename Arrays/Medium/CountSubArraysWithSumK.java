import java.util.*;
class CountSubArraysWithSumK
{
    static int countSubArraysBrute(int[] arr , int K) //Time O(n^2) // Space O(1)
    {
        int count = 0;
        int n = arr.length;
        for(int i = 0 ; i < n ; i++)
        {
            int sum = 0;
            for(int j = i ; j < n ; j++)
            {
                sum += arr[j];
                if(sum == K)
                {
                    count++;
                }
            }
        }
        return count;
    }

    static int countSubArraysOptimal(int[] arr , int K) // time O(n) , space O(n)
    {
        int n = arr.length;
        int count = 0;
        HashMap < Integer , Integer > prefixSum = new HashMap<>();
        prefixSum.put(0 , 1);  //sum : frequency
        int sum = 0;
        for(int i = 0 ; i < n ; i++)
        {
            sum += arr[i];
            
            count += prefixSum.getOrDefault(sum - K , 0);

            prefixSum.put(sum , prefixSum.getOrDefault(sum , 0) + 1);
        }
        return count;
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
        int result = countSubArraysOptimal(nums, k);
        System.out.println("The  number of subarrays with sum " + k + " are : " + result);
        sc.close();
    }
    }
