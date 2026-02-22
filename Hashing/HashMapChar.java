import java.util.*;
class HashMapChar{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String s = sc.nextLine();

        //precomputing  // storing and fetching takes log(N)
        HashMap < Character , Integer > mpp = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++)
        {
            mpp.put(s.charAt(i) , mpp.getOrDefault(s.charAt(i) , 0) + 1);
        }

        System.out.println("Enter the number of queries you want to give : ");
        int q = sc.nextInt();
        System.out.println("Enter " + q + " queries : ");
        while(q-- > 0)
        {
            char c = sc.next().charAt(0);
            System.out.println(c + " occured " + mpp.getOrDefault(c , 0) + " number of times"); //fetching lso takes log(N)
        }
        

    // Need speed, no order? → HashMap

    // Need sorted keys? → TreeMap

    // Need insertion order? → LinkedHashMap
    }
}