import java.util.*;
class printLCS  //longest common subsequence
{
    static String findLCS(String s1 , String s2)
    {
        return tabulation(s1 , s2);
    }

    static String tabulation(String s1 , String s2)
    {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1]; //extra size of dp for index shifting to fulfill -1 base condition

        for(int i = 1 ; i <= n1 ; i++)
        {
            for(int j = 1 ; j <= n2 ; j++)
            {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else
                {
                    dp[i    ][j] = Math.max(dp[i][j - 1] , dp[i - 1][j]);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        int i = n1;
        int j = n2;
        while(i > 0 && j > 0)
        {
            if(s1.charAt(i - 1) == s2.charAt(j - 1))
            {
                ans.append(s1.charAt(i - 1));
                i--;
                j--;
            }
            else if(dp[i][j - 1] > dp[i - 1][j])
            {
                j--;
            }
            else
            {
                i--;
            }
        }
        return ans.reverse().toString();
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first string : ");
        String s1 = sc.nextLine();
        System.out.println("Enter second string : ");
        String s2 = sc.nextLine();
        String ans = findLCS(s1, s2);
        System.out.println("LCS of " + s1 + " and " + s2 + " is : " + ans + " Using Tabulation");
    }
}
