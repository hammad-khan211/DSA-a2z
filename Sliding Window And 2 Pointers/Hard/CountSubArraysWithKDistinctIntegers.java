import java.util.*;
class CountSubArraysWithKDistinctIntegers
{
    static int brute(int[] nums , int k) //tc O(n^2) sc O(n)
    {
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            Set < Integer > set = new HashSet<>();
            for(int j = i ; j < nums.length ; j++)
            {
                set.add(nums[j]);
                if(set.size() == k)
                {
                    count++;
                }
                else if(set.size() > k)
                {
                    break;
                }
            }
        }
        return count;
    }    

    static int optimal(int[] nums , int k) //tc O(n) sc O(n)
    {
        return atMost(nums , k) - atMost(nums , k - 1);
    }

    static int atMost(int[] nums , int k)
    {
        if(k <= 0) return 0;
        int count = 0;
        int l = 0;
        HashMap < Integer , Integer > mpp = new HashMap<>();
        for(int r = 0 ; r < nums.length ; r++)
        {
            mpp.put(nums[r] , mpp.getOrDefault(nums[r] , 0) + 1);
            while(mpp.size() > k)
            {
                mpp.put(nums[l] , mpp.get(nums[l]) - 1);
                if(mpp.get(nums[l]) == 0)
                {
                    mpp.remove(nums[l]);
                }
                l++;
            }
            count += (r - l + 1);
        }
        return count;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter the " + size + " number of binary array elements : ");
        for(int i = 0 ; i < size ; i++)
        {
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter the value of K : ");
        int k = sc.nextInt();
        int result1 = brute(nums, k);
        int result3 = optimal(nums, k);
        System.out.println("The  number of subarrays with EXACTLY " + k + " DISTINCT integers are : BRUTE : " + result1);
        System.out.println("The  number of subarrays with EXACTLY " + k + " DISTINCT integers are : OPTIMAL : " + result3);
        sc.close();
    }
}
