import java.util.Scanner;
class InsertionSort{
    static void Sortarray(int[] arr)
    {
        int N = arr.length;
        for(int i = 0 ; i < N ; i++)  //insertion sort me place or insert the element at its right position
        {                                           // best big O(N) 
                                                   //average big O(N^2)
                                                     //worst big O(N) 
            int j = i;
            while(j > 0 && arr[j - 1] > arr[j])
            {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] nums = new int[size];
        for(int i = 0 ; i < size ; i++)
        {
            nums[i] = sc.nextInt();
        }
        Sortarray(nums);
        for(int x : nums)
        {
            System.out.print(x + " ");
        }
    }
}