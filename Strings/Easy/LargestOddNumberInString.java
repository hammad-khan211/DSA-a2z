import java.util.*;
class LargestOddNumberInString
{
    static String findLargestOddSubstring(String s)
    {
        StringBuilder ans = new StringBuilder();
        for(int i = s.length() - 1 ; i >= 0 ; i--)
        {
            if((s.charAt(i) - '0') % 2 == 1)
            {
                return ans.append(s.substring(0 , i + 1)).toString();
            }
        }
        return "";
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any string : ");
        String str = sc.nextLine();
        String ans = findLargestOddSubstring(str);
        System.out.println(" Largest odd substring : " + ans);
        sc.close();
    }
}