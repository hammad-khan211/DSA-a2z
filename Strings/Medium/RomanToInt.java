import java.util.*;
class RomanToInt
{
    static int romanToInt(String S)
    {
        int value = 0;
        for(int i = 0 ; i < S.length() ; i++)
        {
            int current = value(S.charAt(i));
            if(i < S.length() - 1 && current < value(S.charAt(i + 1)))
            {
                value -= current;
            }
            else{
                value += current;
            }
        }
        return value;
    }

    static int value(char c)
    {
        switch(c)
        {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
        }
        return 0;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string : ");
        String str = sc.next();
        int ans = romanToInt(str);
        System.out.println(str + " : " + ans);
    }
}