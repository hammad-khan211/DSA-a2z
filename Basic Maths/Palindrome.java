import java.util.Scanner;
class Palindrome
{
    boolean isPalindrome(int N)
    {
        int original = N;
        int rev = 0;
        while(N > 0)
        {
            int lastDigit = N % 10;
            N /= 10;
            rev = (rev * 10) + lastDigit;
        }
        if(rev == original)
        {
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String args[])
    {
        System.out.print("Enter any number : ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        Palindrome obj = new Palindrome();
        boolean result = obj.isPalindrome(num);

        System.out.print(result);


    }
}