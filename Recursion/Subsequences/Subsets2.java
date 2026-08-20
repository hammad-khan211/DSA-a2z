import java.util.*;
class Subsets2
{
    static List<List<Integer>> brute(int[] nums)
    {
        Arrays.sort(nums);
        Set < List < Integer > > ans = new HashSet<>();
        List < List < Integer > > res = new ArrayList<>();
        generate(nums , 0 , new ArrayList<>() , ans);
        res.addAll(ans);
        return res;
    }

    static void generate(int[] nums , int index , ArrayList < Integer > current , Set < List < Integer > > ans)
    {
        if(index == nums.length)
        {
            ans.add(new ArrayList<>(current));
            return;
        }
        //take
        current.add(nums[index]);
        generate(nums , index + 1 , current , ans);
        //backtrack
        current.remove(current.size() - 1);

        //dont take
        generate(nums , index + 1 , current , ans);
    }



    static List<List<Integer>> optimal(int[] nums)
    {
        Arrays.sort(nums);
        List < List < Integer > > ans = new ArrayList<>();
        generateOptimal(nums , 0 , new ArrayList<>() , ans);
        return ans;
    }

    static void generateOptimal(int[] nums , int index , ArrayList < Integer > current , List < List < Integer > > ans)
    {
        ans.add(new ArrayList<>(current));
        for(int i = index ; i < nums.length ; i++)
        {
            if(i != index && nums[i] == nums[i - 1]) continue;
            current.add(nums[i]);
            generateOptimal(nums , i + 1 , current , ans);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " number of array elements : ");
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt();
        }
        List < List < Integer > > ans = optimal(arr);
        for(List < Integer > X : ans)
        {
            System.out.print("[ ");
            for(int Y : X)
            {
                System.out.print(" " + Y + " ");
            }
            System.out.print(" ] , ");
        }
        sc.close();
    }
}