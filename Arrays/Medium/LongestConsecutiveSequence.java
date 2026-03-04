import java.util.*;
class LongestConsecutiveSequence
{
    static int findBrute(int[] nums)  // TIme Complexity O(n^2) Space O(1)
    {
        int maxCount = 1;
        int n = nums.length;
        if(n == 0) return 0;
        for(int i = 0 ; i < n ; i++)
        {
            int x = nums[i];
            int count = 1;
            while(true)
            {
                boolean found = false;
                for(int j = 0 ; j < n ; j++)
                {
                    if(x + 1 == nums[j])
                    {
                        x = nums[j];
                        count++;
                        found = true;
                        break;
                    }
                }
                if(!found) break;
            }
            maxCount = Math.max(maxCount , count);
        }
        return maxCount;
    }

    static int findBetter(int[] nums) //Time Complexity O(n log n) Space O(1)
    {
        int n = nums.length;
        if(n == 0) return 0;
        int maxLength = 1;
        int length = 1;
        Arrays.sort(nums);
        for(int i = 1 ; i < n ; i++)
        {
            if(nums[i] == nums[i - 1] + 1 )
            {
                length++;
            }
            else if(nums[i] == nums[i - 1])
            {
                continue;
            }
            else{
                length = 1;
            }
            maxLength = Math.max(maxLength , length);
        }
        return maxLength;
    }

    static int findOptimal(int[] nums)//Time O(n) Space O(n)
    {
        int n = nums.length;
        int longest = 1;//minimum length of sequence will be atleast 1
        if(n == 0) return 0;
        HashSet < Integer > num = new HashSet<>();//set will remove duplicates 
        for(int i = 0 ; i < n ; i++)
        {
            num.add(nums[i]);//adding array elements to set
        }
        for(int it : num)//only checking smallest elements of a sequence and then finding length of that particular sequence
        {
            if(!num.contains(it - 1))//if number is minimum
            {
                int length = 1;
                int x = it;

                while(num.contains(x + 1)) //finding length of sequence
                {
                    length++;
                    x++;
                }
                longest = Math.max(longest , length); //storing the longest length among all the sequences
            }
        }
        return longest;
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
        int result = findOptimal(nums);
        System.out.println("The Longest Consecutive Sequence is of length : " + result);
        sc.close();
    }
}