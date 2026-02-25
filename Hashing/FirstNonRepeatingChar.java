import java.util.Scanner;
class FirstNonRepeatingChar
{
    static int findFirstNonRepeating(String S)
    {
        int n = S.length();
        int[] hash = new int[26];
        for(int i = 0 ; i < n ; i++)
        {
            hash[S.charAt(i) - 'a']++;  //precomputing
        }

        for(int i = 0 ; i < S.length() ; i++)
        {
            if(hash[S.charAt(i) - 'a'] == 1)
            {
                return i;
            }
        }
    return -1;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENter any string : ");
        String str = sc.nextLine().toLowerCase();
        int res = findFirstNonRepeating(str);
        System.out.println(res);
    }
}