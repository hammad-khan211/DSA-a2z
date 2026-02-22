import java.util.Scanner;
class SelectionSort{
    void sorting(int[] arr)
    {
        int N = arr.length;
        for(int i = 0 ; i < N - 1 ; i++)  // O(N^2)
        {
            int min = i;  //selection sort me  select the minimum element and replace with the first index
            for(int j = i + 1 ; j < N ; j++)
            {
                if(arr[j] < arr[min])
                {
                    min = j;
                }                         
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }           // best big O(N^2) 
                //average big O(N^2)
                //worst big O(N) 

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
        SelectionSort obj = new SelectionSort();
        System.out.println("Array after sorting : ");
        obj.sorting(arrs);
        for(int x : arrs)
        {
            System.out.print(x + " ");
        }
    }
}