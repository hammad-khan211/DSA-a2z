import java.util.*;
class HashMapQue{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array : ");
        int n = sc.nextInt();
        int[] arr  = new int[n];
        System.out.println("Enter the " + n + " number of elements : ");
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt();
        }

        //precomputing

        HashMap<Integer , Integer> mpp = new HashMap<>();               //HashMap only stors keys that are used whereas basic hashing keep extra keys
        for(int i = 0 ; i < n ; i++)
        {
            mpp.put(arr[i] , mpp.getOrDefault(arr[i] , 0) + 1);
        }

        System.out.println("Ener the number of queries you want to enter : ");
        int q = sc.nextInt();
        System.out.println("Enter " + q + " number of queries");
        while(q-- > 0)
        {
            int number = sc.nextInt();
            System.out.println(number + " occured " + mpp.getOrDefault(number , 0) + " times");//fetching


        }

    }
}