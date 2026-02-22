import java.util.Scanner;
class BasicHashing{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array size : ");
        int N = sc.nextInt();
        int[] arr = new int[N];
        System.out.println("Enter " + N + " elements : ");
        for(int i = 0; i < N; i++)
        {
            arr[i] = sc.nextInt();
        }

        //PRECOMPUTING 

        int [] hash = new int[13];
        for(int i = 0; i < N; i++){
            hash[arr[i]] += 1;
        }

        //queries
        System.out.println("Enter the number of queries you want to enter : ");
        int q = sc.nextInt();
        System.out.println("Enter " + q + " queries : ");
        while(q-- > 0)
        {
            int number = sc.nextInt();
            System.out.println(number + "  occured " + hash[number]  +" times");  //fetching the values from hash array
        }
        sc.close();

    }
}