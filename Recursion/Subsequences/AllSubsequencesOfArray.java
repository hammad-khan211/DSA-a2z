import java.util.*;
class AllSubsequencesOfArray
{

    static ArrayList < ArrayList < Integer > > optimal(int[] nums)
    {
        ArrayList < ArrayList < Integer > > ans = new ArrayList<>();
        generate(nums , 0 , new ArrayList<>() , ans);
        return ans;
    }
    static void generate(int[] nums , int index , ArrayList < Integer > current , ArrayList < ArrayList < Integer > > ans)
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
        ArrayList < ArrayList < Integer > > ans = optimal(arr);
        System.out.println(" ALL " + total + " SUBSEQUENCES : ");
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