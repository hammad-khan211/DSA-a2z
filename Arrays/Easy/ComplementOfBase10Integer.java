import java.util.Scanner;
class ComplementOfBase10Integer
{
    static int findComplement(int n)
    {
        int mask = (1 << (Integer.toBinaryString(n).length())) - 1;
        return mask ^ n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = sc.nextInt();
        int ans = findComplement(n);
        System.out.println("Complement of " + n + " is : " + ans);
    }
}

