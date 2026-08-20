import java.util.*;
class GenerateParenthesis
{
    static ArrayList < String > generateAllParenthesis(int n)
    {
        ArrayList < String > ans = new ArrayList<>();
        generate("" , 0 , 0 , n , ans);
        return ans;
    }

    static void generate(String s , int open , int close , int n , ArrayList < String > ans)
    {
        if(open == n && close == n)
        {
            ans.add(s);
            return;
        }
        if(open < n)
        {
            generate(s + "(" , open + 1 , close , n , ans);
        }
        if(close < open)
        {
            generate(s + ")" , open , close + 1 , n , ans);
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = sc.nextInt();
        ArrayList < String > ans = generateAllParenthesis(n);
        for(String s : ans)
        {
            System.out.println(s);
        }
    }
}