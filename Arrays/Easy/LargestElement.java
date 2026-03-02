import java.util.Scanner;
class LargestElement{
    static int largest(int[] arr)
    {
        int l = arr[0];
        for(int i = 0 ; i < arr.length ; i++)
        {
            if(l < arr[i])
            {
                l = arr[i];
            }
        }                     // Time Complexity -> O(N)
        return l;
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
        int result = largest(nums);
        System.out.println("Largest element : " + result);
    }
}