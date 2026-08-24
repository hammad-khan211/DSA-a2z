import java.util.*;
class LongestRepeatingCharacterReplacement//lc 424
{
    static int brute(String s , int k) //tc O(n^2) sc O(n)
    {
        int maxL = 0;
        for(int i = 0 ; i < s.length() ; i++)
        {
            HashMap < Character , Integer > mpp = new HashMap<>();
            int maxFreq = 0;
            for(int j = i ; j < s.length() ; j++)
            {
                char c = s.charAt(j);
                mpp.put(c , mpp.getOrDefault(c , 0) + 1);
                maxFreq = Math.max(maxFreq , mpp.get(c));
                if((j - i + 1) - maxFreq <= k)
                {
                    maxL = Math.max(maxL , j - i + 1);
                }
                else
                {
                    break;
                }
            }
        }
        return maxL;
    }

    static int optimal(String s , int k) //tc O(n) sc O(n)
    {
        int l = 0;
        int maxL = 0;
        int maxFreq = 0;
        HashMap < Character , Integer > mpp = new HashMap<>();
        for(int r = 0 ; r < s.length() ; r++)
        {
            char c = s.charAt(r);
            mpp.put(c , mpp.getOrDefault(c , 0) + 1);   
            maxFreq = Math.max(maxFreq , mpp.get(c));
            while((r - l + 1) - maxFreq > k)
            {
                mpp.put(s.charAt(l) , mpp.get(s.charAt(l)) - 1);
                l++;
            }
            maxL = Math.max(maxL , r - l + 1);
        }
        return maxL;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any String : ");
        String s = sc.nextLine();
        System.out.println("Enter K : ");
        int k = sc.nextInt();
        int ans = optimal(s , k);
        System.out.println(ans);
        sc.close();
    }
}