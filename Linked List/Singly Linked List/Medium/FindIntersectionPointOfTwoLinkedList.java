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
public class FindIntersectionPointOfTwoLinkedList
{
    static Node findIntersectionBrute(Node head1 , Node head2) //tc O(N + M) sc O(N)
    {
        HashMap < Node , Integer > mpp = new HashMap<>();
        Node temp = head1;
        while(temp != null)
        {
            mpp.put(temp , 1);
            temp = temp.next;
        }
        temp = head2;
        while(temp != null)
        {
            if(mpp.containsKey(temp))
            {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    static Node findIntersectionOptimal(Node headA , Node headB) //tc O(N + M) SC O(1)
    {
        int NA = findLength(headA);
        int NB = findLength(headB);

        int diff = 0;

        Node tA = headA;
        Node tB = headB;

        if(NA > NB)
        {
            diff = NA - NB;
            while(diff-- > 0)
            {
                tA = tA.next;
            }
        } 
        else 
        {
            diff = NB - NA;
            while(diff-- > 0)
            {
                tB = tB.next;
            }
        }

        while(tA != tB)
        {
            tA = tA.next;
            tB = tB.next;
        }
        return tA;
    }

    static int findLength(Node head)
    {
        int count = 0;
        Node temp = head;
        while(temp != null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }

    static Node findIntersectionMostOptimal(Node headA , Node headB) //tc O(N + M) SC O(1)
    {
        if(headA == null || headB == null) return null;
        Node temp1 = headA;
        Node temp2 = headB;

        while(temp1 != temp2)
        {
            temp1 = temp1 == null ? headB : temp1.next;
            temp2 = temp2 == null ? headA : temp2.next;
        }
        return temp1; 
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

        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5};

        Node head1 = convertArrayToLL(arr1);
        Node head2 = convertArrayToLL(arr2);

        // Create common part
        Node common1 = new Node(8);
        Node common2 = new Node(9);
        Node common3 = new Node(10);

        common1.next = common2;
        common2.next = common3;

        // Connect both lists to the SAME node
        Node temp = head1;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = common1;

        temp = head2;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = common1;

        System.out.println("List 1:");
        printLL(head1);

        System.out.println("List 2:");
        printLL(head2);

        Node intersection = findIntersectionMostOptimal(head1, head2);

        if(intersection != null)
        {
            System.out.println("Intersection Point: " + intersection.data);
        }
        else
        {
            System.out.println("No intersection");
        }

    sc.close();
    }
}   