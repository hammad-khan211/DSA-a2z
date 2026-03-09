import java.util.*;
class MergeOverlappingIntervals
{
    static List < List < Integer > > mergeBrute(int[][] nums) //Time O(n^2) Space O(n)
    {
        Arrays.sort(nums , (a,b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        int n = nums.length;
        List < List < Integer > > result = new ArrayList<>();
        for(int i = 0 ; i < n ; i++)
        {
            int start = nums[i][0];
            int end = nums[i][1];
            int j = i + 1;
            while(j < n && end >= nums[j][0])
            {
                end = Math.max(end , nums[j][1]);
                j++;
            }
            result.add(Arrays.asList(start , end));
            i = j - 1;
        }
        return result;
    }

    static List < List < Integer > > mergeOptimal(int[][] nums)
    {
        List < List < Integer > > result = new ArrayList<>();
        Arrays.sort(nums , (a , b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        for(int[] num : nums)
        {
            if(result.isEmpty() || result.get(result.size() - 1).get(1) < num[0])
            {
                result.add(Arrays.asList(num[0] , num[1]));
            }
            else
            {
                int last = result.size() - 1;
                int maxEnd = Math.max(result.get(last).get(1) , num[1]);
                result.get(last).set(1 , maxEnd);
            }
        }
        return result;
    }


    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements you want in 2D array : ");
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        System.out.println("Enter the " + n + " number of array elements each of size 2  : ");
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < 2 ; j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("Merged Intervals are : ");
        List < List < Integer > > ans = mergeOptimal(arr);
        for(List < Integer > X : ans)
        {
            for(int Y : X)
            {
                System.out.print(Y + " ");
            }
            System.err.println("");
        }
    }

}