import java.util.Scanner;
class GreatestCOmmonDivisor{
    int gcd(int a, int b)
    {
        while(a > 0 && b > 0)
        {
            if(a > b)
            { 
                a %= b;
            }
            else{
                b %= a;
            }
        }
        if(a == 0)
        {
            return b;
        }
        else
        {
            return a;
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the two numbers : ");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        GreatestCOmmonDivisor obj = new GreatestCOmmonDivisor();
        int result = obj.gcd(n1,n2);
        System.out.println("GCD of " + n1 + " and " + n2 + " is " + result);
    }
}