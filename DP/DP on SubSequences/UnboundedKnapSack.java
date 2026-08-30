import java.util.*;
class UnboundedKnapSack
{
    static int[] findMaxVal(int W , int[] wt , int[] val)
    {
        int[][] dp = new int[wt.length][W + 1];
        for(int[] row : dp)
        {
            Arrays.fill(row , -1);
        }
        int ans1 =  recursion(wt.length - 1 , W , wt , val);
        int ans2 = memoization(wt.length - 1 , W , wt , val ,dp);
        int ans3 = tabulation(wt , val , W);
        int ans4 = spaceOptimizedTabulation(wt, val, W);
        return new int[]{ans1 , ans2 , ans3 , ans4};
    }
    static int recursion(int index , int W , int[] wt , int[] val)
    {
        if(index == 0)
        {
            if(wt[0] <= W)
            {
                return (W / wt[0]) * val[0];
            }
            return 0;
        }
        int take = 0;
        int nottake = 0 + recursion(index - 1 , W , wt , val);
        if(wt[index] <= W)
        {
            take = val[index] + recursion(index  , W - wt[index] , wt , val);
        }
        return Math.max(nottake , take);
    }

    static int memoization(int index , int W , int[] wt , int[] val , int[][] dp)
    {
        if(index == 0)
        {
            if(wt[0] <= W)
            {
                return (W / wt[0]) * val[0];
            }
            return 0;
        }
        if(dp[index][W] != -1)
        {
            return dp[index][W];
        }
        int take = 0;
        int nottake = 0 + memoization(index - 1 , W , wt , val , dp);
        if(wt[index] <= W)
        {
            take = val[index] + memoization(index , W - wt[index] , wt , val , dp);
        }
        dp[index][W] = Math.max(nottake , take);
        return dp[index][W];
    }

    static int tabulation(int[] wt , int[] val , int W)
    {
        int[][] dp = new int[wt.length][W + 1];
        for(int j = 0 ; j <= W ; j++)
        {
            if(wt[0] <= j)
            {
                dp[0][j] = (j / wt[0]) * val[0];
            }
            else
            {
                dp[0][j] = 0;
            }
        }
        for(int i = 1 ; i < wt.length ; i++)
        {
            for(int j = 0 ; j <= W ; j++)
            {
                int take = 0;
                int nottake = 0 + dp[i - 1][j];
                if(wt[i] <= j)
                {
                    take = val[i] + dp[i][j - wt[i]];
                }
                dp[i][j] = Math.max(nottake , take);
            }
        }
        return dp[wt.length - 1][W];
    }

    static int spaceOptimizedTabulation(int[] wt , int[] val , int W)
    {
        int[] prev = new int[W + 1];
        for(int j = 0 ; j <= W ; j++)
        {
            if(wt[0] <= j)
            {
                prev[j] = (j / wt[0]) * val[0];
            }
            else
            {
                prev[j] = 0;
            }
        }
        for(int i = 1 ; i < wt.length ; i++)
        {
            int[] temp = new int[W + 1];
            for(int j = 0 ; j <= W ; j++)
            {
                int take = 0;
                int nottake = 0 + prev[j];
                if(wt[i] <= j)
                {
                    take = val[i] + temp[j - wt[i]];
                }
                temp[j] = Math.max(nottake , take);
            }
            prev = temp;
        }
        return prev[W];
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of items : ");
        int n = sc.nextInt();
        int[] wt = new int[n];
        int[] val = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            System.out.print("Enter weight of item " + (i + 1) + " : ");
            wt[i] = sc.nextInt();
            System.out.println();
        }
        for(int i = 0 ; i < n ; i++)
        {
            System.out.print("Enter value of item " + (i + 1) + " : ");
            val[i] = sc.nextInt();
            System.out.println();
        }
        System.out.print("Enter Sack Capacity : ");
        int W = sc.nextInt();
        int[] ans = findMaxVal(W, wt, val);
        System.out.println("Max Value that can be looted : " + ans[0] + " Using Recursion");
        System.out.println("Max Value that can be looted : " + ans[1] + " Using Memoization");
        System.out.println("Max Value that can be looted : " + ans[2] + " Using Tabulation");
        System.out.println("Max Value that can be looted : " + ans[3] + " Using Space Optimized Tabulation");
    }
}
