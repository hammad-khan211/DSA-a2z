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
public class findMiddleofLL
{

    static Node findMiddle(Node head) //tc O(n + n/2) sc O(1)
    {
        if(head == null) return null;
        int mid = (findLLlength(head) / 2) + 1;
        Node temp = head;
        while(mid-- > 1)
        {
            temp = temp.next;
        }
        return temp;
    }

    static Node findMiddleOptimal(Node head) //slow fast pointer , tortoise & hare
    {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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

    static int findLLlength(Node head) //tc O(n)
    {
        int count = 0;
        Node current = head;
        while(current != null)
        {
            count++;
            current = current.next;
        }
        return count;
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
        System.out.println("The middle Node is : ");
        
        Node head = convertArrayToLL(nums);
        head = findMiddleOptimal(head);
        printLL(head);
    }
}   