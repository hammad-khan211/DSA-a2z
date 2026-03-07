import java.util.*;
class FourSum
{
    static  List < List < Integer > > brute4Sum(int[] nums , int target) //time O(n^4 log n) space O(n)
    {
        int n = nums.length;
        List < List < Integer > > result = new ArrayList<>();
        Set < List < Integer > > unique = new HashSet<>();
        for(int i = 0 ; i < n - 3 ; i++)
        {
            for(int j = i + 1 ; j < n - 2; j++)
            {
                for(int k = j + 1 ; k < n - 1; k++)
                {
                    for(int l = k + 1 ; l < n ; l++)
                    {
                        List < Integer > temp = new ArrayList<>();
                        if(nums[i] + nums[j] + nums[k] + nums[l] == target)
                        {
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            temp.add(nums[l]);
                            Collections.sort(temp);
                            unique.add(temp);
                        }
                    }
                }
            }
        }
        for(List < Integer > X : unique)
        {
            result.add(X);
        }
        return result;
    }

    static List < List < Integer > > better4Sum(int[] nums , int target) //time O(n^3 log n) space O(n)
    {
        int n = nums.length;
        List < List < Integer > > result = new ArrayList<>();
        Set < List < Integer > > unique = new HashSet<>();
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = i + 1 ; j < n ; j++)
            {
                Set < Integer > hash = new HashSet<>();
                for(int k = j + 1 ; k < n ; k++)
                {
                    int l = target - ( nums[i] + nums[j] + nums[k]);

                    if(hash.contains(l))
                    {
                        List < Integer > temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(l);
                        Collections.sort(temp);
                        unique.add(temp);
                    }

                    hash.add(nums[k]);
                }
            }
        }
        for(List < Integer > X : unique)
        {
            result.add(X);
        }
        return result;
    }

    static List < List < Integer > > optimal4Sum(int[] nums , int target) //time(n^3) space O(1)
    {
        List < List < Integer > > result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0 ; i < n - 3 ; i++)
        {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1 ; j < n - 2 ; j++)
            {
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int k = j + 1;
                int l = n - 1;
                while(k < l)
                {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if(sum == target)
                    {
                        List < Integer > temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        result.add(temp);
                        k++;
                        l--;
                        while(k < l && nums[k] == nums[k - 1]) k++;
                        while(k < l && nums[l] == nums[l + 1]) l--;

                    }
                    else if(sum > target)
                    {
                        l--;
                    }
                    else{
                        k++;
                    }
                }
            }
        }
        return result;
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
        System.out.println("Enter the target value : ");
        int x = sc.nextInt();
        List < List < Integer > > answer = optimal4Sum(arr, x);
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