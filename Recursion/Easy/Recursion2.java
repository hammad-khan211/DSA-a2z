import java.util.Scanner;
class Recursion2{
    void printONEtoN(int N)
    {
        if(N == 0)
        {
            return;
        }
        else
        {
            printONEtoN(N-1);
            System.out.println(N);
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int num = sc.nextInt();
        Recursion2 obj = new Recursion2();
        obj.printONEtoN(num);

    }

}