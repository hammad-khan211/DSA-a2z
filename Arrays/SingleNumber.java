// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
// You must implement a solution with a linear runtime complexity and use only constant extra space.
// Example 1:

// Input: nums = [2,2,1]
// Output: 1

// Example 2:

// Input: nums = [4,1,2,1,2]
// Output: 4

// Example 3:

// Input: nums = [1]
// Output: 1


import java.util.*;
class SingleNumber
{
    static int singleNumberBrute(int[] arr)  //time O(N^2) space O(1)
    {
        int N = arr.length;
        for(int i = 0 ; i < N ; i++)
        {
            boolean found = false;
            for(int j = 0 ; j < N ; j++)
            {
                if(i != j && arr[i] == arr[j])
                {
                        found = true;
                        break;
                }
                
            }
            if(!found) return arr[i];  
        }
        return -1;
    }

    static int singleNumberHashBetter(int[] arr)  //hashing (only small positive numbers ) time O(N)  space O(N)
    {
        int N = arr.length;
        int max = arr[0];
        for(int i = 1 ; i < N ; i++)
        {
            if(arr[i] > max) max = arr[i];  //finding max element to determine the size of hash array
        }
        int[] hash = new int[max + 1];
        for(int i = 0 ; i < N ; i++)  //precomputing
        {
            hash[arr[i]] += 1;
        }
        for(int x : arr)
        {
            if(hash[x] == 1) return x;
        }
        return -1;
    }
    static int singleNumberHashMapBetter(int[] arr) //using hashmap (for both positive and negative numbers )//time O(N)  space O(N)
    {
        int N = arr.length;
       
        HashMap  < Integer , Integer > mpp = new HashMap<>();
        for(int i = 0 ; i < N ; i++)  //precomputing
        {
            mpp.put(arr[i] , mpp.getOrDefault(arr[i] , 0) + 1);
        }
        for( Map.Entry < Integer , Integer > entry : mpp.entrySet())
        {
            if(entry.getValue() == 1) return entry.getKey();
        }
        return -1;
    }

    static int singleNumberOptimal(int[] arr)  //using bit manipulation by XOR Time O(N) Space O(1)
    {
        int xor = 0;
        for(int x : arr)
        {
            xor ^= x;
        }
        return xor;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter the " + size + " number of array elements : ");
        for(int i = 0 ; i < size ; i++)
        {
            nums[i] = sc.nextInt();
        }
        int result = singleNumberOptimal(nums);
        if(result != -1)
        {
            System.out.println("Brute : " + singleNumberBrute(nums));
            System.out.println("Array Hash : " + singleNumberHashBetter(nums));
            System.out.println("HashMap : " + singleNumberHashMapBetter(nums));
            System.out.println("Optimal XOR : " + singleNumberOptimal(nums));
        }
        sc.close();
    }
}
 