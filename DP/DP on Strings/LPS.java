import java.util.*;

class LPS 
{
    static int findLPS(String s)
    {
        return findLCS(s , new StringBuilder(s).reverse().toString());
    }    
    static int findLCS(String s1 , String s2)
    {
        int n = s1.length();
        int[] prev = new int[n + 1];
        for(int i = 1 ; i <= n ; i++)
        {
            int[] temp = new int[n + 1];
            for(int j = 1 ; j <= n ; j++)
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
        return prev[n];
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any string : ");
        String s = sc.nextLine();
        int ans = findLPS(s);
        System.out.println("LPS of " + s + " is : " + ans);
    }
}
