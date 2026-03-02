import java.util.*;
class MajorityElement
{
    static int majorityElementBrute(int[] nums) //Time O(n^2) Space O(1)
    {
        int n = nums.length;
        int maxCount = 0;
        for(int i = 0 ; i < n ; i++)
        {
            int count = 0;
            for(int j = 0 ; j < n ; j++)
            {
                if(nums[i] == nums[j])
                {
                    count++;
                }
                if(count > n / 2) return nums[i];
            }
        }
        return -1;
    }
    static int majorityElementBetter1(int[] nums) //Time O(n log n) //Space O(1)
    {
        Arrays.sort(nums);
        int count = 1;
        if(nums.length == 1) return nums[0];
        for(int i = 1 ; i < nums.length ; i++)
        {
            if(nums[i - 1] == nums[i])
            {
                count++;
            }
            else{
                count = 1;
            }
            if(count > nums.length / 2) return nums[i];
        }
        return -1;
    }

    static int majorityElementBetter2(int[] nums) //Time O(n) //space O(n)
    {
        int n = nums.length;
        HashMap < Integer , Integer > mpp = new HashMap<>();
        for(int i = 0 ; i < n ; i++)
        {
            mpp.put(nums[i] , mpp.getOrDefault(nums[i] , 0) + 1);
        }
        for(Map.Entry < Integer , Integer > entry : mpp.entrySet())
        {
            if(entry.getValue() > n / 2)
            {
                return entry.getKey();
            }
        }
        return -1;
    }

    static int majorityElementOptimal(int[] nums) //Moore's Voting Algorithm Time O(n) Space O(1)
    {
        int el = -1;
        int count = 0;
        int n = nums.length;
        for(int i = 0 ; i < n ; i++)
        {
            if(count == 0)
            {
                count = 1;
                el = nums[i];
            }
            else if(nums[i] == el)
            {
                count++;
            }
            else
            {
                count--;
            }
        }
        int count1 = 0;
        for(int i = 0 ; i < n ; i++)
        {
            if(el == nums[i])
            {
                count1++;
            }
        }
        if(count1 > n / 2) return el;
        return -1;
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
        int result = majorityElementOptimal(nums);
        if(result != -1) System.out.println("Majority Element : " + result);
        else{
            System.out.println("No Majority Element Found !");
        }
        sc.close();
        }
    }
