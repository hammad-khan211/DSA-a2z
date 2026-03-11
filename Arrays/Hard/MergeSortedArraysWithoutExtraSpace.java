import java.util.*;
class MergeSortedArraysWithoutExtraSpace
{
    static void bruteMerge(int[] nums1 , int[] nums2) //Time Complexiy : (n + m) Space Complexity O(n + m)
    {
        int n = nums1.length;
        int m = nums2.length;
        int[] nums3 = new int[n + m];
        int i = 0; 
        int j = 0; 
        int k = 0;
        while(i < n && j < m)
        {
            if(nums1[i] <= nums2[j])
            {
                nums3[k++] = nums1[i++];
            }
            else
            {
                nums3[k++] = nums2[j++];
            }
        }
        while(i < n)
        {
            nums3[k++] = nums1[i++];
        }
        while(j < m)
        {
            nums3[k++] = nums2[j++];
        }
        for(i = 0 ; i < n + m ; i++)
        {
            if(i < n) nums1[i] = nums3[i];
            else nums2[i - n] = nums3[i];
        }

        System.out.println("Array 1 : ");
        for(i = 0 ; i < n ; i++)
        {
            System.out.print(nums1[i] + " ");
        }
        System.out.println("");
        System.out.println("Array 2 : ");
        for(j = 0 ; j < m ; j++)
        {
            System.out.print(nums2[j] + " ");
        }
    }

    static void optimalMerge(int[] nums1 , int[] nums2) //Time Complexiy : O( Min(n , m) + n log n + m log m) // Space Complexity O(1)
    {
        int n = nums1.length;
        int m = nums2.length;
        int i = n - 1;
        int j = 0;
        while(i >= 0 && j < m)
        {
            if(nums1[i] > nums2[j])
            {
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                i--;
                j++;
            }
            else{
                break;
            }
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        System.out.println("Array 1 : ");
        for(i = 0 ; i < n ; i++)
        {
            System.out.print(nums1[i] + " ");
        }
        System.out.println("");
        System.out.println("Array 2 : ");
        for(j = 0 ; j < m ; j++)
        {
            System.out.print(nums2[j] + " ");
        }
    }

    static void swapIfGreater(int[] arr1 , int[] arr2 , int i , int j)
    {
        if(arr1[i] > arr2[j])
        {
            int temp = arr1[i];
            arr1[i] = arr2[j];
            arr2[j] = temp;
        }
    }

    static void optimal2Merge(int[] nums1 , int[] nums2)
    {
        int n = nums1.length;
        int m = nums2.length;
        int len = n + m;
        int gap = (len / 2) + (len % 2);
        while(gap > 0)
        {
            int left = 0;
            int right = left + gap;
            while(right < len)
            {
                if(left < n && right >= n) //arr1 and arr2
                {
                    swapIfGreater(nums1, nums2, left , right - n);
                }
                else if(left >= n) //arr2 and arr2
                {
                    swapIfGreater(nums2, nums2, left - n , right - n);
                }
                else //arr1 and arr1
                {
                    swapIfGreater(nums1, nums1, left , right);
                }
                left++;
                right++;
            }
            if(gap == 1 ) break;
            gap = ( gap / 2 ) + ( gap % 2);
        }
        System.out.println("Array 1 : ");
        for(int i = 0 ; i < n ; i++)
        {
            System.out.print(nums1[i] + " ");
        }
        System.out.println("");
        System.out.println("Array 2 : ");
        for(int j = 0 ; j < m ; j++)
        {
            System.out.print(nums2[j] + " ");
        }
    }


    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the first array : ");
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        System.out.println("Enter the " + n + " number of elements in sorted order : ");
        for(int i = 0 ; i < n ; i++)
        {
            arr1[i] = sc.nextInt();
        }
        System.out.println("Enter the size of the second array : ");
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        System.out.println("Enter the " + m + " number of elements in sorted order : ");
        for(int i = 0 ; i < m ; i++)
        {
            arr2[i] = sc.nextInt();
        }
        optimal2Merge(arr1, arr2);
    }
}