// Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place
//  such that each unique element appears only once. 
// The relative order of the elements should be kept the same.
// Consider the number of unique elements in nums to be k​​​​​​​​​​​​​​. After removing duplicates, return the number of unique elements k.
// The first k elements of nums should contain the unique numbers in sorted order.
//  The remaining elements beyond index k - 1 can be ignored.
import java.util.*;
class RemoveDuplicates{

    //Brute Force Approach 
    static int RemoveTheDuplicates(int[] arr)
    {
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < arr.length ; i++)
        {
            set.add(arr[i]);
        }

        return set.size();
    }

    //Optimal Approah  for sorted array using 2 pointers;
    static int RemoveDuplicate(int[] arr)
    {
        int i = 0;
        for(int j = 1 ; j < arr.length ; j++)
        {
            if(arr[j] != arr[i])
            {
                arr[i + 1] = arr[j];
                i++;
            }
        }
        
        return i+1;
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
        int result = RemoveDuplicate(nums);
        System.out.println("Number of unique elements : " + result);
    } 
}