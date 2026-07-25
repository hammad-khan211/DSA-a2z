import java.util.*;
class ReversePairs
{
    static int bruteReversePairs(int[] nums)
    {
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            for(int j = i + 1 ; j < nums.length ; j++)
            {
                if(nums[i] > (2 * nums[j]))
                {
                    count++;
                }
            }
        }
        return count;
    }

    //-----------------------------------------------Optimal Solution starts from here ---------------------------------
    static int count = 0;
    static void mergeSort(int[] nums , int low , int high)
    {
        if(low == high) return;
        int mid = ( low + high ) / 2;
        mergeSort(nums , low , mid);
        mergeSort(nums , mid + 1 ,high);
        countRevPairs(nums , low , mid , high);
        merge(nums , low , mid , high);
    }

    static void countRevPairs(int[] nums , int low , int mid , int high)
    {
        int right = mid + 1;
        for(int i = low ; i <= mid ; i++)
        {
            while(right <= high && nums[i] > 2 * nums[right])
            {
                right++;
            }
            count += right - (mid + 1);
        }
    }

    static void merge(int[] nums , int low , int mid , int high)
    {
        int N = high - low + 1;
        int[] temp = new int[N];
        int index = 0;
        int left = low;
        int right = mid + 1;

        while(left <= mid && right <= high)
        {
            if(nums[left] <= nums[right])
            {
                temp[index++] = nums[left++];
            }
            else
            {
                temp[index++] = nums[right++];
            }
        }
        while(left <= mid)
        {
            temp[index++] = nums[left++];
        }
        while(right <= high)
        {
            temp[index++] = nums[right++];
        }
        for(int i = 0 ; i < N ; i++)
        {
            nums[low + i] = temp[i];
        }
    }

    static int optimal(int[] nums)
    {
        count = 0;
        mergeSort(nums , 0 , nums.length - 1);
        return count;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the " + n + " number of array elements : ");
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt();
        }
        int ans = optimal(arr);
        System.out.print("The number of reverse pairs in this array are : " + ans);

    }
}