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

class DeleteAllOccurancesOfAKeyInDLL
{
    static Node delete(Node head , int x)
    {
        if(head == null) return null;
        Node temp = head;
        while(temp != null)
        {
            Node nextNode = temp.next;
            if(temp.data == x)
            {
                if(temp == head)
                {
                    head = head.next;
                    if(head != null)
                    {
                        head.prev = null;
                    }
                }
                else
                {
                    temp.prev.next = temp.next;
                    if(temp.next != null)
                    {
                        temp.next.prev = temp.prev;
                    }
                }
            }
            temp = nextNode;
        }
        return head;
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

        System.out.println("Enter the value of x : ");
        int x = sc.nextInt();

        System.out.println("Before deleting occurances of " + x + " : ");
        Node start = convertArrayToDLL(nums);
        printDLL(start);


        System.out.println("After deleting occurances of " + x + " : ");
        start = delete(start , x);
        printDLL(start);

    }

}