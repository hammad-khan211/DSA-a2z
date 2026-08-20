import java.util.*;
class GenerateAny1SubsequenceOfArrayWithSumK
{

    static ArrayList < Integer > optimal(int[] nums , int K)
    {
        ArrayList < Integer > current = new ArrayList<>();
        generate(nums , 0 , current , 0 , K);
        return current;
    }
    static boolean generate(int[] nums , int index , ArrayList < Integer > current ,int sum ,  int K)
    {
        if(index == nums.length)
        {
            if(sum == K)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        //take
        current.add(nums[index]);
        sum += nums[index];
        if(generate(nums , index + 1 , current , sum , K) == true) return true;

        //backtrack
        sum -= nums[index];
        current.remove(current.size() - 1);

        //dont take
        if(generate(nums , index + 1 , current , sum , K) == true) return true;

        return false;
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
        System.out.println("Enter K : ");
        int k = sc.nextInt();
        ArrayList < Integer > ans = optimal(arr , k);
        if(ans.size() == 0 && k != 0) {
            System.out.println("No subsequence found");
        } else {
            System.out.println("One subsequence with sum " + k + " is: " + ans);
        }
    }
}