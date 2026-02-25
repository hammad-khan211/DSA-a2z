import java.util.Scanner;
class RearrangeArraybySign
{
    static int[] rearrangeArrayBrute(int[] nums) //Time O(2n) Space O(n)
    {
        int n = nums.length;
        int[] pos = new int[n/2];
        int p = 0 , q = 0;
        int[] neg = new int[n/2];
        for(int i = 0 ; i < n ; i++)
        {
            if(nums[i] > 0)
            {
                pos[p] = nums[i];
                p++;
            }
            else
            {
                neg[q] = nums[i];
                q++;
            }
        }
        p = 0;
        q = 0;
        int[] result = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            if(i % 2 == 0)
            {
                result[i] = pos[p];
                p++;
            }
            else
            {
                result[i] = neg[q];
                q++;
            }
        }
        return result;
    }

    static int[] rearrangeArrayOptimal(int[] nums) //Time O(n) Space O(n)
    {
        int n = nums.length;
        int pos = 0;
        int neg = 1;
        int[] ans = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            if(nums[i] > 0)
            {
                ans[pos] = nums[i];
                pos += 2;
            }
            else{
                ans[neg] = nums[i];
                neg += 2;
            }
        }
        return ans;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();
        if(size % 2 != 0) 
        {
            System.out.print("Invalid array size");
        }
        else
        {
            int[] nums = new int[size];
            System.out.println("Enter " + (size/2) + " positive " + " and " + (size/2) + " negative elements : ");
            for(int i = 0 ; i < size ; i++)
            {
                nums[i] = sc.nextInt();
            }
            int[] ans = rearrangeArrayOptimal(nums);
            for(int x : ans)
            {
                System.out.print(x + " ");
            }
            sc.close();
        }
    }
}