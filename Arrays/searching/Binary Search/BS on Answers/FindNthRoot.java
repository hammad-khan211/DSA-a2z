import java.util.*;
class FindNthRoot
{
    static int findNthRootof(int n , int m) //tc O(n log m)
    {
        if(m == 0) return 0;
        long low = 1;
        long high = m;
        while(low <= high)
        {
            long mid = low + ((high - low) / 2);
            long p = 1;
            for(int i = 0 ; i < n ; i++)
            {
                p *= mid;
            }
            if(p == m) return (int)mid;
            if(p < m) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of N : ");
        int n = sc.nextInt();
        System.out.println("Enter the number : ");
        int m = sc.nextInt();
        int ans = findNthRootof(n , m);
        if(ans != -1)
        {
            System.out.println("The " + n + "th" + " root of " + m + " is : " + ans);    
        }
        else
        {
            System.out.println("The " + n + "th" + " root of " + m + " doesnt exist ");
        }
        sc.close();
    }
}