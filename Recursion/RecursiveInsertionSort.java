    import java.util.Scanner;
    class RecursiveInsertionSort
    {
        static void sort(int[] arr , int i , int N)
        {
            if(i == N)
            {
                return;
            }
            else
            {
                int j = i;
                while(j > 0 && arr[j - 1] > arr[j])
                {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    j--;
                }
            }
            sort(arr , i + 1 , N );
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
            sort(nums , 0 , size);
            for(int x : nums)
            {
                System.out.print(x + " ");
            }
        }
        
    }