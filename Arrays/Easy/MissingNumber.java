// You are given an array arr[] of size n - 1 that contains distinct integers in the range from 1 to n (inclusive).
//  This array represents a permutation of the integers from 1 to n with one element missing. 
//  Your task is to identify and return the missing element.

// Examples:

// Input: arr[] = [1, 2, 3, 5]
// Output: 4
// Explanation: All the numbers from 1 to 5 are present except 4.

// Input: arr[] = [8, 2, 4, 5, 3, 7, 1]
// Output: 6
// Explanation: All the numbers from 1 to 8 are present except 6.

// Input: arr[] = [1]
// Output: 2
// Explanation: Only 1 is present so the missing element is 2.
import java.util.Scanner;
class MissingNumber
{

    static int missingNumberBrute(int[] arr)//by nested loops // time O(N^2) // space O(1)
    {
        int N = arr.length + 1;
        for(int i = 1 ; i <= N ; i++)
        {
            boolean found = false;
            for(int j = 0 ; j < arr.length ; j++)
            {
                if(arr[j] == i)
                {
                    found = true;
                    break;
                }
            }
            if(!found) return i;
        }
        return -1;
    }

    static int missingNumberBetter(int[] arr)  //by hashing
     //timeO(N) space O(N)
    {
        int N = arr.length + 1;
        int[] hash = new int[N + 1];  //precomputing
        for(int i = 0 ; i < arr.length ; i++ )
        {
            hash[arr[i]] += 1;
        }
        for(int i = 1 ; i <= N ; i++)
        {
            if(hash[i] != 1)
            {
                return i;
            }
        }
        return -1;
    }

    static int missingNumberOptimal(int[] arr) // by mathematic formula of ap series sum
    {
        int N = arr.length + 1;                              //time O(N) space O(1)
        long expectedSum = (long)N * (N + 1) / 2;             
        long actualSum = 0;
        for(int x : arr)
        {
            actualSum += x;
        }
        return (int)(expectedSum - actualSum);
    }

    static int missingNumberMostOptimal(int[] arr) //by bit manipulation  ..time O(N)  space O(1)
    {
        int xor1 = 0;
        int xor2 = 0;
        for(int x : arr){
            xor1 ^= x;
        }
        for(int i = 1 ; i <= arr.length + 1 ; i++)
        {
            xor2 ^= i;
        }
        return xor1 ^ xor2;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter the " + size + " number of array elements in the range 1 to " + (size+1) + " : ");
        for(int i = 0 ; i < size ; i++)
        {
            nums[i] = sc.nextInt();
        }
        int result = missingNumberMostOptimal(nums);
        System.out.println("The missing element is : " + result);
        sc.close();
        
    }
}