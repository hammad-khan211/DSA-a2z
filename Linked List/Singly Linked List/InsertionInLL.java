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

class InsertionInLL
{
    static Node insertAtHead(Node head , int x) //tc O(1) sc O(1)
    {
        // if(head == null)
        // {
        //     return new Node(x);
        // }
        // Node temp = new Node(x);
        // temp.next = head;
        // head = temp; 
        // return head;

        Node temp = new Node(x , head);
        return temp;
    }

    static Node insertAtTail(Node head , int x) //tc O(n) sc O(1)
    {
        if(head == null)
        {
            return new Node(x);
        }
        Node temp = new Node(x);
        Node current = head;
        while(current.next != null)
        {
            current = current.next;
        }
        current.next = temp;
        return head;
    }

    static Node insertAtKthPos(Node head , int k , int val) //tc O(n) sc O(1)
    {
        if(head == null)
        {
            if(k == 1)
            {
                return new Node(val);
            }
            else
            {
                return null;
            }
        }
        if(k == 1)
        {
            Node temp = new Node(val , head);
            return temp;
        }
        Node newNode = new Node(val);
        Node temp = head;
        int count = 0;
        while(temp != null)
        {
            count++;
            if(count == k - 1)
            {
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    static Node insertBeforeVal(Node head , int el , int val)
    {
        if(head == null)
        {
            return null;
        }
        if(head.data == val)
        {
            Node temp = new Node(el , head);
            return temp;
        }
        Node newNode = new Node(el);
        Node prev = head;
        Node temp = head.next;
        while(temp != null)
        {
            if(temp.data == val)
            {
                newNode.next = prev.next;
                prev.next = newNode;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    static Node convertArrayToLL(int[] nums)
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
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args)
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
        System.out.println("Enter the element to be inserted at beginning : ");
        int h = sc.nextInt();

        Node head = convertArrayToLL(nums);
        System.out.println("Before inserting element at head : ");
        printLL(head);

        System.out.println("After inserting " + h + " at beginning : ");
        head = insertAtHead(head, h);
        printLL(head);

        System.out.println("Enter the element to be inserted at last : ");
        int t = sc.nextInt();

        System.out.println("Before inserting element at tail : ");
        printLL(head);

        System.out.println("After inserting " + t + " at tail : ");
        head = insertAtTail(head, t);
        printLL(head);

        System.out.println("Enter the position to enter new element in the range 1 <= k <= size + 1 : ");
        int k = sc.nextInt();

        System.out.println("Enter the element to be inserted at " + k + " position : ");
        int val = sc.nextInt();

        System.out.println("Before inserting element at " + k + " : ");
        printLL(head);

        System.out.println("After inserting " + val + " element at " + k + " : ");
        head = insertAtKthPos(head , k , val);
        printLL(head);

        System.out.println("Enter the value of the element before which the new node will enter : ");
        int val1 = sc.nextInt();

        System.out.println("Enter the element to be inserted before " + val1 + " : ");
        int el = sc.nextInt();

        System.out.println("Linked List before inserting element " + el + " before val " + val1 + " : ");
        printLL(head);

        System.out.println("Linked List after inserting element " + el + " before val " + val1 + " : ");
        head = insertBeforeVal(head, el, val1);
        printLL(head);
    }
}