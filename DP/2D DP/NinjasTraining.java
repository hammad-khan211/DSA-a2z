import java.util.*;
class NinjasTraining 
{
    static int maxPoints(int[][] mat)
    {
        int[][] dp = new int[mat.length][4];
        for(int[] row : dp)
        {
            Arrays.fill(row , -1);
        }
        // int ans1 = recursion(mat , mat.length - 1 , 3);
        int ans2 = memoization(mat , mat.length - 1 , 3 , dp);
        return ans2;
    }    

    static int recursion(int[][] mat , int day , int last)
    {
        if(day == 0)
        {
            int max0 = Integer.MIN_VALUE;
            for(int i = 0 ; i < 3 ; i++)
            {
                if(i != last)
                {
                    max0 = Math.max(max0 , mat[0][i]);
                }
            }
            return max0;
        }
        int maxPoint = Integer.MIN_VALUE;
        for(int i = 0 ; i < 3 ; i++)
        {
            if(i != last)
            {
                int point = mat[day][i] + recursion(mat , day - 1 , last);
                maxPoint = Math.max(maxPoint , point);
            }
        }
        return maxPoint;
    }

    static int memoization(int[][] mat , int day , int last , int[][] dp)
    {
        if(day == 0)
        {
            int max0 = Integer.MIN_VALUE;
            for(int i = 0 ; i < 3 ; i++)
            {
                if(i != last)
                {
                    max0 = Math.max(max0 , mat[0][i]);
                }
            }
            return max0;
        }

        if(dp[day][last] != -1)
        {
            return dp[day][last];
        }

        int maxPoint = Integer.MIN_VALUE;
        for(int i = 0 ; i < 3 ; i++)
        {
            if(i != last)
            {
                int point = mat[day][i] + recursion(mat , day - 1 , last);
                maxPoint = Math.max(maxPoint , point);
            }
        }
        dp[day][last] = maxPoint;
        return dp[day][last];
    }

    static int tabulation(int[][] mat , int n)
    {
        int[][] dp = new int[mat.length][4];
        dp[0][0] = Math.max(mat[0][1] , mat[0][2]);
        dp[0][1] = Math.max(mat[0][0] , mat[0][2]);
        dp[0][2] = Math.max(mat[0][0] , mat[0][1]);
        dp[0][3] = Math.max(Math.max(mat[0][0] , mat[0][1]) , mat[0][2]);
        
        for(int day = 1 ; day < mat.length ; day++)
        {
            for(int last = 0 ; last < 4 ; last++)
            {
                dp[day][last] = 0;
                for(int task = 0 ; task < 3 ; task++)
                {
                    if(task != last)
                    {
                        int point = mat[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last] , point);
                    }
                }
            }
        }
        return dp[mat.length - 1][3];
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of days : ");
        int days = sc.nextInt();
        int[][] mat = new int[days][3];
        for(int i = 0 ; i < days ; i++)
        {
            System.out.print("Enter point of running , fighting and learning on DAY " + (i + 1) + " : ");
            mat[i][0] = sc.nextInt();
            mat[i][1] = sc.nextInt();
            mat[i][2] = sc.nextInt();
            System.out.println();
        }
        int ans = maxPoints(mat);
        int ans1 = tabulation(mat , days);
        System.out.println("Max Points : " + ans1);

    }
}
