import java.util.*;

class Node
{
    int data;
    Node prev;
    Node next;

    Node(int data1 , Node prev1 , Node next1)
    {
        this.data = data1;
        this.prev = prev1;
        this.next = next1;
    }

    Node(int data1)
    {
        this.data = data1;
        this.prev = null;
        this.next = null;
    }
}

class FindAllPairsWithGivenSumInSortedLL
{
    static ArrayList < ArrayList < Integer > > findPairs(Node head , int sum)
    {
        ArrayList < ArrayList < Integer > > ans = new ArrayList<>();

        if(head == null || head.next == null) return ans;

        Node start = head;
        Node end = head;

        while(end.next != null)
        {
            end = end.next;
        }

        while(start != end && start != end.next)
        {
            int a = start.data;
            int b = end.data;
            if(a + b < sum)
            {
                start = start.next;
            }
            else if(a + b > sum)
            {
                end = end.prev;
            }
            else
            {
                ArrayList < Integer > pair = new ArrayList<>();
                pair.add(a);
                pair.add(b);
                ans.add(pair);
                start = start.next;
                end = end.prev;
            }
        }
        return ans;
    }

    static Node convertArrayToDLL(int[] nums)
    {
        if(nums.length == 0) return null;
        Node start = new Node(nums[0]);
        Node prev = start;
        for(int i = 1 ; i < nums.length ; i++)
        {
            Node temp = new Node(nums[i]);
            temp.prev = prev;
            prev.next = temp;
            prev = temp;
        }
        return start;
    }

    static void printDLL(Node head)
    {
        Node current = head;
        while(current != null)
        {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int size = sc.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter the " + size + " number of array elements : ");
        for(int i = 0 ; i < size ; i++)
        {
            nums[i] = sc.nextInt();
        }

        System.out.println("Enter the value of sum : ");
        int x = sc.nextInt();

        Node start = convertArrayToDLL(nums);

        System.out.println("Total Pairs With Sum " + x + " : ");
        ArrayList < ArrayList < Integer > > ans = findPairs(start, x);
        for(ArrayList < Integer > m : ans)
        {
            System.out.println(m);
        }
    }

}