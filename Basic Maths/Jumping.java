import java.util.Scanner;
class Jumping{
    static boolean isJumping(int N){
        if(N < 10)
        {
            return true;
        }
        else
        {
            while(N > 0)
            {
                int lastDigit = N % 10;
                N /= 10;
                if(N > 0)
                {
                    int slastDigit = N % 10;
                    if(Math.abs(slastDigit - lastDigit) != 1)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int X = sc.nextInt();
        Jumping obj = new Jumping();
        boolean result = obj.isJumping(X);
        System.out.println("Is " + X + " a Jumping Number ? : " + result);
    }
}