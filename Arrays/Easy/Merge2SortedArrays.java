import java.util.*;
class Merge2SortedArrays
{
    static int[] merge(int[] arr1 , int[] arr2) //Time Complexity O(n1 + n2) //Space Comlexity O(n1 + n2)
    {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] arr3 = new int[n1 + n2];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < n1 && j < n2)
        {
            if(arr1[i] < arr2[j])
            {
                arr3[k++] = arr1[i++];
            }
            else if(arr1[i] > arr2[j])
            {
                arr3[k++] = arr2[j++];
            }
            else{
                arr3[k++] = arr1[i++];
            }
        }
        while(i < n1)
        {
            arr3[k++] = arr1[i++];
        }
        while(j < n2)
        {
            arr3[k++] = arr2[j++];
        }
        return arr3;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the first array : ");
        int n1 = sc.nextInt();
        int[] nums1 = new int[n1];
        System.out.println("Enter the " + n1 + " number of array elements : ");
        for(int i = 0 ; i < n1 ; i++)
        {
            nums1[i] = sc.nextInt();
        }
        System.out.println("Enter the size of the second array : ");
        int n2 = sc.nextInt();
        int[] nums2 = new int[n2];
        System.out.println("Enter the " + n2 + " number of array elements : ");
        for(int i = 0 ; i < n2 ; i++)
        {
            nums2[i] = sc.nextInt();
        }
        int[] ans = merge(nums1 , nums2);
        System.out.println("Merged Array : ");
        for(int x : ans)
        {
            System.out.print(x + " ");
        }
    }
}