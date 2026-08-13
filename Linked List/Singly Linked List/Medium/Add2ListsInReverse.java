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
public class Add2ListsInReverse
{


    static Node addBrute(Node headA , Node headB) //tc O(N) sc O(1)
    {
        Node t1 = headA;
        Node t2 = headB;

        Node dummy = new Node(-1);
        Node current = dummy;

        int carry = 0;
        while(t1 != null || t2 != null)
        {
            int a = (t1 != null) ? t1.data : 0;
            int b = (t2 != null) ? t2.data : 0;
            if(a + b + carry > 9)
            {
                current.next = new Node((a + b + carry) % 10);
                carry = 1;
            }
            else
            {
                current.next = new Node((a + b + carry) % 10);
                carry = 0;
            }
            current = current.next;
            t1 = (t1 != null) ? t1.next : t1;
            t2 = (t2 != null) ? t2.next : t2;
        }
        if(carry == 1)
        {
            current.next = new Node(1);
        }
        return dummy.next;
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
        System.out.println("Enter the size of the array 1 : ");
        int size1 = sc.nextInt();
        int[] nums1 = new int[size1];
        System.out.println("Enter the " + size1 + " number of single digit array elements  : ");
        for(int i = 0 ; i < size1 ; i++)
        {
            nums1[i] = sc.nextInt();
        }

        System.out.println("Enter the size of the array 2 : ");
        int size2 = sc.nextInt();
        int[] nums2 = new int[size2];
        System.out.println("Enter the " + size2 + " number of single digit array elements  : ");
        for(int i = 0 ; i < size2 ; i++)
        {
            nums2[i] = sc.nextInt();
        }

        Node head1 = convertArrayToLL(nums1);
        Node head2 = convertArrayToLL(nums2);

        Node head = addBrute(head1, head2);

        System.out.println("The LL after adding : ");
        printLL(head);
    }
}   