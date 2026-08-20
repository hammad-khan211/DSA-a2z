import java.util.*;
class GenerateAllSubsequencesOfArrayWithSumK
{

    static ArrayList < ArrayList < Integer > > optimal(int[] nums , int K)
    {
        ArrayList < ArrayList < Integer > > ans = new ArrayList<>();
        generate(nums , 0 , new ArrayList<>() , ans , 0 , K);
        return ans;
    }
    static void generate(int[] nums , int index , ArrayList < Integer > current , ArrayList < ArrayList < Integer > > ans ,int sum ,  int K)
    {
        if(index == nums.length)
        {
            if(sum == K)
            {
                ans.add(new ArrayList<>(current));
            }

            return;
        }
        //take
        current.add(nums[index]);
        sum += nums[index];
        generate(nums , index + 1 , current , ans , sum , K);

        //backtrack
        sum -= nums[index];
        current.remove(current.size() - 1);

        //dont take
        generate(nums , index + 1 , current , ans , sum , K);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array : ");
        int n = sc.nextInt();
        int total = 1 << n;
        int[] arr = new int[n];
        System.out.println("Enter " + n + " number of array elements : ");
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter K : ");
        int k = sc.nextInt();
        ArrayList < ArrayList < Integer > > ans = optimal(arr , k);
        System.out.println(" ALL SUBSEQUENCES WITH SUM " + k + " ARE : ");
        for(ArrayList < Integer > X : ans)
        {
            System.out.print(" [ ");
            for(int Y : X)
            {
                System.out.print(" " + Y + " ");
            }
            System.out.print(" ] ");
            System.out.println("");
        }
    }
}