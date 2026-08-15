import java.util.Scanner;
class Recursion3{
    void printNtoONE(int N)
    {
        if(N == 0)
        {
            return;
        }
        else
        {
            System.out.println(N);
            printNtoONE(N-1);
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int num = sc.nextInt();
        Recursion3 obj = new Recursion3();
        obj.printNtoONE(num);

    }

}