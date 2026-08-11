
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
class RemoveNthNodeFromLastInLL
{
    static int findLength(Node head)
    {
        Node temp = head;
        int count = 0;
        while(temp != null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }

    static Node removeNthLastBrute(Node head , int n) //tc O(n) sc O(1) 2 pass
    {
        if(head == null || head.next == null)
        {
            return null;
        }
        Node temp = head;
        int res = findLength(head) - n;
        if(res == 0) return head.next;
        while(res-- > 1)
        {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    static Node removeNthLastOptimal(Node head , int n) //tc O(N) sc O(1) 1 pass 
    {
        if(head == null || head.next == null)
        {
            return null;
        }
        Node fast = head;
        for(int i = 0 ; i < n ; i++)
        {
            fast = fast.next;
        }
        if(fast == null) return head.next;

        Node slow = head;
        while(fast.next != null)
        {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
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
        System.out.println("Enter the Nth node to be deleted from last : ");
        int n = sc.nextInt();

        Node head = convertArrayToLL(nums);
        head = removeNthLastBrute(head, n);
        printLL(head);
    }
}