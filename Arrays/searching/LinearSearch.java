import java.util.*;
class LinearSearch
{
    static int search(int[] arr , int target)
    {
        for(int i = 0 ; i < arr.length ; i++)
        {
            if(arr[i] == target)
            {
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("ENter the size of the array : ");
        int size = sc.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter the " + size + " number of array elements : ");
        for(int i = 0 ; i < size ; i++)
        {
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter the number you want to search in the array : ");
        int x = sc.nextInt();
        int result = search(nums , x);
        if(result != -1)
        {
            System.out.println(x + " is present in the array at : " + result + " index.");
        }
        else
        {
            System.out.println(x + " does not exist in the array.");    
        }
    }
}