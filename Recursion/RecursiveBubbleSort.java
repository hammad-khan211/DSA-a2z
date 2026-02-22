import java.util.Scanner;
class RecursiveBubbleSort{
    static void sort(int[] arr , int N)
    {
        if(N == 1)
        {
            return;
        }
        else
        {
            int count = 0;
            for(int i = 0 ; i < N - 1 ; i++)
            {
                if(arr[i] > arr[i+1])
                {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    count++;
                }
            }
            if(count == 0)
            {
                return;
            }
            else
            {
                sort(arr , N - 1);
            }
        }
    }
     public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array : ");
        int size = sc.nextInt();
        int[] arrs = new int[size];
        System.out.println("Enter the " + size + " number of elements : ");
        for(int i = 0 ; i < size ; i++)
        {
            arrs[i] = sc.nextInt();
        }
        System.out.println("Array after sorting : ");
        sort(arrs , size);
        for(int x : arrs)
        {
            System.out.print(x + " ");
        }
    }
}