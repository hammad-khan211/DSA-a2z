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
public class Sort012LL
{
    static Node sortBrute(Node head) //tc O(N) sc O(1) double pass
    {
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        Node temp = head;
        while(temp != null)
        {
            if(temp.data == 0) c0++;
            else if(temp.data == 1) c1++;
            else c2++;
            temp = temp.next;
        }
        while(c0-- > 0)
        {
            temp.data = 0;
            temp = temp.next;
        }
        while(c1-- > 0)
        {
            temp.data = 1;
            temp = temp.next;
        }
        while(c2-- > 0)
        {
            temp.data = 2;
            temp = temp.next;
        }
        return head;
    }


//-------------------------------------------------------------------------------------------------------------------------------

    static Node sortOptimal(Node head)  //tc O(N) sc O(1) single pass
    {
        Node zeroHead = new Node(-1);
        Node zero = zeroHead;

        Node oneHead = new Node(-1);
        Node one = oneHead;

        Node twoHead = new Node(-1);
        Node two = twoHead;

        Node temp = head;
        while(temp != null)
        {
            if(temp.data == 0)
            {
                zero.next = temp;
                zero = zero.next;
            }
            else if(temp.data == 1)
            {
                one.next = temp;
                one = one.next;
            }
            else
            {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;
        return zeroHead.next;
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
        System.out.println("Enter the " + size + " number of array elements (only 0 , 1 and 2) : ");
        for(int i = 0 ; i < size ; i++)
        {
            nums[i] = sc.nextInt();
        }
        System.out.println("The LL before sorting : ");
        Node head = convertArrayToLL(nums);
        printLL(head);

        System.out.println("The LL after sorting : ");
        head = sortOptimal(head);
        printLL(head);
    }
}   