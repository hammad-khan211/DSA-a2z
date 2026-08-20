import java.util.*;
class PowerSet
{
    static ArrayList < String > brute(String s) //tc O(2 ^ n * n) sc O(n)
    {
        ArrayList < String > ans = new ArrayList<>();
        int total = 1 << s.length();
        for(int i = 0 ;  i < total ; i++)
        {
            StringBuilder sub = new StringBuilder();
            for(int j = 0 ; j < s.length() ; j++)
            {
                if((i & (1 << j)) != 0)
                {
                    sub.append(s.charAt(j));
                }
            }
            ans.add(sub.toString());
        }
        return ans;
    }

    static ArrayList < String > optimal(String S) //tc O(2 ^ n * n) sc O(n)
    {
        ArrayList < String > ans = new ArrayList<>();
        generate(S , 0 , "" , ans);
        return ans;
    }
    static void generate(String S , int index , String current , ArrayList < String > ans)
    {
        if(index == S.length())
        {
            ans.add(current);
            return;
        }
        generate(S , index + 1 , current + S.charAt(index) , ans);
        generate(S , index + 1 , current , ans);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String : ");
        String str = sc.nextLine();
        ArrayList < String > res = optimal(str);
        for(String s : res)
        {
            System.out.println(" [ "+ s +" ]");
        }
    }
}