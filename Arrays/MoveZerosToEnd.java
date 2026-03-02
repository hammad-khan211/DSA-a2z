import java.util.*;
class MoveZerosToEnd
{
    static int[] moveZerosBrute(int[] arr)  //Time O(N)  , Space O(N)
    {
        int N = arr.length;
        int[] temp = new int[N];
        int j = 0;
        for(int i = 0 ; i < N ; i++)
        {
            if(arr[i] != 0)
            {
                temp[j] = arr[i];
                j++;
            }
        }
        // int occupied = N - j;  not required because array has all elements as 0 when declared 
        // for(int i = N - occupied ; i < N ; i++)
        // {
        //     temp[i] = 0;
        // }
        return temp;
    }

    static int[] moveZerosOptimal(int[] arr)   //Time O(N)  , Space O(1)
    {
        int N = arr.length;
        int j = 0;
        for(int i = 0 ; i < N ; i++)
        {
            if(arr[i] != 0)
            {
                arr[j++] = arr[i];
            }
        }
        for(int i = j ; i < N ; i++)
        {
            arr[i] = 0;
        }
        return arr;
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
        int[] result = moveZerosOptimal(nums);
        for(int x : result)
        {
            System.out.print(x + " ");
        }        
    }
}