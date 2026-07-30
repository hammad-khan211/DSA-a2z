import java.util.*;
class ReverseWordsInAString
{
    static String optimal(String s)
    {
        int i = s.length() - 1;
        StringBuilder ans = new StringBuilder();
        while(i >= 0)
        {
            while(i >= 0 && s.charAt(i) == ' ')
            {
                i--;
            }

            if(i < 0) break;

            int j = i;
            while(j >= 0 && s.charAt(j) != ' ')
            {
                j--;
            }

            if(ans.length() > 0)
            {
                ans.append(' ');
                ans.append(s.substring(j + 1 , i + 1));
            }
            else
            {
                ans.append(s.substring(j + 1 , i + 1));
            }

            i = j - 1;
        }
        return ans.toString();
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any string : ");
        String str = sc.nextLine();
        String ans = optimal(str);
        System.out.println(" String after reversing words : " + ans);
        sc.close();
    }
}