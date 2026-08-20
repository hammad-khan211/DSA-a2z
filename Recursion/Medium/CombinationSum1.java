import java.util.*;
class CombinationSum1
{
    static ArrayList < ArrayList < Integer > > optimal(int[] nums , int target)
    {
        ArrayList < ArrayList < Integer > > ans = new ArrayList<>();
        generate(nums , 0 , target , new ArrayList<>() , ans);
        return ans;
    }


    static void generate(int[] nums , int index , int target , ArrayList < Integer > current , ArrayList < ArrayList < Integer > > ans)
    {
        if(index == nums.length)
        {
            if(target == 0)
            {
                ans.add(new ArrayList<>(current));
            }
            return;
        }
        if(nums[index] <= target)
        {
            current.add(nums[index]);
            generate(nums , index , target - nums[index] , current , ans);
            current.remove(current.size() - 1);
        }
        generate(nums , index + 1 , target , current , ans);
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size : ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter " + n + " array elements : ");
        for(int i = 0 ; i < n ; i++)
        {
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter target value : ");
        int k = sc.nextInt();
        ArrayList < ArrayList < Integer > > res = optimal(nums, k);
        for(ArrayList < Integer > X : res)
        {
            System.out.print("[ ");
            for(int Y : X)
            {
                System.out.print(Y + " ");
            }
            System.out.print(" ]");
            System.out.println("");
        }
    }
}