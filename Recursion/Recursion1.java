import java.util.Scanner;
class Recursion1{
    void printName(int N)
    {
        if(N == 0)
        {
            return;
        }
        else
        {
            System.out.println("Hammad");
            printName(N-1);
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of times you want to print the name : ");
        int num = sc.nextInt();
        Recursion1 obj = new Recursion1();
        obj.printName(num);

    }

}