import java.util.Scanner;
class Factorial{
    int findfact(int N)
    {
        if(N == 0 || N == 1)
        {
            return 1;
        }
        else
        {
            return N * findfact(N - 1);
        }

    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int num = sc.nextInt();
        Factorial obj = new Factorial();
        int result = obj.findfact(num);
        System.out.println(result);

    }

}