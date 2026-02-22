import java.util.Scanner;
class SumOfNnumbers{
    int sum(int N)
    {
        if(N == 0)
        {
            return 0;
        }
        else{
            return N + sum(N - 1);
        }

    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int num = sc.nextInt();
        SumOfNnumbers obj = new SumOfNnumbers();
        int result = obj.sum(num);
        System.out.println(result);

    }

}