import java.util.*;
class StringToInteger //lc 8
{
    static int convertStringToInt(String s)
    {
        int ans = 0;
        int n = s.length();
        int sign = 1;
        int i = 0;

        //leading spaces
        while(i < n && s.charAt(i) == ' ')
        {
            i++;
        }

        //check sign
        if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-' ))
        {
            if(s.charAt(i) == '-')
            {
                sign = -1;
            }
            i++;
        }

        //check digits
        while(i < n && Character.isDigit(s.charAt(i)))
        {
            int digit = s.charAt(i) - '0';

            //check overflow
            if(ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && digit > 7))
            {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + digit;
            i++;
        }

        return ans * sign;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string : ");
        String str = sc.nextLine();
        int ans = convertStringToInt(str);
        System.out.println(ans);
    }
}