import java.util.*;
class UnionSortedArrays
{
    static Set<Integer> UnionBrute(int[] arr1 , int[] arr2) // Time O(n1 + n2)
    {                                                       // space O(n1 + n2)
        Set<Integer> temp = new HashSet<>();                // Doest not maintain the order , the resultant union could be unsorted
        for(int i = 0 ; i < arr1.length ; i++)
        {
            temp.add(arr1[i]);
        }
        for(int i = 0 ; i < arr2.length ; i++)
        {
            temp.add(arr2[i]);
        }
        return temp;
    }

    static ArrayList<Integer> UnionOptimal(int[] arr1 , int[] arr2) // Time O(n1 + n2)
    {                                                              // Space O(1)
        int n1 = arr1.length;                                     //the resultant union is sorted
        int n2 = arr2.length;
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0 , j = 0;
        while(i < n1 && j < n2)
        {
            int val;
            if(arr1[i] < arr2[j])
            {
                val = arr1[i++];
            }
            else if(arr1[i] > arr2[j])
            {
                val = arr2[j++];
            }
            else
            {
                val = arr2[j++];
                i++;
            }
            if(res.size() == 0 || res.get(res.size() - 1) != val)
            {
                res.add(val);
            }
        }
        while(i < n1)
        {
            if(res.size() == 0 || arr1[i] != res.get(res.size() - 1))
            {
                res.add(arr1[i]);
            }
            i++;
        }
        while(j < n2)
        {
            if(res.size() == 0 || res.get(res.size() - 1) != arr2[j])
            {
                res.add(arr2[j]);
            }
            j++;
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
        
        Set<Integer> resultBrute = UnionBrute(nums1 , nums2);
        ArrayList<Integer> resultOptimal = UnionOptimal(nums1 , nums2);
        System.out.println("Union of two arrays 1 and 2 : " );
        for(int x : resultOptimal)
        {
            System.out.print(x + " ");
        }
    }    
}