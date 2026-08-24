import java.util.*;
class LongestSubStringWithAtMostKDistinctCharacters
{
    static int brute(String s , int k)//tc O(n^2) sc O(n)
    {
        int maxL = 0;
        for(int i = 0 ; i < s.length() ; i++)
        {
            HashSet < Character > set = new HashSet<>();
            for(int j = i ; j < s.length() ; j++)
            {
                set.add(s.charAt(j));
                if(set.size() > k)
                {
                    break;
                }
                maxL = Math.max(maxL , j - i + 1);
            }
        }
        return maxL;
    }
    static int optimal(String s , int k) //tc O(n) sc O(n)
    {
        int maxL = 0;
        int l = 0;
        HashMap < Character , Integer > mpp = new HashMap<>();
        for(int r = 0 ; r < s.length() ; r++)
        {
            char c = s.charAt(r);
            mpp.put(c , mpp.getOrDefault(c , 0) + 1);
            while(mpp.size() > k)
            {
                mpp.put(s.charAt(l), mpp.get(s.charAt(l)) - 1);
                if(mpp.get(s.charAt(l)) == 0) mpp.remove(s.charAt(l));
                l++;
            }
            maxL = Math.max(maxL , r - l + 1);
        }
        return maxL;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any string : ");
        String s = sc.nextLine();
        System.out.println("Enter K : ");
        int k = sc.nextInt();
        int ans = optimal(s , k);
        int ans1 = brute(s, k);
        System.out.println("Longest Substring With AtMost K Distinct Characters is of length BRUTE : " + ans1);
        System.out.println("Longest Substring With AtMost K Distinct Characters is of length OPTIMAL : " + ans);
        sc.close();
    }
}
