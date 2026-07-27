import java.util.*;
class KokoEatingBananas  //lc 875
{
    static int brute(int[] piles , int h) //tc O(n * max) //sc O(1)
    {
        int max = piles[0];
        for(int pile : piles)
        {
            max = Math.max(max , pile);
        }

        for(int k = 1 ; k <= max ; k++)
        {
            long hour = 0;
            for(int pile : piles)
            {
                hour += (pile + k - 1) / k;
            }
            if(hour <= h)
            {
                return k;
            }
        }
        return -1;
    }

    static int optimal(int[] piles , int h) //tc O(n log(max)) //sc O(1)
    {
        int max = piles[0];
        for(int pile : piles)
        {
            max = Math.max(max , pile);
        }
        int low = 1;
        int high = max;
        while(low <= high)
        {
            int mid = low + ((high - low) / 2);
            if(checkSpeed(piles , mid , h))
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

    static boolean checkSpeed(int[] piles , int K , int h)
    {
        long hour = 0;
        for(int pile : piles)
        {
            hour += ((long) pile + K - 1) / K;
        }
        return hour <= h;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of piles : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the  number of bananas in every pile : ");
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the hours after which guards will come : ");
        int h = sc.nextInt();
        int ans = optimal(arr , h);
        System.out.println("Koko will eat : " + ans + " bananas per hour to finish all before guard comes within " + h + " hours");
        sc.close();

    }   
}