import java.util.Scanner;
class Prime
{
    boolean isPrime(int N)
    {
        int count = 0;
        for(int i = 1; i*i <= N; i++)
        {
            if(N % i == 0)
            {
                count++;
                if(i != N/i)
                {
                   count++;
                }
            }    
        }
        if(count == 2){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Prime obj = new Prime();
        System.out.print("Enter any digit : ");
        int num = sc.nextInt();
        boolean result = obj.isPrime(num);
        System.out.println(result);
    }

}