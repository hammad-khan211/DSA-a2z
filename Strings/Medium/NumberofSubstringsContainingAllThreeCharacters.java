import java.util.*;
class NumberofSubstringsContainingAllThreeCharacters//lc1358
{
    static int brute(String s) 
    {
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++)
        {
            int[] freq = new int[3];
            for(int j = i ; j < s.length() ; j++)
            {
                freq[s.charAt(j) - 'a']++;
                if(freq[0] >= 1 && freq[1] >= 1 && freq[2] >= 1)
                {
                    count++;
                }
            }
        }
        return count;
    }

    static int optimal(String s)
    {
        int count = 0;

        int lastA = -1;
        int lastB = -1;
        int lastC = -1;

        for(int i = 0 ; i < s.length() ; i++)
        {
            if(s.charAt(i) == 'a') lastA = i;
            else if(s.charAt(i) == 'b') lastB = i;
            else lastC = i;

            if(lastA != -1 && lastB != -1 && lastC != -1)
            {
                int min = Math.min(lastA , Math.min(lastB , lastC));
                count += min + 1;
            }
        }
        return count;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string containing only a , b , c : ");
        String str = sc.next();
        int ans = optimal(str);
        System.out.println(ans);
    }
}
    