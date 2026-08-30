import java.util.*;
class LCS 
{
    static int[] findLCS(String s1 , String s2)
    {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1][n2];
        for(int[] row : dp)
        {
            Arrays.fill(row , -1);
        }
        int ans1 = recursion(n1 - 1 , n2 - 1 , s1 , s2);
        int ans2 = memoization(n1 - 1 , n2 - 1 , s1 , s2 , dp);
        int ans3 = tabulation(s1 , s2);
        int ans4 = spaceOptimizedTabulation(s1 , s2);
        return new int[]{ans1 , ans2 , ans3 , ans4};
    }

    static int recursion(int index1 , int index2 , String s1 , String s2) 
    {
        if(index1 < 0 || index2 < 0)
        {
            return 0;
        }
        if(s1.charAt(index1) == s2.charAt(index2))
        {
            return 1 + recursion(index1 - 1 , index2 - 1 , s1 , s2);
        }
        return Math.max(recursion(index1 - 1 , index2 , s1 , s2) , recursion(index1 , index2 - 1 , s1 , s2));
    }

    static int memoization(int index1 , int index2 , String s1 , String s2 , int[][] dp)
    {
        if(index1 < 0 || index2 < 0)
        {
            return 0;
        }
        if(dp[index1][index2] != -1)
        {
            return dp[index1][index2];
        }
        if(s1.charAt(index1) == s2.charAt(index2))
        {
            dp[index1][index2] = 1 + memoization(index1 - 1 , index2 - 1 , s1 , s2 , dp);
        }
        else
        {
            dp[index1][index2] = Math.max(memoization(index1 - 1 , index2 , s1 , s2 , dp) , memoization(index1 , index2 - 1 , s1 , s2 , dp));
        }
        return dp[index1][index2];
    }

    static int tabulation(String s1 , String s2)
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
                    dp[i][j] = Math.max(dp[i][j - 1] , dp[i - 1][j]);
                }
            }
        }
        return dp[n1][n2];
    }

    static int spaceOptimizedTabulation(String s1 , String s2)
    {
        int n1 = s1.length();
        int n2 = s2.length();
        int[] prev = new int[n2 + 1]; //extra size of dp for index shifting to fulfill -1 base condition
        for(int i = 1 ; i <= n1 ; i++)
        {
            int[] temp = new int[n2 + 1];
            for(int j = 1 ; j <= n2 ; j++)
            {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                {
                    temp[j] = 1 + prev[j - 1];
                }
                else
                {
                    temp[j] = Math.max(temp[j - 1] , prev[j]);
                }
            }
            prev = temp;
        }
        return prev[n2];
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first string : ");
        String s1 = sc.nextLine();
        System.out.println("Enter second string : ");
        String s2 = sc.nextLine();
        int[] ans = findLCS(s1, s2);
        System.out.println("LCS of " + s1 + " and " + s2 + " is : " + ans[0] + " Using Recursion");
        System.out.println("LCS of " + s1 + " and " + s2 + " is : " + ans[1] + " Using Memoization");
        System.out.println("LCS of " + s1 + " and " + s2 + " is : " + ans[2] + " Using Tabulation");
        System.out.println("LCS of " + s1 + " and " + s2 + " is : " + ans[3] + " Using Space Optimized Tabulation");
    }
}
