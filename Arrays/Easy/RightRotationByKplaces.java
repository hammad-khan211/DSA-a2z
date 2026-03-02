import java.util.*;
class RightRotationByKplaces
{
    static void rightRotationBrute(int[] arr , int K)  //Time O(N) , Space O(K)
    {
        int N = arr.length;
        if(N == 0) return;
        K %= N;
        if(K == 0) return;
        int[] temp = new int[K];
        for(int i = N - K ; i < N ; i++)
        {
            temp[i - (N - K)] = arr[i];
        }
        for(int i = N - 1 ; i >= K ; i--)
        {
            arr[i] = arr[i - K];
        }
        for(int i = 0 ; i < K ; i++)
        {
            arr[i] = temp[i];
        }
    }

    static void rightRotationOptimal(int[] arr , int K) //Time O(N) , Space O(1)
    {
        int N = arr.length;
        if(N == 0) return;
        K %= N;
        if(K == 0) return;
        reverse(arr , N-K , N-1);
        reverse(arr , 0 , N-(K+1));
        reverse(arr , 0 , N-1);
    }

    static void reverse(int[] arr , int i , int j)
    {
        while(i < j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter the " + size + " number of array elements : ");
        for(int i = 0 ; i < size ; i++)
        {
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter the number of right rotations you want to perform : ");
        int k = sc.nextInt();
       
        rightRotationOptimal(nums , k);
        System.out.println("Array after " + k + " right roations : ");
        for(int x : nums)
        {
            System.out.print(x + " ");
        }  
        sc.close();      
    }


}