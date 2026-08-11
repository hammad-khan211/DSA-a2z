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
public class SortLL
{
    static Node sortOptimal(Node head) // tc O(n log n) sc O(log n)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        Node middle = findMiddle(head);
        Node leftHead = head;
        Node rightHead = middle.next;
        middle.next = null;
        
        leftHead = sortOptimal(leftHead);
        rightHead = sortOptimal(rightHead);
        return merge(leftHead , rightHead);
    }

    static Node findMiddle(Node head)
    {
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node merge(Node head1 , Node head2)
    {
        Node t1 = head1;
        Node t2 = head2;

        Node dummy = new Node(-1);
        Node mover = dummy;

        while(t1 != null && t2 != null)
        {
            if(t1.data <= t2.data)
            {
                mover.next = t1;
                mover = mover.next;
                t1 = t1.next;
            }
            else
            {
                mover.next = t2;
                mover = mover.next;
                t2 = t2.next;     
            }
        }
        mover.next = (t1 != null) ? t1 : t2;
        return dummy.next;
    }

//-------------------------------------------------------------------------------------------------------------------------------

    static Node sortBrute(Node head) //tc O(n log n) sc O(n)
    {
        List < Integer > nums = new ArrayList<>();
        Node temp = head;
        while(temp != null)
        {
            nums.add(temp.data);
            temp = temp.next;
        }
        Collections.sort(nums);
        temp = head;
        int i = 0;
        while(temp != null)
        {
            temp.data = nums.get(i);
            i++;
            temp = temp.next;
        }
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
        System.out.println("The LL before sorting : ");
        Node head = convertArrayToLL(nums);
        printLL(head);

        System.out.println("The LL after sorting : ");
        head = sortOptimal(head);
        printLL(head);
    }
}   