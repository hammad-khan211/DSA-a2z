import java.util.*;
class RotateString
{
    static boolean brute(String s , String goal)
    {
        if(s.length() != goal.length()) return false;
        if(s.equals(goal)) return true;

        for(int i = 0 ; i < s.length() ; i++)
        {
            StringBuilder rotate = new StringBuilder();
            rotate.append(s.charAt(s.length() - 1));
            s = rotate.append(s.substring(0 , s.length() - 1)).toString();

            if(s.equals(goal)) return true;
        }
        return false;
    }

    static boolean optimal(String s , String goal)
    {
        if(s.length() != goal.length())
        {
            return false;
        }
        return (s + s).contains(goal);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first string : ");
        String str1 = sc.nextLine();

        System.out.println("Enter the goal you want to achieve after rotating " + str1);
        String str2 = sc.nextLine();
        
        if(optimal(str1, str2))
        {
            System.out.println(str2 + " can be achieved by rotating " + str1);
        }
        else
        {
            System.out.println(str2 + " can not be achieved by rotating " + str1);
        }
        sc.close();
    }

}