import java.util.Scanner;
class MergeSort{
    static void MergingSort(int[] arr , int low , int high)
    {
        if(low == high) 
        {
            return;
        }
        else{
            int mid = (low + high) / 2;
            MergingSort(arr , low , mid);
            MergingSort(arr , mid + 1 , high);
            Merge(arr , low , mid ,high);
        }
    }

    static void Merge(int[] arr , int low , int mid , int high)
    {
        int N = ( high - low ) + 1;
        int[] temp = new int[N];
        int left = low;
        int right = mid + 1;
        int index = 0;
        while(left <= mid && right <= high)
        {
            if(arr[left] <= arr[right])
            {
                temp[index] = arr[left];
                index++;
                left++;
            }
            else{
                temp[index] = arr[right];
                index++;
                right++;
            }
        }

        while(left <= mid)
        {
            temp[index] = arr[left];
            index++;
            left++;
        }
        while(right <= high)
        {
            temp[index] = arr[right];
            index++;
            right++;
        }
        for(int i = 0 ; i < N ; i++)
        {
            arr[low + i] = temp[i]; 
        }
    }                                       //  worst best avg case time complexity O(N log(N)) 
                                             // space complexity O(N)

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter th size of array : ");
        int size = sc.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter the " + size +" number of elements of array : ");
        for(int i = 0 ; i < size ; i++)
        {
            nums[i] = sc.nextInt();
        }
        MergingSort(nums , 0 , size - 1);
        System.out.println("Array after sorting : ");
        for(int X : nums)
        {
            System.out.print(X + " ");
        }
    }


}