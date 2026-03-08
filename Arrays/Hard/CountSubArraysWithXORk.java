import java.util.*;
class CountSubArraysWithXORk
{
    static int countBrute(int[] nums , int target) //Time Complexity O(n^2) Space Complexity O(1)
    {
        int count = 0;
        int n = nums.length;
        for(int i = 0 ; i < n ; i++)
        {
            int xor = 0;
            for(int j = i ; j < n ; j++)
            {
                xor ^= nums[j];
                if(xor == target)
                {
                    count++;
                }
            }
        }
        return count;
    }

    static int countOptimal(int[] nums , int target) //Time COmplexity O(n) Space O(n)
    {
        int n = nums.length;
        HashMap < Integer , Integer > prefixXor  = new HashMap<>();
        prefixXor.put(0 , 1);
        int count = 0;
        int xr = 0;
        for(int i = 0 ; i < n ; i++)
        {
            xr ^= nums[i];
            int x = xr ^ target;    

            if(prefixXor.containsKey(x))
            {
                count += prefixXor.get(x);
            }

            prefixXor.put(xr , prefixXor.getOrDefault(xr , 0) + 1);

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
        int result = countOptimal(nums, k);
        System.out.println("The  number of subarrays with xor " + k + " are : " + result);
        sc.close();
    }
}