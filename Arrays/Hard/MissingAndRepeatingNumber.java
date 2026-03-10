//array could only have numbers from
import java.util.*;
class MissingAndRepeatingNumber
{
    static int[] bruteApproach(int[] nums) //Time Complexity : O(n^2) , Space Complexity O(1)
    {
        int n = nums.length;
        int missing = -1;
        int repeating = -1;
        for(int i = 1 ; i <= n ; i++)
        {
            int count = 0;
            for(int j = 0 ; j < n ; j++)
            {
                if(nums[j] == i)
                {
                    count++; 
                }
            }
            if(count == 2) repeating = i;
            if(count == 0) missing = i; 
        }
        return new int[]{missing , repeating};
    }

    static int[] betterApproach(int[] nums) //Time Complexity : O(n) , Space Complexity O(n)
    {
        int n = nums.length;
        int missing = -1;
        int repeating = -1;
        int[] hash = new int[n + 1];
        for(int i = 0 ; i < n ; i++)
        {
            hash[nums[i]]++;
        }
        for(int i = 1 ; i <= n ; i++)
        {
            if(hash[i] == 0)
            {
                missing = i;
            }
            else if(hash[i] == 2)
            {
                repeating = i;
            }
            else
            {
                continue;
            }
        }
        return new int[]{missing , repeating};
    }

    static int[] OptimalApproach1(int[] nums) //Time Complexity : O(n) , Space Complexity O(1)
    {
        int n = nums.length;

        int x = 0; //repeating
        int y = 0; //missing

        int S = 0;
        int S2 = 0;

        int Sn = (n * (n + 1)) / 2;
        int Sn2 = (n * (n + 1) * (2*n + 1)) / 6;

        for(int i = 0 ; i < n ; i++)
        {
            S += nums[i];
            S2 += nums[i] * nums[i];
        }

        int val1 = S - Sn; // val1 = x - y
        int val2 = S2 - Sn2; //val2 = x^2 - y^2
        val2 = val2 / val1;  // val2 = x + y

        x = ( val1 + val2 ) / 2;
        y = x - val1;
        return new int[]{y , x};
    }

    static int[] optimalApproach2(int[] nums) // TIme Complexity O(n) Space O(1)
    {
        int n = nums.length;
        int xr = 0;
        for(int i = 0 ; i < n ; i++)
        {
            xr ^= nums[i];
            xr ^= (i + 1);
        }

        int number = xr & ~(xr - 1);
        int zero = 0;
        int one = 0;
        for(int i = 0 ; i < n ; i++)
        {
            if((nums[i] & number) != 0)
            {
                one ^= nums[i];
            }
            else{
                zero ^= nums[i];
            }
        }
        for(int i = 1 ; i <= n ; i++)
        {
            if((i & number) != 0)
            {
                one ^= i;
            }
            else{
                zero ^= i;
            }
        }
        int count = 0;
        for(int i = 0 ; i < n ; i++)
        {
            if(nums[i] == zero)
            {
                count++;
            }
        }
        if(count == 2) 
        {
            return new int[]{one , zero};
        }
        return new int[]{zero , one};

    }

    static int[] optimalApproach3(int[] nums) // TIme Complexity O(n) Space O(1)
    {
        int n = nums.length;
        int missing = -1;
        int repeating = -1;
        for(int i = 0 ; i < n ; i++)
        {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0)
            {
                repeating = Math.abs(nums[i]);
            }
            else{
                nums[index] = -nums[index];
            }
        }
        for(int i = 0 ; i < n ; i++)
        {
            if(nums[i] >= 0)
            {
                missing = i + 1;
            }
        }
        return new int[]{missing , repeating};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the " + size + " number of elements in the range 1 - " + size  + " : ");
        for(int i = 0 ; i < size ; i++)
        {
            arr[i] = sc.nextInt();
        }
        int[] result = optimalApproach3(arr);
        System.out.println("Missing Number : " +  result[0]);
        System.out.println("Repeating Number : " +  result[1]);
    }
}