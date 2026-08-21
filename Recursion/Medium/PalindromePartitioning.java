import java.util.*;
class PalindromePartitioning 
{
    static List < List < String > > partition(String s)
    {
        List < List < String > > ans = new ArrayList<>();
        generate(s , 0 , new ArrayList<>() , ans);
        return ans;
    }
    
    static void generate(String s , int index , ArrayList < String > current , List < List < String > > ans)
    {
        if(index == s.length())
        {
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i = index ; i < s.length() ; i++)
        {
            if(isPalindrome(s.substring(index , i + 1)))
            {
                current.add(s.substring(index , i + 1));
                generate(s, i + 1 , current, ans);
                current.remove(current.size() - 1);
            }
        }
    }
    static boolean isPalindrome(String s)
    {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any string : ");
        String s = sc.nextLine();
        List < List < String > > res = partition(s);
        for(List < String > X : res)
        {
            System.out.print("[ ");
            for(String Y : X)
            {
                System.out.print(Y + " ");
            }
            System.out.print(" ]");
            System.out.println("");
        }
    }
}
