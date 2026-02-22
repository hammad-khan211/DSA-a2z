import java.util.Scanner;
class CountDigit
{
    int countdigit(int N)
    {
        int count = 0;
        while( N > 0)
        {
            int lastDigit = N % 10;
            count ++;
            N /= 10;   //Sincce N is getting divisible by 10 , time complexity = O(log base10(N))
        }
        return count;
    }

    //log technique
    int countdigitlog(int N)
    {
        if(N == 0){
            return 1; // special case
        }
        else{
            N = Math.abs(N);
            return (int)(Math.log10(N)) + 1;
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any number :");
        int num = sc.nextInt();
        CountDigit result = new CountDigit();
        int digits = result.countdigitlog(num);
        System.out.println("The number of digits in " + num + " are : " + digits);
        sc.close();

    }

}