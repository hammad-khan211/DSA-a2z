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
public class Add1ToLL
{

    static Node reverse(Node head)
    {
        Node temp = head;
        Node prev = null;
        while(temp != null)
        {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    static Node add1Brute(Node head) //tc O(N) sc O(1)
    {
        head = reverse(head);
        Node temp = head;
        while(temp != null)
        {
            if(temp.data < 9)
            {
                temp.data += 1;
                break;
            }
            temp.data = 0;
            temp = temp.next;
        }
        if(temp == null)
        {
            Node dummy = new Node(1);
            dummy.next = head;
            head = dummy;
            return head;
        }
        return reverse(head);
    }

    static Node add1Recursion(Node head)//tc O(N) sc O(N)
    {
        int carry = helper(head);
        if(carry == 1)
        {
            Node newHead = new Node(1);
            newHead.next = head;
            return newHead;
        }
        return head;
    }

    static int helper(Node head)
    {
        Node temp = head;
        if(temp == null) return 1;
        int carry = helper(temp.next);
        temp.data += carry;
        if(temp.data < 10)
        {
            return 0;
        }
        temp.data = 0;
        return 1;
    }

    static Node convertArrayToLL(int[] arr) //tc O(n)
    {
        if(arr.length == 0) return null;
        Node start = new Node(arr[0]);
        Node mover = start;
        for(int i = 1 ; i < arr.length ; i++)
        {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp; //mover = mover.next
        }
        return start;
    }

    static void printLL(Node head) //tc O(n)
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
        System.out.println("Enter the " + size + " number of single digit array elements  : ");
        for(int i = 0 ; i < size ; i++)
        {
            nums[i] = sc.nextInt();
        }
        System.out.println("The LL before aading 1 : ");
        Node head = convertArrayToLL(nums);
        printLL(head);

        System.out.println("The LL after adding 1 : ");
        head = add1Recursion(head);
        printLL(head);
    }
}   