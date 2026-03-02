import java.util.*;
class NextPermutation
{
    static void reverse(int[] nums , int i , int j)
    {
        while(i < j)
        {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    static int[] findNextPermutationOptimal(int[] nums) //Time COmplexity O(n) Space Complexity O(1)
    {
        int n = nums.length;
        int breakPoint = -1;

        //step1. find the last breaking point
        for(int i = n - 1 ; i >= 1 ; i--)
        {
            if(nums[i - 1] < nums[i])
            {
                breakPoint = i - 1;
                break;
            }
        }
        //step.2 check if the array is not already the largest premutation
        if(breakPoint != -1)
        {
            //if not then do the following
            for(int i = n - 1 ; i > breakPoint ; i--)
            {
                //replace the breakPoint element with a element greater than breakPoint but the samllest among the rest of them
                if(nums[i] > nums[breakPoint])
                {
                    int temp = nums[i];
                    nums[i] = nums[breakPoint];
                    nums[breakPoint] = temp;
                    break;
                }
            }
            //after that sort the remaining element by reversing them
            reverse(nums, breakPoint + 1 , n - 1);
        }
        else
        //if array is the largest permutation
        {
            //get the smallest permutation by reversing
            reverse(nums , 0 , n - 1);
            return nums;
        }
        return nums;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the "  + n + " number of array elements : ");
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt();
        }
        int[] ans = findNextPermutationOptimal(arr);
        System.out.println("The next permutation is given as : ");
        for(int x : ans)
        {
            System.out.print(x + " ");
        }


    }

}