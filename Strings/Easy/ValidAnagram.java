import java.util.*;
class ValidAnagram
{
    static boolean isAnagram(String s , String t)
    {
        if(s.length() != t.length())
        {
            return false;
        }
        HashMap < Character , Integer > mppS = new HashMap<>();
        HashMap < Character , Integer > mppT = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++)
        {
            mppS.put(s.charAt(i) , mppS.getOrDefault(s.charAt(i) , 0) + 1);
            mppT.put(t.charAt(i) , mppT.getOrDefault(t.charAt(i) , 0) + 1);
        }
        return mppS.equals(mppT);
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first string : ");
        String s = sc.nextLine();
        System.out.println("Enter the second string : ");
        String t = sc.nextLine();
        if(isAnagram(s , t))
        {
            System.out.println(s + " and " + t + " are valid anagrams");
        }
        else
        {
            System.out.println(s + " and " + t + " are not valid anagrams");
        }
    }
}