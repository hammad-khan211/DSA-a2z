import java.util.*;
class KthElementOfTwoSortedArrays
{
    static int optimal(int[] nums1 , int[] nums2 , int k) // O(log(min(n , m)))
    {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2) return optimal(nums2 , nums1 , k);

        int low = Math.max(0 , k - n2);
        int high = Math.min(n1 , k);

        int left = k;

        while(low <= high)
        {
            int mid1 = low + ((high - low) / 2);
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(mid1 != 0) l1 = nums1[mid1 - 1];
            if(mid2 != 0) l2 = nums2[mid2 - 1];
            if(mid1 < n1) r1 = nums1[mid1];
            if(mid2 < n2) r2 = nums2[mid2];

            if(l1 <= r2 && l2 <= r1)
            {
                return Math.max(l1 , l2);
            }
            else if(l1 > r2)
            {
                high = mid1 - 1;
            }
            else
            {
                low = mid1 + 1;
        
            }
        }
        return -1;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of first array  : ");
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Enter the " + n1 + " number of array elements : ");
        for(int i = 0 ; i < n1 ; i++)
        {
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter the size of second array  : ");
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        System.out.println("Enter the " + n2 + " number of array elements : ");
        for(int i = 0 ; i < n2 ; i++)
        {
            arr2[i] = sc.nextInt();
        }
        System.out.println("Enter the value of K : ");
        int k = sc.nextInt();
        int ans = optimal(arr1 , arr2 , k);
        System.out.println("The element at " + k + "th postion is : " + ans);
        sc.close();

    }

}