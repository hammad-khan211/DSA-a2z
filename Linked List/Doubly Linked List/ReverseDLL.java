import java.util.*;

class Node{
    int data;
    Node prev;
    Node next;

    Node(int data1 , Node prev1 , Node next1)
    {
        this.data = data1;
        this.prev = prev1;
        this.next = next1;
    }

    Node(int data1)
    {
        this.data = data1;
        this.prev = null;
        this.next = null;
    }
}

class ReverseDLL
{
    static Node reverseBrute(Node head) //tc O(N) sc O(N)
    {
      if(head == null || head.next == null) return head;
        Stack < Integer > stack = new Stack<>();
        Node temp = head;
        while(temp != null)
        {
            stack.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while(temp != null)
        {
            temp.data = stack.pop();
            temp = temp.next;
        }
        return head;

    }

    static Node reverseBetter(Node head) //tc O(N) sc O(1)
    {
        if(head == null || head.next == null) return head;
        Node temp = head;
        Node prev = null;
        while(temp != null)
        {
            prev = temp.prev;
            temp.prev = temp.next;
            temp.next = prev;
            temp = temp.prev;
        }
        Node newHead = prev.prev;
        return newHead;
    }

    static Node arrayToDLL(int[] nums)
    {
        Node head = new Node(nums[0]);
        Node prev = head;
        for(int i = 1 ; i < nums.length ; i++)
        {
            Node temp = new Node(nums[i] , prev , null);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    static void printDLL(Node head)
    {
        Node current = head;
        while(current != null)
        {
            System.out.print(current.data + " <-> ");
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

        Node start = arrayToDLL(nums);
        System.out.println("DLL before reverse : ");
        printDLL(start);
        System.out.println("DLL after reverse : ");
        start = reverseBetter(start);
        printDLL(start);
    }
}