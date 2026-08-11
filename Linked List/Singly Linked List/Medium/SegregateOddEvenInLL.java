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
public class SegregateOddEvenInLL
{

    static Node segregateBrute(Node head) //tc O(n) sc O(n)
    {
        if(head == null || head.next == null) return head;
        List < Integer > num = new ArrayList<>();

        Node temp = head;
        while(temp != null && temp.next != null)
        {
            num.add(temp.data);
            temp = temp.next.next;
        }
        if(temp != null) num.add(temp.data);

        temp = head.next;
        while(temp != null && temp.next != null)
        {
            num.add(temp.data);
            temp = temp.next.next;
        }
        if(temp != null) num.add(temp.data);

        temp = head;
        int i = 0;
        while(temp != null)
        {
            temp.data = num.get(i);
            i++;
            temp = temp.next;
        }
        return head;
    }

    static Node segregateOptimal(Node head) //tc O(n) sc O(1)
    {
        if(head == null || head.next == null) return head;
        Node odd = head;
        Node even = head.next;
        Node evenHead = head.next;

        while(even != null && even.next != null)
        {
            odd.next = odd.next.next;
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
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
        System.out.println("Enter the " + size + " number of array elements : ");
        for(int i = 0 ; i < size ; i++)
        {
            nums[i] = sc.nextInt();
        }
        System.out.println("The modified LL is : ");
        
        Node head = convertArrayToLL(nums);
        head = segregateOptimal(head);
        printLL(head);
    }
}   