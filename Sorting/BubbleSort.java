import java.util.Scanner;
class BubbleSort{
    void sorted(int[] arr)
    {
        int N = arr.length;
        for(int i = 0 ; i < N - 1 ; i++)
        {
            for(int j = 0 ; j < N - ( i + 1 ); j++)
            {
                if(arr[j] > arr[j + 1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;  //bubble sort me push the largest element to the last
                }  // best big O(N) 
                //average big O(N^2)
                //worst big O(N) 
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
        BubbleSort obj = new BubbleSort();
        System.out.println("Array after sorting : ");
        obj.sorted(arrs);
        for(int x : arrs)
        {
            System.out.print(x + " ");
        }
    }

    
}