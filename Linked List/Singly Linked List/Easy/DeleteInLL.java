
import java.util.*;

class Node
{
    int data;
    Node next;

    Node(int data1 , Node next1)
    {
        this.data = data1;
        this.next = next1;
    }
    Node(int data1)
    {
        this.data = data1;
        this.next = null;
    }
}
class DeleteInLL
{
    static Node deleteHeadInLL(Node head)
    {
        if(head == null) return head;
        head = head.next;
        return head;
    }

    static Node deleteTailInLL(Node head)
    {
        if(head == null || head.next == null) return null;
        Node current = head;
        while(current.next.next != null)
        {
            current = current.next;
        }
        current.next = null;
        return head;
    }

    static Node deleteKthNodeInLL(Node head , int K)
    {
        if(head == null) return null;
        if(K == 1)
        {
            head = head.next;
            return head;
        }
        int count = 0;
        Node temp = head;
        Node prev = null;
        while(temp != null)
        {
            count++;
            if(count == K)
            {
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    static Node deleteValInLL(Node head , int el)
    {
        if(head == null) return null;
        if(head.data == el)
        {
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev = null;
        while(temp != null)
        {
            if(temp.data == el)
            {
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    static Node convertArrayToLL(int[] nums)
    {
        if(nums.length == 0) return null;
        Node start = new Node(nums[0]);
        Node mover = start;
        for(int i = 1 ; i < nums.length ; i++)
        {
            Node temp = new Node(nums[i]);
            mover.next = temp;
            mover = temp;
        }
        return start;
    }

    static void printLL(Node head)
    {
        Node current = head;
        while(current != null)
        {
            System.out.print(current.data + " -> ");
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

        Node head = convertArrayToLL(nums);
        // System.out.println("Before deleting head : ");
        // printLL(head);

        // System.out.println("After deleting head : ");
        // head = deleteHeadInLL(head);
        // printLL(head);

        // System.out.println("Before deleting tail : ");
        // printLL(head);

        // System.out.println("After deleting tail : ");
        // head = deleteTailInLL(head);
        // printLL(head);

        // System.out.println("Enter the Node position to be deleted in the range 1 <= K <= size : ");
        // int k = sc.nextInt();
        // head = deleteKthNodeInLL(head, k);
        // printLL(head);

        System.out.println("Enter the element to be deleted from LL : ");
        int val = sc.nextInt();
        head = deleteValInLL(head, val);
        printLL(head);
    }
}