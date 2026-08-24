import java.util.*;
class MinimumWindowSubsequence //given two strings s and t , return the minimum contagious part of s such that t is a subsequence of that part
{
    static String brute(String s , String t) //tc O(m^2) O(1)
    {
        int m = s.length();
        int n = t.length();

        if(m < n) return new String("");

        int minLen = Integer.MAX_VALUE;
        int start = -1;

        for(int i = 0 ; i < m ; i++)
        {
            int j = i;
            int k = 0;
            while(j < m && k < n)
            {
                if(s.charAt(j) == t.charAt(k))
                {
                    k++;
                }
                j++;

                if(k == n)
                {
                    if(minLen > j - i)
                    {
                        minLen = j - i;
                        start = i;
                    }
                    break;
                }
            }
        }
        return start != -1 ? s.substring(start , start + minLen) : "";
    }

    static String optimal(String s , String t)//tc O(m * n) sc O(1)
    {
        int m = s.length();
        int n = t.length();

        if(m < n) return new String("");

        int minLen = Integer.MAX_VALUE;
        int startInd = -1;
        int i = 0;

        while(i < m)
        {
            int j = 0;
            //forward scan
            while(i < m && j < n) //forward scan
            {
                if(s.charAt(i) == t.charAt(j))
                {
                    j++;
                }
                i++;
            }

            if(j < n) break;

            int end = i;
            
            //backward scan
            j = n - 1;
            i--;
            while(i >= 0 && j >= 0)
            {
                if(s.charAt(i) == t.charAt(j))
                {
                    j--;
                }
                i--;
            }

            int start = i + 1;

            if(end - start < minLen)
            {
                minLen = end - start;
                startInd = start;
            }

            i = start + 1;
        }
        return startInd != -1 ? s.substring(startInd , startInd + minLen) : "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String s : ");
        String s = sc.nextLine();
        System.out.println("Enter string t : ");
        String t = sc.nextLine();
        String ans = brute(s, t);
        String ans1 = optimal(s , t);
        System.out.println("BRUTE : " + ans);
        System.out.println("OPTIMAL : " + ans1);
        sc.close();
    }
}
