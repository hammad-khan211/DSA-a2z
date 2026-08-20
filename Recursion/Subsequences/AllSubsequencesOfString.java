import java.util.*;
class AllSubsequencesOfString
{

    static ArrayList < String > optimal(String s)
    {
        ArrayList < String > ans = new ArrayList<>();
        generate(s , 0 , "" , ans);
        return ans;
    }
    static void generate(String s , int index , String current , ArrayList < String > ans)
    {
        if(index == s.length())
        {
            ans.add(current);
            return;
        }
        //take
        generate(s, index + 1 , current + s.charAt(index) , ans);
        //dont take
        generate(s , index + 1 , current , ans);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string : ");
        String s = sc.nextLine();
        ArrayList < String > ans = optimal(s);
        System.out.println(" ALL SUBSEQUENCES : ");
        for(String X : ans)
        {
            System.out.print("[ " + X + " ] ");
        }
    }
}