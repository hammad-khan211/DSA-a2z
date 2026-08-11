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
public class Merge2SortedLL
{

    static Node mergeBrute(Node head1 , Node head2) //tc O((n + m)log(n + m)) sc O(n + m)
    {
        List < Integer > nums = new ArrayList<>();
        Node temp = head1;
        while(temp != null)
        {
            nums.add(temp.data);
            temp = temp.next;
        }
        temp = head2;
        while(temp != null)
        {
            nums.add(temp.data);
            temp = temp.next;
        }
        Collections.sort(nums);

        Node dummy = new Node(-1);
        Node mover = dummy;

        for(int i = 0 ; i < nums.size() ; i++)
        {
            mover.next = new Node(nums.get(i));
            mover = mover.next;
        }
        return dummy.next;
    }

    static Node mergeOptimal(Node head1 , Node head2) // tc O(n + m) sc O(1)
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
        System.out.println("Enter the " + size1 + " number of array1 elements in sorted order : ");
        for(int i = 0 ; i < size1 ; i++)
        {
            nums1[i] = sc.nextInt();
        }
        Node head1 = convertArrayToLL(nums1);

        System.out.println("Enter the size of the array 2 : ");
        int size2 = sc.nextInt();
        int[] nums2 = new int[size2];
        System.out.println("Enter the " + size2 + " number of array1 elements in sorted order : ");
        for(int i = 0 ; i < size2 ; i++)
        {
            nums2[i] = sc.nextInt();
        }
        Node head2 = convertArrayToLL(nums2);

        System.out.println("The LL after merging : ");
        Node ans = mergeOptimal(head1 , head2);
        printLL(ans);
    }
}   