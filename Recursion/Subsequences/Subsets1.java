import java.util.*;
class Subsets1
{

    static ArrayList < Integer >  brute(int[] nums)
    {
        ArrayList < ArrayList < Integer > > ans = new ArrayList<>();
        generateBrute(nums , 0 , new ArrayList<>() , ans);
        
        ArrayList < Integer > sum = new ArrayList<>();
        for(ArrayList < Integer > X : ans)
        {
            int s = 0;
            for(int Y : X)
            {
                s += Y;
            }
            sum.add(s);
        }
        Collections.sort(sum);
        return sum;
    }
    static void generateBrute(int[] nums , int index , ArrayList < Integer > current , ArrayList < ArrayList < Integer > > ans)
    {
        if(index == nums.length)
        {
            ans.add(new ArrayList<>(current));
            return;
        }
        //take
        current.add(nums[index]);
        generateBrute(nums , index + 1 , current , ans);
        //backtrack
        current.remove(current.size() - 1);

        //dont take
        generateBrute(nums , index + 1 , current , ans);
    }

    static ArrayList < Integer > optimal(int[] arr)
    {
        ArrayList < Integer > ans = new ArrayList<>();
        generateOptimal(arr , 0 , 0 , ans);
        Collections.sort(ans);
        return ans;
    }

    static void generateOptimal(int[] arr , int index , int sum , ArrayList < Integer > ans)
    {
        if(index == arr.length)
        {
            ans.add(sum);
            return;
        }
        generateOptimal(arr , index + 1 , sum , ans);
        generateOptimal(arr , index + 1 , sum + arr[index] , ans);
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
        ArrayList  < Integer >  ans = optimal(arr);
        for(int X : ans)
        {
            System.out.print(X  + " ");
        }
    }
}