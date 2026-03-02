import java.util.Scanner;
class SecondLargestElement
{
    static int SecondLargest(int[] arr)
    {
        int largest = arr[0];
        int slargest = -1; //-1 in case of positive elements , Integer.MIN_VALUE in case of negative elements
        for(int i = 0 ; i < arr.length ; i++)
        {
            if(arr[i] > largest)
            {
                slargest = largest;
                largest = arr[i];
            }
            else if(arr[i] < largest && arr[i] > slargest)
            {
                slargest = arr[i];
            }
        }
        return slargest;
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
        int result = SecondLargest(nums);
        System.out.println("Second Largest element : " + result);
    }    

}