import java.util.*;
class PowXN
{
    static double pow(double x , int n)
    {
        if(n == 1)
        {
            return x;
        }

        if(n == 0)
        {
            return 1;
        }

        if(n < 0)
        {
            if(n == Integer.MIN_VALUE)
            {
                return 1 / (x * pow(x , Integer.MAX_VALUE));
            }
            n *= -1;
            return 1 / pow(x , n);
        }

        if(n % 2 == 0)
        {
            double temp = pow(x , n / 2);
            return temp * temp;
        }

        double temp = pow(x , n / 2);
        return x * temp * temp;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter x : ");
        double x = sc.nextDouble();
        System.out.println();
        System.out.print("Enter n : ");
        int n = sc.nextInt();
        double ans = pow(x , n);
        System.out.println(x + " ^ " + n + " -> " + ans);
        sc.close();
    }
}