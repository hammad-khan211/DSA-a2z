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

class ReverseNodesInKGroup
{
    static Node reverseInKGroups(Node head , int k)
    {
        Node temp = head;
        Node prev = null;
        while(temp != null)
        {
            Node KthNode = findKNode(temp , k);
            if(KthNode == null)
            {
                if(prev != null) prev.next = temp;
                break;
            }
            Node next = KthNode.next;
            KthNode.next = null;
            reverse(temp);
            if(temp == head)
            {
                head = KthNode;
            }
            else
            {
                prev.next = KthNode;
            }
            prev = temp;
            temp = next;
        }
        return head;
    }

    static Node findKNode(Node head , int k)
    {
        Node temp = head;
        while(temp != null && k > 1)
        {
            temp = temp.next;
            k--;
        }
        return temp;
    }

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

    static Node convertArrayToLL(int[] nums)
    {
        if(nums.length == 0) return null;
        Node start = new Node(nums[0]);
        Node mover = start;
        for(int i = 1 ; i < nums.length ; i++)
        {
            mover.next = new Node(nums[i]);
            mover = mover.next;
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

        System.out.println("Enter the value of k : ");
        int k = sc.nextInt();

        Node start = convertArrayToLL(nums);
        System.out.println("Before reversing nodes in " + k + " groups ");
        printLL(start);

        System.out.println("After reversing nodes in " + k + " groups ");
        start = reverseInKGroups(start, k);
        printLL(start);
    }

}