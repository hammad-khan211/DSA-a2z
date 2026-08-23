import java.util.*;
class MinimumWindowSubString
{
    static String brute(String s , String t)
    {
        int m = s.length();
        int n = t.length();

        String ans = "";

        if(m < n) return ans;

        HashMap < Character , Integer > mpp = new HashMap<>();
        for(int i = 0 ; i < n ; i++)
        {
            mpp.put(t.charAt(i) , mpp.getOrDefault(t.charAt(i) , 0) + 1);
        }

        for(int i = 0 ; i < m ; i++)
        {
            HashMap < Character , Integer > copy = new HashMap<>(mpp);
            int count = n;
            for(int j = i ; j < m ; j++)
            {
                char c = s.charAt(j);
                if(copy.getOrDefault(c , 0) > 0)
                {
                    count--;
                }
                copy.put(c , copy.getOrDefault(c , 0) - 1);

                if(count == 0)
                {
                    if(ans == "" || j - i + 1 < ans.length())
                    {
                          ans = s.substring(i , j + 1);
                    }
                    break;
                }
            }
        }
        return ans;
    }
    
    static String optimal(String s , String t)
    {
        int m = s.length();
        int n = t.length();

        String ans = "";

        if(m < n) return ans;

        HashMap < Character , Integer > mpp = new HashMap<>();
        for(int i = 0 ; i < n ; i++)
        {
            mpp.put(t.charAt(i) , mpp.getOrDefault(t.charAt(i) , 0) + 1);
        }
        
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;
        int count = n;
        int l = 0;

        for(int r = 0 ; r < m ; r++)
        {
            char c = s.charAt(r);
            
            if(mpp.getOrDefault(c , 0) > 0)
            {
                count--;
            }
            mpp.put(c , mpp.getOrDefault(c , 0) - 1);

            while(count == 0)
            {
                if(r - l + 1 < minLen)
                {
                    minLen = r - l + 1;
                    startIndex = l;
                }
                char d = s.charAt(l);
                mpp.put(d , mpp.get(d) + 1);
                if(mpp.get(d) > 0)
                {
                    count++;
                }
                l++;
            }
        }
        return startIndex == -1 ? ans : s.substring(startIndex , startIndex + minLen);
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
