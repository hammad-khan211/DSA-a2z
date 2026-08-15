import java.util.Scanner;
class ReverseArray{
    void reverse(int[] arr)  //WITHOUT RECURSION
    {
        int i = 0;
        int j = arr.length - 1;
        while(i < j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
    }

    void reverse2(int[] arr , int i , int j)   //WITH RECURSION
    {
        if( i >= j)
        {
            return;
        }
        else
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            reverse2(arr , i + 1, j - 1);  // RECURSIVE CALL
        }

    }
        
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the size : ");
            int n = sc.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter " + n +" array elements");
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println("Before reversing :");
            for(int x : arr)
            {
                System.out.print(x + " ");
            }
            System.out.println(" ");

            ReverseArray obj = new ReverseArray();
            obj.reverse2(arr, 0, arr.length - 1);
            System.out.println("After reversing :");
            for(int x : arr)
            {
                System.out.print(x + " ");
            }


        }
        
    

}