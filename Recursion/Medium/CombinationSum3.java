import java.util.*;
class CombinationSum3
{
    static List < List < Integer > > optimal(int k , int n)
    {
        List < List < Integer > > ans = new ArrayList<>();
        generate(1 , n , k , new ArrayList<>() , ans);
        return ans;
    }
    static void generate(int index , int n , int k , ArrayList < Integer > current , List < List < Integer > > ans)
    {
        if(n == 0 &&  current.size() == k)
        {
            ans.add(new ArrayList<>(current));
            return;
        }
        if(n < 0 || current.size() >= k) return;
        for(int i = index ; i <= 9 ; i++)
        {
            current.add(i);
            generate(i + 1 , n - i , k , current , ans);
            current.remove(current.size() - 1);
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = sc.nextInt();
        System.out.println("Enter k : ");
        int k = sc.nextInt();
        List < List < Integer > > res = optimal(k, n);
        for(List < Integer > X : res)
        {
            System.out.print("[ ");
            for(int Y : X)
            {
                System.out.print(Y + " ");
            }
            System.out.print(" ]");
            System.out.println("");
        }
    }
}