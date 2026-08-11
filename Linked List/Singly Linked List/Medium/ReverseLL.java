import java.util.*;

class Node{
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

class ReverseLL
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
            Node next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        Node newHead = prev;
        return newHead;
    }

    static Node reverseRecursion(Node head) //tc O(n) sc O(n)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        Node newHead = reverseRecursion(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    static Node arrayToLL(int[] nums)
    {
        if(nums.length == 0) return null;
        Node head = new Node(nums[0]);
        Node mover = head;
        for(int i = 1 ; i < nums.length ; i++)
        {
            Node temp = new Node(nums[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
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

        Node start = arrayToLL(nums);
        System.out.println("LL before reverse : ");
        printLL(start);
        System.out.println("LL after reverse : ");
        start = reverseRecursion(start);
        printLL(start);
    }
}