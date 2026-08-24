import java.util.*;
class FruitIntoBaskets
{
    static int brute(int[] nums) //tc O(n^2) sc O(n)
    {
        int maxL = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            Set < Integer > set = new HashSet<>();
            for(int j = i ; j < nums.length ; j++)
            {
                set.add(nums[j]);
                if(set.size() > 2)
                {
                    break;
                }
                maxL = Math.max(maxL , j - i + 1);
            }
        }
        return maxL;
    } 
    
    static int optimal(int[] nums) //tc O(n) scO(n)
    {
        int l = 0;
        int maxL = 0;
        Map < Integer , Integer > mpp = new HashMap<>();
        for(int r = 0 ; r < nums.length ; r++)
        {
            mpp.put(nums[r] , mpp.getOrDefault(nums[r] , 0) + 1);
            while(mpp.size() > 2)
            {
                mpp.put(nums[l] , mpp.get(nums[l]) - 1);
                if(mpp.get(nums[l]) == 0)
                {
                    mpp.remove(nums[l]);
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
        System.out.println("Enter array size : ");
        int size = sc.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter " + size + " array elements : ");
        for(int i = 0 ; i < nums.length ; i++)
        {
            nums[i] = sc.nextInt();
        }
        int ans = optimal(nums);
        System.out.println("Maximum Fruits that can be carried are  : " + ans);
        sc.close();
    }
}
