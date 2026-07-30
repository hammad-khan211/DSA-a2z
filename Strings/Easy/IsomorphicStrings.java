import java.util.*;
class IsomorphicStrings
{
    static boolean isIsomorphic(String s , String t)
    {
        HashMap < Character , Character > mppST = new HashMap<>();
        HashMap < Character , Character > mppTS = new HashMap<>();

        for(int i = 0 ; i < s.length() ; i++)
        {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(!mppST.containsKey(c1)) mppST.put(c1 , c2);
            if(!mppTS.containsKey(c2)) mppTS.put(c2 , c1);
            
            if(mppST.get(c1) != c2 || mppTS.get(c2) != c1) return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first string : ");
        String str1 = sc.nextLine();

        System.out.println("Enter secondstring : ");
        String str2 = sc.nextLine();
        
        if(isIsomorphic(str1, str2))
        {
            System.out.println(str1 + " and " + str2 + " are Isomorphic");
        }
        else
        {
            System.out.println(str1 + " and " + str2 + " are not Isomorphic");
        }
        sc.close();
    }
}