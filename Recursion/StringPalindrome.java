import java.util.Scanner;
class StringPalindrome{
    //with recursion
    boolean isPalindrome(int i,String s)
    {
        if(i >= s.length() / 2)
        {
            return true;
        }
        else{
            if(s.charAt(i) != s.charAt(s.length() - i - 1))
            {
                return false;
            }
            else{
                return isPalindrome(i+1 , s);  //recursive call
            }
        }
    }

    //without recursion
    boolean isPalindrome2(String s)
    {
        int i = 0;
        int j = s.length() - 1;
        while(i < j)
        {
            if(s.charAt(i) != s.charAt(j))
            {
                return false;
            }
            else{
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String s = sc.nextLine();

        StringPalindrome obj = new StringPalindrome();

        System.out.println("WITH RECURSION : " + obj.isPalindrome(0,s));
        System.out.println("WITHOUT RECURSION : " + obj.isPalindrome2(s));

    }    
    
}