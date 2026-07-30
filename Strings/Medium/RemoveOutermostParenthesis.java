import java.util.*;
class RemoveOutermostParenthesis //lc1021
{
    static String optimal(String s)
    {
        int count = 0;
        StringBuilder ans = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++)
        {
            if(s.charAt(i) == ')')
            {
                count--;
            }
            if(count != 0)
            {
                ans.append(s.charAt(i));
            }
            if(s.charAt(i) == '(')
            {
                count++;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string with valid parenthesis : ");
        String str = sc.nextLine();
        String ans = optimal(str);
        System.out.println(str + " after removing outer most parenthesis is : " + ans);
        sc.close();
    }
}