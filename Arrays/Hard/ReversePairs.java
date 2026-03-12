import java.util.*;
class ReversePairs
{
    static int brute(int[] nums)
    {
        int n = nums.length;
        int count = 0;
        for(int i = 0 ; i < n - 1 ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                count++;
            }
        }
        return count;
    }

    static int optimal(int[] nums)
    {
        
    }
}