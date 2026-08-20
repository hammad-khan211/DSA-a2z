import java.util.*;
class CombinationSum2
{
    static List<List<Integer>> combinationSum2Brute(int[] candidates, int target)
    {
        Arrays.sort(candidates);
        Set < List < Integer > > unique = new HashSet<>();
        List < List < Integer > > ans = new ArrayList<>();
        brute(candidates , 0 , target , new ArrayList<>() , unique);
        ans.addAll(unique);
        return ans;
    }

    static void brute(int[] candidates , int index , int target , List < Integer > current , Set < List < Integer > > unique)
    {
        if(index == candidates.length)
        {
            if(target == 0)
            {
                unique.add(new ArrayList<>(current));
            }
            return;
        }
        if(candidates[index] <= target)
        {
            current.add(candidates[index]);
            brute(candidates , index + 1 , target - candidates[index] , current , unique);
            current.remove(current.size() - 1);
        }
        brute(candidates , index + 1 , target , current , unique);
    }

    static List<List<Integer>> combinationSum2Optimal(int[] candidates, int target)
    {
        Arrays.sort(candidates);
        List < List < Integer > > ans = new ArrayList<>();
        optimal(candidates , 0 , target , new ArrayList<>() , ans);
        return ans;
    }

    static void optimal(int[] candidates , int index , int target , List < Integer > current , List < List < Integer > > ans)
    {
        if(target == 0)
        {
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i = index ; i < candidates.length ; i++)
        {
            if(i > index && candidates[i] == candidates[i - 1])
            {
                continue;
            }
            if(candidates[i] > target)
            {
                break;
            }
            current.add(candidates[i]);
            optimal(candidates , i + 1 , target - candidates[i] , current , ans);
            current.remove(current.size() - 1);
        }
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
        List < List < Integer > > res = combinationSum2Optimal(nums, k);
        for(List < Integer > X : res)
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