import java.util.*;
class MinimumDaysToMakeMBouquets //lc 1482
{
    static int findMinimumDays(int[] bloomDay , int m , int k) //tc O(n * log(max - min + 1))
    {
        if((long) m * k > bloomDay.length) return -1;
        int min = bloomDay[0];
        int max = bloomDay[0];
        for(int x : bloomDay)
        {
            min = Math.min(min , x);
            max = Math.max(max , x);
        }
        int low = min;
        int high = max;
        while(low <= high)
        {
            int mid = low + ((high - low) / 2);
            if(canBouquetForm(bloomDay , m , k , mid))
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

    static boolean canBouquetForm(int[] bloomDay , int m , int k , int day)
    {
        int readyBouquet = 0;
        int count = 0;
        for(int i = 0 ; i < bloomDay.length ; i++)
        {
            if(day >= bloomDay[i])
            {
                count++;
            }
            else
            {
                readyBouquet += count / k;
                count = 0;
            }
        }
        readyBouquet += count / k;
        return readyBouquet >= m;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of flowers : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the number of days for every flower to bloom in respective order : ");
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the no. of bouquets to be formed : ");
        int m = sc.nextInt();
        System.out.println("Enter the no. of adjacent flowers in every bouquet : ");
        int k = sc.nextInt();
        int ans = findMinimumDays(arr, m, k);
        if(ans != -1)
        {
            System.out.println("Minimum Days required to make " + m + " bouquets with " + k + " adjacent flowers are : " + ans);
        }
        else
        {
            System.out.println("Not possible , flowers are less");
        }

        sc.close();

    }   
}