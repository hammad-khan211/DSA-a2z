import java.util.*;
class MaximumDepthOfParenthesis
{
    static int findMaxDepthOfParenthesis(String s)
    {
        int count = 0;
        int ans = 0;
        for(int i = 0 ; i < s.length() ; i++)
        {
            if(s.charAt(i) == '(')
            {
                count++;
                if(ans < count)
                {
                    ans = count;
                }
            }
            else if(s.charAt(i) == ')')
            {
                count--;
            }
        }
        return ans;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first string : ");
        String s = sc.nextLine();
        int ans = findMaxDepthOfParenthesis(s);
        System.out.println(ans);
    }
}