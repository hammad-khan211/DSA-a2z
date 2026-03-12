import java.util.*;
class CountInversion
{
    static int bruteCountInversion(int[] nums) //Time COmplexity O(n^2) Space Complexity O(1)
    {
        int n = nums.length;
        int count = 0;
        for(int i = 0 ; i < n - 1 ; i++)
        {
            for(int j = i + 1 ; j < n ; j++)
            {
                if(nums[i] > nums[j]) count++;
            }
        }
        return count;
    }

    
    static int optimalCountInversion(int[] arr) //Time COmplexity O(n log n) Space O(1)
    {
        return MergeSort(arr , 0 , arr.length - 1);
    }

    static int MergeSort(int[] nums , int low , int high)
    {
        int countOptimal = 0;
        if(low == high) return countOptimal;
        else
        {
            int mid = (low + high) / 2;
            countOptimal +=MergeSort(nums , low , mid);
            countOptimal += MergeSort(nums , mid + 1 , high);
            countOptimal += Merge(nums , low , mid , high);
            return countOptimal;
        }
    }
    static int Merge(int[] nums , int low , int mid , int high)
    {
        int countOptimal = 0;
        int N = ( high - low ) + 1;
        int[] temp = new int[N];
        int left = low;
        int right = mid + 1;
        int index = 0;
        while(left <= mid && right <= high)
        {
            if(nums[left] <= nums[right])
            {
                temp[index++] = nums[left++];
            }
            else
            {

                countOptimal += (mid - left + 1);
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
        return countOptimal;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int size = sc.nextInt();
        int[] num = new int[size];
        System.out.println("Enter the " + size + " number of array elements : ");
        for(int i = 0 ; i < size ; i++)
        {
            num[i] = sc.nextInt();
        }
        int[] copy = num.clone();
        int ansBrute = bruteCountInversion(num);
        int ansOptimal = optimalCountInversion(copy);
        System.out.println("Brute , Number of pairs such that i < j and nums[i] > nums[j] are : " + ansBrute);
        System.out.println("Optimal , Number of pairs such that i < j and nums[i] > nums[j] are : " + ansOptimal);
    }
}