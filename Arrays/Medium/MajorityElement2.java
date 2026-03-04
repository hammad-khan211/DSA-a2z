import java.util.*;
class MajorityElement2
{
    static List < Integer > findMajorityElementBrute(int[] nums) //Time O(n^2) Space O(1)
    {
        List < Integer > num = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++)
        {
            int count = 0;
            for(int j = 0 ; j < nums.length ; j++)
            {
                if(nums[i] == nums[j])
                {
                    count++;
                }
                if(count > nums.length / 3)
                {
                    if(num.size() == 0 || num.get(num.size() - 1) != nums[i])
                    {
                        num.add(nums[i]);
                        break;
                    }
                }
            }
        }
        return num;
    }

    static List < Integer > findMajorityElementsBetter(int[] nums) //Time O(n log n) //Space O(1)
    {
        List < Integer > num  = new ArrayList<>();
        Arrays.sort(nums);
        int count = 1;
        for(int i = 1 ; i < nums.length ; i++)
        {
            if(nums[i] == nums[i - 1])
            {
                count++;
            }
            else
            {
                count = 1;
            }
            if(count > nums.length / 3)
            {
                if(num.size() == 0 || num.get(num.size() - 1) != nums[i])
                {
                        num.add(nums[i]);
                }        
            }
        }
        return num;
    }

    static List < Integer > findMajorityElementsBetter2(int[] nums)//Time O(n) Space O(n)
    {
        HashMap < Integer , Integer > mpp = new HashMap<>();
        List < Integer > num = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++)
        {
            mpp.put(nums[i] , mpp.getOrDefault(nums[i] , 0) + 1);
        }
        for(Map.Entry < Integer , Integer > entry : mpp.entrySet())
        {
            if(entry.getValue() > nums.length / 3)
            {
                num.add(entry.getKey());
            }
        }
        return num; 
    }

    static List < Integer > findMajorityElementOptimal(int[] nums)//Moore's Voting ALgorithm //Time O(n) Space O(1)
    {
        List < Integer > num = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        int el1 = 0;
        int el2 = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(nums[i] == el1)
            {
                count1++;
            }
            else if(nums[i] == el2)
            {
                count2++;
            }
            else if(count1 == 0)
            {
                el1=nums[i];
                count1 = 1;
            }
            else if(count2 == 0)
            {
                el2=nums[i];
                count2 = 1;
            }
            else
            {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for(int x : nums)
        {
            if(x == el1) count1++;
            else if(x == el2) count2++;
        }
        if(count1 > nums.length/3) num.add(el1);
        if(count2 > nums.length/3) num.add(el2);
        return num;
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
        List < Integer > result = findMajorityElementOptimal(nums);
        System.out.println("Majority Elements of array are : ");
        for(int x : result)
        {
            System.out.print(x + " ");
        }
        sc.close();
        }


    
}