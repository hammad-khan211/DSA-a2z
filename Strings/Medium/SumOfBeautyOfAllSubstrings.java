import java.util.*;
class SumOfBeautyOfAllSubstrings
{
    static int brute(String s) //tc O(n^3) //sc O(n)
    {
        int ans = 0;
        for(int i = 0 ; i < s.length() ; i++)
        {
            for(int j = i ; j < s.length() ; j++)
            {
                ans += findBeauty(s.substring(i , j + 1));
            }
        }
        return ans;
    }

    static int findBeauty(String sub)
    {
        if(sub.length() <= 2) return 0;

        HashMap < Character , Integer > mpp = new HashMap<>();
        for(int i = 0 ; i < sub.length() ; i++)
        {
            mpp.put(sub.charAt(i) , mpp.getOrDefault(sub.charAt(i) , 0) + 1);
        }
        int maxFreq = 0;
        int minFreq = sub.length();
        for(Map.Entry < Character , Integer > entry : mpp.entrySet())
        {
            maxFreq = Math.max(maxFreq , entry.getValue());
            minFreq = Math.min(minFreq , entry.getValue());
        }
        return maxFreq - minFreq;
    }

    static int optimal(String s) //tc O(n^2) //sc O(1)
    {
        int ans = 0;
        for(int i = 0 ; i < s.length() ; i++)
        {
            int[] freq = new int[26];

            for(int j = i ; j < s.length() ; j++)
            {
                freq[s.charAt(j) - 'a']++;

                int maxFreq = 0;
                int minFreq = s.length();

                for(int k = 0 ; k < 26 ; k++)
                {
                    if(freq[k] > 0)
                    {
                        maxFreq = Math.max(maxFreq , freq[k]);
                        minFreq = Math.min(minFreq , freq[k]);                
                    }
                }

                ans += maxFreq - minFreq;
            }
        }
        return ans;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string : ");
        String str = sc.next();
        int ans = optimal(str);
        System.out.println(str + " : " + ans);
    }
}