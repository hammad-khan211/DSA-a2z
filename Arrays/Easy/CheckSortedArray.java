//Check if the given array is sorted or not
import java.util.*;
class CheckSortedArray{
    static boolean isSorted(int[] num)
    {
        for(int i = 1 ; i < num.length ; i++)
        {
            if(num[i] < num[i - 1]) return false;
        }
        return true;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter the " + size + " number of array elements : ");
        for(int i = 0 ; i < size ; i++)
        {
            nums[i] = sc.nextInt();
        }
        System.out.println("Is the array Sorted ? : " + isSorted(nums));
    }  
}