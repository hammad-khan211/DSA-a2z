import java.util.*;
class ThreeSum
{
    static List < List < Integer > > find3SumBrute(int[] nums) //Time Complexity O(n^3 log n) Space Complexity O(n)
    {
        List < List < Integer > > triplets = new ArrayList<>();
        Set < List < Integer > > unique = new HashSet<>();
        int n = nums.length;
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = i + 1 ; j < n ; j++)
            {
                for(int k = j + 1 ; k < n ; k++)
                {
                    if(nums[i] + nums[j] + nums[k] == 0)
                    {
                        List < Integer > temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        Collections.sort(temp);
                        unique.add(temp);
                    }
                }
            }
        }
        for(List < Integer > X : unique)
        {
            triplets.add(X);
        }
        return triplets;
    }

    static List < List < Integer > > find3SumBetter(int[] nums) //Time Complexity O(n^2 log n) Space Complexity O(n)
    {
        int n = nums.length;
        List < List < Integer > > triplets = new ArrayList<>();
        Set < List < Integer > > unique = new HashSet<>();
        for(int i = 0 ; i < n ; i++)
        {
            Set < Integer > hash = new HashSet<>();
            for(int j = i + 1 ; j < n ; j++)
            {
                int k = - ( nums[i] + nums[j] );

                if(hash.contains(k))
                {
                    List < Integer > temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(k);
                    Collections.sort(temp);
                    unique.add(temp);
                }

                hash.add(nums[j]);
            }
        }
        for(List < Integer > X : unique)
        {
            triplets.add(X);
        }
        return triplets;
    }

    static List < List < Integer > > find3SumOptimal(int[] nums)//Time Complexity O(n^2) Space COmplexity O(n)
    {
        int n = nums.length;
        Arrays.sort(nums);
        List < List < Integer > > triplets = new ArrayList<>();
        for(int i = 0 ; i < n ; i++)
        {
            if(i > 0 && nums[i]  == nums[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;
            while(j < k)
            {
                if(nums[i] + nums[j] + nums[k] < 0)
                {
                    j++;
                }
                else if(nums[i] + nums[j] + nums[k] == 0)
                {
                    List < Integer > temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    triplets.add(temp);
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j - 1]) j++;
                    while(j < k && nums[k] == nums[k + 1]) k--;
                } 
                else{
                    k--;
                }
            }
        }
        return triplets;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the " + size + " number of array elements : ");
        for(int i = 0 ; i < size ; i++)
        {
            arr[i] = sc.nextInt();
        }
        List < List < Integer > > answer = find3SumOptimal(arr);
        System.out.println("------------------------------------------------------------");
        for(List < Integer > X : answer)
        {
            for(int Y : X)
            {
                System.out.print(Y + " ");
            }
            System.out.println("");
        }
        sc.close();
    }
}