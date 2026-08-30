import java.util.*;
class LCSub //longest common substring
{
    static String findLCSub(String s1 , String s2)
    {
        return tabulation(s1 , s2);
    }

    static String tabulation(String s1 , String s2)
    {
        int n1 = s1.length();
        int n2 = s2.length();
        int ans = 0;
        int endi = -1;
        int[][] dp = new int[n1 + 1][n2 + 1]; //extra size of dp for index shifting to fulfill -1 base condition

        for(int i = 1 ; i <= n1 ; i++)
        {
            for(int j = 1 ; j <= n2 ; j++)
            {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if(ans < dp[i][j])
                    {
                        ans = dp[i][j];
                        endi = i;
                    }
                }
            }
        }
        StringBuilder str = new StringBuilder();
        int i = endi;
        while(ans > 0)
        {
            str.append(s1.charAt(i - 1));
            i--;
            ans--;
        }
        return str.reverse().toString();
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first string : ");
        String s1 = sc.nextLine();
        System.out.println("Enter second string : ");
        String s2 = sc.nextLine();
        String ans = findLCSub(s1, s2);
        System.out.println("Longest Common SubString of " + s1 + " and " + s2 + " is => " + ans + " of length : " + ans.length());
    }
}
