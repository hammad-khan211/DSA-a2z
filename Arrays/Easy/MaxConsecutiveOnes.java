import java.util.Scanner;
class MaxConsecutiveOnes
{
    static int maxConsecutiveOnes(int[] arr) //Time O(N) space O(1)
    {
        int N = arr.length;
        int maxCount = 0;
        int count = 0;
        for(int i = 0 ; i < N ; i++)
        {
            if(arr[i] == 1)
            {
                count++;
            }
            else{
                count = 0;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
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
        int result = maxConsecutiveOnes(nums);
        System.out.println("The maximum consecutive numbber of Ones are : " + result);
        sc.close();
    }
}