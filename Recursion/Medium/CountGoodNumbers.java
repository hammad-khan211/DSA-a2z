import java.util.*;
class CountGoodNumbers
{
    static int countGoodNumbers(long n)
    {
        long ans = 1;
        int MOD = 1000000007;
        if(n % 2 == 0)
        {
            ans = (pow(5 , n / 2) * pow(4 , n / 2)) % MOD;
        }
        else
        {
            ans = (pow(5 , (n / 2) + 1) * pow(4 , n / 2)) % MOD;         
        }
        ans %= MOD;
        return (int) ans;
    }

    static long pow(long x , long n)
    {
        int MOD = 1000000007;
        if(n == 0)
        {
            return 1;
        }

        if(n % 2 == 0)
        {
            long temp = pow(x , n / 2);
            return (temp * temp) % MOD;
        }

        long temp = pow(x , n / 2);
        return (x * temp * temp) % MOD;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N : ");
        long n = sc.nextLong();
        int ans = countGoodNumbers(n);
        System.out.println(ans);
        sc.close();
    }
}