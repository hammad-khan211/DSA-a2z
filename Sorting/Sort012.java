import java.util.Scanner;
class Sort012
{
    static void sort012Brute(int[] arr)  //Time Complexity O(N log N) //Space O(1)
    {
        QuickSort.quickksort(arr, 0, arr.length - 1);
    }

    static void sort012Better(int[] arr) //Time Complexity O(2N) //Space O(1)
    {
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        for(int i = 0 ; i < arr.length ; i++)
        {
            if(arr[i] == 0) c0++;
            else if(arr[i] == 1) c1++;
            else c2++;
        }
        for(int i = 0 ; i < c0 ; i++)
        {
            arr[i] = 0;
        }
        for(int i = c0 ; i < c0 + c1 ; i++)
        {
            arr[i] = 1;
        }
        for(int i = c0 + c1 ; i < arr.length ; i++)
        {
            arr[i] = 2;
        }
    }

    static void sort012Optimal(int[] arr) //Time Complexity O(N) Space O(1)
    {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while(mid <= high)
        {
            if(arr[mid] == 0)
            {
                int temp1 = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp1;
                mid++;
                low++;
            }
            else if(arr[mid] == 1)
            {
                mid++;
            }
            else
            {
                int temp2 = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp2;
                high--;
            }
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        {
            System.out.print("Enter the size of the array : ");
            int size = sc.nextInt();
            int[] nums = new int[size];
            System.out.println("Enter the " + size + " number of array elements : ");
            for(int i = 0 ; i < size ; i++)
            {
                nums[i] = sc.nextInt();
            }
            sort012Optimal(nums);
            System.out.println("Array after  sorting : ");
            for(int x : nums)
            {
                System.out.print(x + " ");
            }

        }
    }
}
