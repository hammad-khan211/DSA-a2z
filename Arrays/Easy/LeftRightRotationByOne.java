import java.util.Scanner;
class LeftRightRotationByOne
{
    static void leftRotate(int[] arr)
    {
        int temp = arr[0];
        for(int i = 1 ; i < arr.length ; i++)
        {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;
    }

    static void rightRotation(int[] arr)
    {
        int temp = arr[arr.length - 1];
        for(int i = arr.length - 1 ; i > 0 ; i--)
        {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
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
       
        leftRotate(nums);
        System.out.println("Array after one left roation : ");
        for(int x : nums)
        {
            System.out.print(x + " ");
        }
         System.out.println(" ");
        rightRotation(nums);
        System.out.println("Array after one right roation : ");
        for(int x : nums)
        {
            System.out.print(x + " ");
        }        

    }
}