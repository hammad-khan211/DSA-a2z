import java.util.*;
class IntersectionSortedArrays
{
    static ArrayList<Integer> intersectionBrute(int[] arr1 , int[] arr2) // Time O(n1 * n2) 
    {                                                                    // Space O(n2)
        int n1 = arr1.length;
        int n2 = arr2.length;
        ArrayList<Integer> res = new ArrayList<>();
        int[] visited = new int[n2];
        for(int i = 0 ; i < n1 ; i++)
        {
            for(int j = 0 ; j < n2 ; j++)
            {
                if(arr1[i] == arr2[j] && visited[j] == 0)
                {
                    res.add(arr1[i]);
                    visited[j] = 1;
                    break;
                }
                if(arr2[j] > arr1[i]) break;
            }
        }
        return res;
    }

    static ArrayList<Integer> intersectionOptimal(int[] arr1 , int[] arr2) // Time O(n1 + n2)
    {                                                                     //Space O(1)
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0;
        int j = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while(i < n1 && j < n2)
        {
            if(arr1[i] < arr2[j])
            {
                i++;
            }
            else if(arr1[i] > arr2[j])
            {
                j++;
            }
            else
            {
                if(res.size() == 0 || res.get(res.size() - 1) != arr1[i])
                {
                    res.add(arr1[i]);
                }
                i++;
                j++;
            }
        }
        return res;

    }




    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the first array : ");
        int n1 = sc.nextInt();
        int[] nums1 = new int[n1];
        System.out.println("Enter the " + n1 + " number of array 1 elements : ");
        for(int i = 0 ; i < n1 ; i++)
        {
            nums1[i] = sc.nextInt();
        }
        System.out.print("Enter the size of the second array : ");
        int n2 = sc.nextInt();
        int[] nums2 = new int[n2];
        System.out.println("Enter the " + n2 + " number of array 2 elements : ");
        for(int i = 0 ; i < n2 ; i++)
        {
            nums2[i] = sc.nextInt();
        }
        
        ArrayList<Integer> resultBrute = intersectionBrute(nums1 , nums2);
        ArrayList<Integer> resultOptimal = intersectionOptimal(nums1 , nums2);
        System.out.println("Intersection of two arrays 1 and 2 : " );
        for(int x : resultOptimal)
        {
            System.out.print(x + " ");
        }
    }        
}