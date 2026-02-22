import java.util.Scanner;
class Armstrong{
    boolean isArmstrong(int N)
    {
        int temp = N;
        int original = N;
        int digits = 0;
        while(N > 0)
        {
            digits++;
            N /= 10;
            
        }
        N = temp;
        int arm = 0;
        while(N > 0)
        {
            int lastDigit = N % 10;
            arm += Math.pow(lastDigit , digits);
            N /= 10;
        }

        if(arm == original)
        {
            return true;
        }
        else{
            return false;
        }

        
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Eneter any digit : ");
        int num = sc.nextInt();

        Armstrong obj = new Armstrong();

        boolean result = obj.isArmstrong(num);
        System.out.println(result);
    }

}