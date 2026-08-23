import java.util.*;
class NumberofSubstringsContainingAllThreeCharacters
{
    static int brute(String s) //tc O(n^2) sc O(1)
    {
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++)
        {
            boolean a = false;
            boolean b = false;
            boolean c = false;
            for(int j = i ; j < s.length() ; j++)
            {
                if(s.charAt(j) == 'a') a = true;
                else if(s.charAt(j) == 'b') b = true;
                else c = true;

                if(a && b && c)
                {
                    count += s.length() - j;
                    break;
                }
            }
        }
        return count;
    }
    
    static int optimal(String s) //tc O(n) sc O(1)
    {
        int lastA = -1;
        int lastB = -1;
        int lastC = -1;
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++)
        {
            if(s.charAt(i) == 'a') lastA = i;
            else if(s.charAt(i) == 'b') lastB = i;
            else lastC = i;

            if(lastA != -1 && lastB != -1 && lastC != -1)
            {
                count += Math.min(lastA , Math.min(lastB , lastC)) + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any string of abc");
        String str = sc.nextLine();
        int ans1 = brute(str);
        int ans2 = optimal(str);
        System.out.println("BRUTE : " + ans1);
        System.out.println("OPTIMAL : " + ans2);
    }
}
