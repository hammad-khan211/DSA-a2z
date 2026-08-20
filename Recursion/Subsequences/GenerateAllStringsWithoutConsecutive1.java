import java.util.*;
class GenerateAllStringsWithoutConsecutive1
{
    static ArrayList < String > generateAll(int n)
    {
        ArrayList < String > ans = new ArrayList<>();
        generate("" , 0 , n , ans);
        return ans;
    }

    static void generate(String s , int prev , int n , ArrayList < String > ans)
    {
        if(s.length() == n)
        {
            ans.add(s);
            return;
        }
        generate(s + "0" , 0 , n , ans);
        if(prev != 1)
        {
            generate(s + "1" , 1 , n , ans);
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = sc.nextInt();
        ArrayList < String > ans = generateAll(n);
        for(String s : ans)
        {
            System.out.println(s);
        }
    }
}