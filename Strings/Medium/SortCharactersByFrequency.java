import java.util.*;
class SortCharactersByFrequency
{
    static String sortByFreq(String s)
    {
        HashMap < Character , Integer > mpp = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++)
        {
            mpp.put(s.charAt(i) , mpp.getOrDefault(s.charAt(i) , 0) + 1);
        }

        List < Map.Entry < Character , Integer > > list = new ArrayList<>(mpp.entrySet());
        list.sort((a , b) -> Integer.compare(b.getValue() , a.getValue()));

        StringBuilder ans = new StringBuilder();
        for(Map.Entry < Character , Integer > entry : list)
        {
            char ch = entry.getKey();
            int freq = entry.getValue();

            for(int i = 0 ; i < freq ; i++)
            {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string : ");
        String s = sc.nextLine();

        String ans = sortByFreq(s);
        System.out.println("After sorting characters of " + s + " by frequency : " + ans);
    }
}