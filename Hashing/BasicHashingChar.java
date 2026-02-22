import java.util.Scanner;
class BasicHashingChar{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any string : ");
        String s = sc.next();

        //PRECOMPUTNG

        int[] hash = new int[26];  // 26 for lower case letters 'a' - 'a' => 97 - 97 = 0 // it can also be taken 256 for all characters // 
        for(int i = 0 ; i < s.length() ; i++)
        {
            hash[s.charAt(i) - 'a']++; 
        }

        //queries
        System.out.println("Enter the number of queries you want to give : ");
        int q = sc.nextInt();
        System.out.println("Enter " + q + " queries : ");
        while(q-- > 0)
        {
            char c = sc.next().charAt(0);
            System.out.println(c + " occured " + hash[c - 'a'] + " times");   //fetch
        }

    }

}