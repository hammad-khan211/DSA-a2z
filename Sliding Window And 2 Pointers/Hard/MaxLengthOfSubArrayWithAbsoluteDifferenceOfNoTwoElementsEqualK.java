import java.util.*;
class MaxLengthOfSubArrayWithAbsoluteDifferenceOfNoTwoElementsEqualK
{
    static int findMaxL(int[] nums , int k)
    {
        int maxL = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            HashSet < Integer > set = new HashSet<>();
            for(int j = i ; j < nums.length ; j++)
            {
                if(set.contains(nums[j] - k) || set.contains(nums[j] + k))
                {
                    break;
                }
                set.add(nums[j]);
                maxL = Math.max(maxL , j - i + 1);
            }
        }
        return maxL;
    }

    static int optimal(int[] nums , int k)
    {
        int l = 0;
        HashMap < Integer , Integer > freq = new HashMap<>();
        int maxL = 0;
        for(int r = 0 ; r < nums.length ; r++)
        {
            freq.put(nums[r] , freq.getOrDefault(nums[r] , 0) + 1);
            while((k == 0 && (freq.getOrDefault(nums[r] , 0) > 1)) ||
                  (k != 0 && (freq.getOrDefault(nums[r] - k , 0) > 0 ||
                  freq.getOrDefault(nums[r] + k , 0) > 0)))
            {
                freq.put(nums[l] , freq.get(nums[l]) - 1);
                if(freq.get(nums[l]) == 0)
                {
                    freq.remove(nums[l]);
                }
                l++;
            }
            maxL = Math.max(maxL , r - l + 1);
        }
        return maxL;
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
        int result1 = optimal(nums, k);
        System.out.println(result1);
        sc.close();
    }
  
}
