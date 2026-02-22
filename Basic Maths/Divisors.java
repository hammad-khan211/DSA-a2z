import java.util.Scanner;
class Divisors{
    void printDivisors(int N)
    {
        //smaller divisrs like in 63 divisors are 1 2 3 4 6 9 12 18 36 , 1 2 3 4 6 are smaller divisors 
        for(int i = 1; i*i <= N; i++)
        {
            if(N % i == 0)
            {
            System.out.print(i + " ");
            }
        }

        //larger divisors
        for(int i = (int)Math.sqrt(N); i >= 1; i--)
        {
            if(N % i == 0 && i != N / i)
            {
                System.out.print(N/i + " ");
            }
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any number : ");
        int num = sc.nextInt();


        Divisors obj = new Divisors();
        obj.printDivisors(num);
    }
}