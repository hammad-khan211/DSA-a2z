import java.util.*;
class LeastCapacityToShipPackagesWithinDdays//lc 1011
{
    static int findLeastCapacity(int[] weights , int days) // tc O(n log(sum - max))  sc O(1)
    {
        int sum = 0;
        int max = weights[0];
        for(int weight : weights)
        {
            sum += weight;
            max = Math.max(max , weight);
        }
        int low = max;
        int high = sum;
        while(low <= high)
        {
            int mid = low + ((high - low) / 2);
            if(isValidCapacity(weights , days , mid))
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return low;
    }

    static boolean isValidCapacity(int[] weights , int days , int cap)
    {
        int load = 0;
        int currentDays = 1;
        for(int weight : weights)
        {
            if(load + weight > cap)
            {
                currentDays++;
                load = weight;
            }
            else
            {
                load += weight;
            }
        }
        return currentDays <= days;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the weight of each item : ");
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the days within which you want package delivered : ");
        int h = sc.nextInt();
        int ans = findLeastCapacity(arr, h);
        System.out.println("The Ship weight capacity should be : " + ans + " for the items to be delivered within " + h + " days");
        sc.close();

    }   

}