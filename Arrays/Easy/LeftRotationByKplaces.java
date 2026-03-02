import java.util.Scanner;
class LeftRotationByKplaces
{
    static void leftRotateBrute(int[] arr , int K) //Time O(N) , Space O(K)
    {
        int N = arr.length;
        if(N == 0) return;
        K = K % N;
        if(K == 0) return;
        int[] temp = new int[K];
        for(int i = 0 ; i < K ; i++)
        {
            temp[i] = arr[i];
        }

        for(int i = K ; i < N ; i++)
        {
            arr[i - K] = arr[i];
        }
        for(int i = N - K ; i < N ; i++)
        {
            arr[i] = temp[i - ( N - K )];
        }

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

    static void leftRotateOptimal(int[] arr , int K)  //Time O(N) , Space O(1)
    {
        int N = arr.length;
        if(N == 0) return;
        K %= N;
        if(K == 0) return;
        reverse(arr , 0 , K - 1);
        reverse(arr , K , N - 1);
        reverse(arr , 0 , N - 1);

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
        System.out.println("Enter the number of left rotations you want to perfrom : ");
        int k = sc.nextInt();
       
        leftRotateOptimal(nums , k);
        System.out.println("Array after " + k + " left roations : ");
        for(int x : nums)
        {
            System.out.print(x + " ");
        }  
        sc.close();      
    }

}