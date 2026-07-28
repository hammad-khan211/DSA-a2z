import java.util.*;
class MedianOfTwoSortedArrays
{
    static double brute(int[] nums1 , int[] nums2) //tc O(n + m) sc O(n + m)
    {
        int n = nums1.length;
        int m = nums2.length;

        int i = 0;
        int j = 0;

        int[] temp = new int[n + m];
        int k = 0;

        while(i < n && j < m)
        {
            if(nums1[i] <= nums2[j])
            {
                temp[k++] = nums1[i++];
            }
            else
            {
                temp[k++] = nums2[j++];
            }
        }
        while(i < n)
        {
            temp[k++] = nums1[i++];
        }
        while(j < m)
        {
            temp[k++] = nums2[j++];
        }

        if(temp.length % 2 == 1)
        {
            return temp[temp.length / 2];
        }

        else
        {
            double n1 = temp[temp.length / 2];
            double n2 = temp[(temp.length / 2) - 1];
            return (n1 + n2) / 2.0;
        }
    }

    static double better(int[] nums1 , int[] nums2)//tc O(n + m) sc O(1)
    {
        int n = nums1.length;
        int m = nums2.length;

        int total = n + m;

        int i = 0;
        int j = 0;

        int el1 = 0;
        int el2 = 0;

        int ind1 = total / 2;
        int ind2 = (total - 1) / 2;

        int count = 0;

        while(i < n && j < m)
        {
            int val;
            if(nums1[i] <= nums2[j])
            {
                val = nums1[i++];
            }
            else
            {
                val = nums2[j++];
            }

            if(count == ind2) el2 = val;
            if(count == ind1) el1 = val;

            count++;
        }
        while(i < n)
        {
            int val = nums1[i++];
            if(count == ind2) el2 = val;
            if(count == ind1) el1 = val;
            count++;
        }
        while(j < m)
        {
            int val = nums2[j++];
            if(count == ind2) el2 = val;
            if(count == ind1) el1 = val;
            count++;
        }
        if(total % 2 == 0)
        {
            return (el1 + el2) / 2.0;
        }
        else
        {
            return el1;
        }
    }

    static double optimal(int[] nums1 , int[] nums2) // O(log (min(n1 , n2)))
    {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int total = n1 + n2;
        if(n1 > n2) return optimal(nums2 , nums1);

        int left = ( total + 1 ) / 2;
        int low = 0;  
        int high = n1;
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
                if(total % 2 == 1)
                {
                    return Math.max(l1 , l2);
                }
                else
                {
                    return (Math.max(l1 , l2) + Math.min(r1 , r2)) / 2.0;
                }
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
        double ans = brute(arr1 , arr2);
        System.out.println("The median of two arrays is : " + ans);
        sc.close();

    }

}