import java.util.*;
class ATOI
{
    static int recursiveATOI(String s) //tc O(N) sc O(N)
    {
        int i = 0;
        int n = s.length();
        int sign = 1;
        while(i < n && s.charAt(i) == ' ')
        {
            i++;
        }
        if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-'))
        {
            if(s.charAt(i) == '-')
            {
                sign = -1;
            }
            i++;
        }
        return helper(s , i , sign , 0);
    }

    static int helper(String s , int i , int sign , int number)
    {
        if(i == s.length() || (!Character.isDigit(s.charAt(i))))
        {
            return number * sign;
        }
        int digit = s.charAt(i) - '0';
        if(number > Integer.MAX_VALUE / 10 || (number == Integer.MAX_VALUE / 10 && digit > 7))
        {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        number = number * 10 + digit;
        return helper(s , i + 1 , sign , number);
    }

    static int bruteATOI(String s) //tc O(N)  //sc O(1)
    {
        int n = s.length();
        int sign = 1;
        int i = 0;
        int ans = 0;

        //skip leading spaces
        while(i < n && s.charAt(i) == ' ')
        {
            i++;
        }

        //check sign
        if(i < n && ( s.charAt(i) == '+' || s.charAt(i) == '-' ))
        {
            if(s.charAt(i) == '-')
            {
                sign = -1;
            }
            i++;
        }

        //read digits
        while(i < n && Character.isDigit(s.charAt(i)))
        {
            int digit = s.charAt(i) - '0';

            //overflow
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
        System.out.println("Enter any string");
        String str = sc.nextLine();
        int ans = recursiveATOI(str);
        System.out.println(ans);
    }
}