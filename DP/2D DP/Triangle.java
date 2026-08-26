import java.util.*;
class Triangle
{
    static int[] findMinSum(List < List < Integer > > triangle)
    {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] dp = new int[m][n];
        for(int[] row : dp)
        {
            Arrays.fill(row , -1);
        }
        int ans1 = recursion(0 , 0 , triangle);
        int ans2 = memoization(0, 0, triangle, dp);
        int ans3 = tabulation(triangle);
        int ans4 = spaceOptimizedTabulation(triangle);
        return new int[]{ans1 , ans2 , ans3 , ans4};
    }

    static int recursion(int i , int j , List < List < Integer > > triangle) //tc O(2^m) sc O(m)
    {
        int m = triangle.size();
        if(i == m - 1)
        {
            return triangle.get(i).get(j);
        }
        int left = triangle.get(i).get(j) + recursion(i + 1 , j , triangle);
        int right = triangle.get(i).get(j) + recursion(i + 1 , j + 1 , triangle);
        return Math.min(left , right);
    }

    static int memoization(int i , int j , List < List < Integer > > triangle , int[][] dp) //tc O(m²) sc O(m²) dp array + O(m) recursive stack
    {
        int m = triangle.size();
        if(i == m - 1)
        {
            return triangle.get(i).get(j);
        }
        if(dp[i][j] != -1) return dp[i][j];
        int left = triangle.get(i).get(j) + memoization(i + 1 , j , triangle , dp);
        int right = triangle.get(i).get(j) + memoization(i + 1 , j + 1 , triangle , dp);
        dp[i][j] = Math.min(left , right);   
        return dp[i][j];  
    }

    static int tabulation(List < List < Integer > > triangle) //tc O(m²) sc O(m²) dp array
    {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] dp = new int[m][n];
        
        for(int j = 0 ; j < n ; j++) //copy last row
        {
            dp[m - 1][j] = triangle.get(m - 1).get(j);
        }
        
        for(int i = m - 2 ; i >= 0 ; i--)
        {
            for(int j = i ; j >= 0 ; j--)
            {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j] , dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }

    static int spaceOptimizedTabulation(List < List < Integer > > triangle) //tc O(m²) sc O(m)
    {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[] next = new int[n];
        
        for(int j = 0 ; j < n ; j++) //copy last row
        {
            next[j] = triangle.get(m - 1).get(j);
        }
        
        for(int i = m - 2 ; i >= 0 ; i--)
        {
            int[] temp = new int[n];
            for(int j = i ; j >= 0 ; j--)
            {
                temp[j] = triangle.get(i).get(j) + Math.min(next[j] , next[j + 1]);
            }
            next = temp;
        }
        return next[0];
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter m : ");
        int m = sc.nextInt();
        List < List < Integer > > triangle = new ArrayList<>();
        System.out.println("Enter trinagle elements : ");
        for(int i = 0 ; i < m ; i++)
        {
            List < Integer > row = new ArrayList<>();
            for(int j = 0 ; j < i + 1 ; j++)
            {
               int el = sc.nextInt();
               row.add(el); 
            }
            triangle.add(row);
        }
        int[] ans = findMinSum(triangle);
        System.out.println("MIN SUM Using RECURSION is : " + ans[0]);
        System.out.println("MIN SUM Using Memoization ( TOP DOWN ) By DP is : " + ans[1]);
        System.out.println("MIN SUM Using Tabulation ( BOTTOM UP ) By DP is : " + ans[2]);
        System.out.println("MIN SUM Using Space Optimized Tabulation ( BOTTOM UP ) BY DP is : " + ans[3]);
    }  


}