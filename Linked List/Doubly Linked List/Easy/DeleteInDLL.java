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

class DeleteInDLL
{
    static Node deleteHeadInDLL(Node head)
    {
        if(head == null || head.next == null) return null;
        Node prev = head;
        head = head.next;
        prev.next = null;
        head.prev = null;
        return head;
    }

    static Node deleteTailInDLL(Node head)
    {
        if(head == null || head.next == null)
        {
            return null;
        }
        Node tail = head;
        while(tail.next != null)
        {
            tail = tail.next;
        }
        Node newTail = tail.prev;
        newTail.next = null;
        tail.prev = null;
        return head;
    }

    static Node deleteKthNodeInDLL(Node head , int x)
    {
        if(head == null) return null;
        int count = 0;
        Node temp = head;
        while(temp != null)
        {
            count++;
            if(count == x)
            {
                break;
            }
            temp = temp.next;
        }

        if(temp == null) return head;
        
        Node prev = temp.prev;
        Node next = temp.next;
        
        if(prev == null && next == null)
        {
            return null;
        }
        else if(prev == null)
        {
            head = next;
            head.prev = null;
            temp.next = null;
            return head;
        }
        else if(next == null)
        {
            prev.next = null;
            temp.prev = null;
            return head;
        }
        else
        {
            prev.next = next;
            next.prev = prev;
            temp.prev = null;
            temp.next = null;
            return head;
        }
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

        System.out.println("Before deleting head : ");
        Node start = convertArrayToDLL(nums);
        printDLL(start);
        System.out.println("After deleting head : ");
        start = deleteHeadInDLL(start);
        printDLL(start);

        System.out.println("Before deleting tail : ");
        printDLL(start);
        System.out.println("After deleting tail : ");
        start = deleteTailInDLL(start);
        printDLL(start);

        System.out.println("Enter the Node position to be deleted in the range 1 <= x <= size : ");
        int x = sc.nextInt();
        start = deleteKthNodeInDLL(start , x);
        printDLL(start);

    }

}