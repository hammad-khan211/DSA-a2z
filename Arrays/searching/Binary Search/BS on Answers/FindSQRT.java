import java.util.*;
class FindSQRT
{
    static int findSquareRoot(int x) //tc O(log x)
    {
        if(x == 0) return 0;
        long low = 1;
        long high = (x / 2) + 1;
        while(low <= high)
        {
            long mid = low + ((high - low) / 2);
            long p = mid * mid;
            if(p <= x)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return (int)high;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n = sc.nextInt();
        int ans = findSquareRoot(n);
        System.out.println("The floor square root of " + n + " is : " + ans);
        sc.close();

    }
}