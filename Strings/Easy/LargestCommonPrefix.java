import java.util.*;
class LargestCommonPrefix
{
    static String findLCP(String [] strs)
    {
        Arrays.sort(strs);
        StringBuilder ans = new StringBuilder();

        String first = strs[0];
        String last = strs[strs.length - 1];

        int len = Math.min(first.length() , last.length());

        for(int i = 0 ; i < len ; i++)
        {
            if(first.charAt(i) != last.charAt(i))
            {
                break;
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of string array : ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] srr = new String[n];
        
        System.out.println("Enter the " + n + " number of strings in array : ");
        for(int i = 0 ; i < n ; i++)
        {
            srr[i] = sc.nextLine();
        }
        String ans = findLCP(srr);
        System.out.println(" Largest Common Preifx : " + ans);
        sc.close();
    }   
}