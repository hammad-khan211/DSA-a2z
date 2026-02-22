import java.util.Scanner;
class Fibonacci{
    int findfibo(int N)
    {
        if(N == 0)
        {
            return 0;
        }
        else if(N == 1)
        {
            return 1;
        }
        else
        {
            return findfibo(N - 1) + findfibo(N - 2);
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number : ");
        int num = sc.nextInt();
        Fibonacci obj = new Fibonacci();
        System.out.println("Fibonacci Series : ");
        for(int i = 0; i < num; i++)
        {
            System.out.print(obj.findfibo(i) + " ");
        }   
        sc.close(); 
    }
}