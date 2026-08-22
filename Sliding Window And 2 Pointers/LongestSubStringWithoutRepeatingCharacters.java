import java.util.*;
class LongestSubStringWithoutRepeatingCharacters
{
    static int brute(String s) //tc O(n ^ 2) sc O(n)
    {
        int maxL = 0;
        for(int i = 0 ; i < s.length() ; i++)
        {
            HashSet < Character > set = new HashSet<>();
            for(int j = i ; j < s.length() ; j++)
            {
                if(set.contains(s.charAt(j)))
                {
                    break;
                }
                set.add(s.charAt(j));
                maxL = Math.max(maxL , j - i + 1);
            }
        }
        return maxL;
    }    

    static int optimal(String s) //tc O(n) sc O(n)
    {
        int l = 0;
        int maxLen = 0;
        HashMap < Character , Integer > mpp = new HashMap<>();
        for(int r = 0 ; r < s.length() ; r++)
        {
            char current = s.charAt(r);
            if(mpp.containsKey(current) && l <= mpp.get(current))
            {
                l = mpp.get(current) + 1;
            }
            mpp.put(current , r);
            maxLen = Math.max(maxLen , r - l + 1);
        }
        return maxLen;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any string : ");
        String s = sc.nextLine();
        int ans = optimal(s);
        System.out.println("Longest Substring Without Repeating Characters is of length : " + ans);
        sc.close();
    }
}
