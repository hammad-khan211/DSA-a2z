import java.util.*;
class RodCuttingProblem
{
    static int[] findMaxVal(int[] price)
    {
        int n = price.length;
        int[][] dp = new int[n][n + 1];
        for(int[] row : dp)
        {
            Arrays.fill(row , -1);
        }
        int ans1 =  recursion(n - 1 , 0 , price);
        int ans2 = memoization(n - 1 , 0 , price , dp);
        int ans3 = tabulation(price);
        int ans4 = spaceOptimizedTabulation(price);
        return new int[]{ans1 , ans2 , ans3 , ans4};
    }
    static int recursion(int index , int pieces , int[] price)
    {
        if(index == 0)
        {
            int available = price.length - pieces;
            return available * price[0];
        }
        int available = price.length - pieces;
        int take = Integer.MIN_VALUE;
        int nottake = 0 + recursion(index - 1 , pieces , price);
        if(available >= index + 1)
        {
            take = price[index] + recursion(index  , pieces + index + 1 , price);
        }
        return Math.max(nottake , take);
    }

    static int memoization(int index , int pieces , int[] price , int[][] dp)
    {
        if(index == 0)
        {
            int available = price.length - pieces;
            return available * price[0];
        }
        if(dp[index][pieces] != -1)
        {
            return dp[index][pieces];
        }
        int available = price.length - pieces;
        int take = Integer.MIN_VALUE;
        int nottake = 0 + memoization(index - 1 , pieces , price , dp);
        if(available >= index + 1)
        {
           take = price[index] + memoization(index  , pieces + index + 1 , price , dp);
        }
        dp[index][pieces] = Math.max(nottake , take);
        return dp[index][pieces];
    }

    static int tabulation(int[] price)
    {
        int n = price.length;
        int[][] dp = new int[n][n + 1];
        for(int j = 0 ; j <= n ; j++)
        {
            int available = n - j;
            dp[0][j] = available * price[0];
        }
        for(int i = 1 ; i < n ; i++)
        {
            for(int j = n ; j >= 0 ; j--)
            {
                int available = n - j;
                int take = Integer.MIN_VALUE;
                int nottake = 0 + dp[i - 1][j];
                if(available >= i + 1)
                {
                    take = price[i] + dp[i][j + i + 1];
                }
                dp[i][j] = Math.max(nottake , take); 
            }
        }
        return dp[n - 1][0];
    }

    static int spaceOptimizedTabulation(int[] price)
    {
        int n = price.length;
        int[] prev = new int[n + 1];
        for(int j = 0 ; j <= n ; j++)
        {
            int available = n - j;
            prev[j] = available * price[0];
        }
        for(int i = 1 ; i < n ; i++)
        {
            for(int j = n ; j >= 0 ; j--)
            {
                int available = n - j;
                int take = Integer.MIN_VALUE;
                int nottake = 0 + prev[j];
                if(available >= i + 1)
                {
                    take = price[i] + prev[j + i + 1];
                }
                prev[j] = Math.max(nottake , take); 
            }
        }
        return prev[0];
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of rod : ");
        int n = sc.nextInt();
        int[] price = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            System.out.print("Enter value of rod of length " + (i + 1) + " : ");
            price[i] = sc.nextInt();
            System.out.println();
        }
        int[] ans = findMaxVal(price);
        System.out.println("Max Value that can be achieved : " + ans[0] + " Using Recursion");
        System.out.println("Max Value that can be achieved : " + ans[1] + " Using Memoization");
        System.out.println("Max Value that can be achieved : " + ans[2] + " Using Tabulation");
        System.out.println("Max Value that can be achieved : " + ans[3] + " Using Space Optimized Tabulation");
    }
}
