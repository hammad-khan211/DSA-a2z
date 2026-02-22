import java.util.Scanner;
class QuickSort{
    static void quickksort(int[] arr , int low , int high)
    {
        if(low < high)
        {
            int partitionIndex = partition(arr , low , high);
            quickksort(arr , low , partitionIndex - 1);
            quickksort(arr , partitionIndex + 1 , high);
        }
    }

    static int partition(int[] arr , int low , int high)
    {
        int pivot = arr[low];
        int i = low;
        int j = high;
        while(i < j)
        {
            while(i <= high - 1 && arr[i] <= pivot )
            {
                i++;
            }
            while(j >= low + 1  && arr[j] > pivot )
            {
                j--;
            }
            if(i < j)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp2 = arr[low];
        arr[low] = arr[j];
        arr[j] = temp2;
        return j;
    }                                 //Time Complexity O(N log( N ))
                                       //Space Complexity O(1)

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
            quickksort(nums , 0 , size - 1);
            System.out.println("Array after quick sorting : ");
            for(int x : nums)
            {
                System.out.print(x + " ");
            }

        }
    }
}