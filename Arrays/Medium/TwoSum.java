    import java.util.*;
    class TwoSum
    {
        static int[] checkTwoSumBrute(int[] arr , int target)//Time O(n^2) Space O(1)
        {
            int n = arr.length;
            for(int i = 0 ; i < n ; i++)
            {
                for(int j = i + 1 ; j < n ; j++)
                {
                    if(arr[i] + arr[j] == target)
                    {
                        return new int[]{i , j};
                    }
                }
            }
            return new int[]{-1,-1};
        }

        static int[] checkTwoSumBetter(int[] arr , int target) //TIme O(n log n) Space O(1)
        {                                                     //SPECIAL CASE , USED ONLY WHEN INDICES ARE NOT ASKED IN OUPUT AND TRUE / FLASE OR ELEMENTS ARE ASKED IN OUPUT
            int left = 0 ;                                                     //IN THAT CASE IT TAKES THE LEAST MEMORY 
            int right = arr.length - 1;
            Arrays.sort(arr);
            while(left < right)
            {
                if(arr[left] + arr[right] == target)
                {
                    return new int[]{arr[left] , arr[right]};
                }
                else if(arr[left] + arr[right] < target)
                {
                    left++;
                }
                else
                {
                    right--;
                }
            }
        return new int[]{-1 , -1};
        }                                                     
        static int[] checkTwoSumOptimal(int[] arr , int target) //Time O(n) Space O(n)
        {
            int n = arr.length;
            HashMap < Integer , Integer > mpp = new HashMap<>();
            for(int i = 0 ; i < n ; i++)
            {
                if(mpp.containsKey(target - arr[i]))
                {
                    return new int[]{mpp.get(target - arr[i]) , i};
                }
                mpp.put(arr[i] , i);
            }
            return new int[]{-1 , -1};
        }
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the size of the array : ");
            int size = sc.nextInt();
            int[] nums = new int[size];
            System.out.println("Enter the " + size + " number of array elements : ");
            for(int i = 0 ; i < size ; i++)
            {
                nums[i] = sc.nextInt();
            }
            System.out.println("Enter the target sum : ");
            int t = sc.nextInt();
            int[] resultBrute = checkTwoSumBrute(nums, t);
            System.out.println("Indices of elements adding up to " + t + " using brute approach are : ");
            for(int ans : resultBrute){
                System.out.print(ans + " ");
            }
            System.out.println(" ");
            // int[] resultOptimal = checkTwoSumOptimal(nums, t);
            // System.out.println("Indices of elements adding up to " + t + " using optimal approach are : ");

            // for(int ans : resultOptimal){
            //     System.out.print(ans + " ");
            // }

            // System.out.println(" ");
            // System.out.println(" Elements that are adding up to " + t + " using better approach are : ");
            // int[] resultBetter = checkTwoSumBetter(nums, t); // returns elements unlike brute and optimal
            // for(int ans : resultBetter)
            // {
            //     System.out.print(ans + " ");
            // }
            sc.close();
        }

        }
