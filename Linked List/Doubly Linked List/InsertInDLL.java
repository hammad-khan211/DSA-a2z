import java.util.*;

class Node
{
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

class InsertInDLL
{
    static Node InsertHeadInDLL(Node head , int val)
    {
        if(head == null)
        {
            return new Node(val);
        }
        Node newHead = new Node(val , null , head);
        head.prev = newHead;
        head = newHead;
        return head;
    }

    static Node InsertTailInDLL(Node head , int val)
    {
        if(head == null)
        {
            return new Node(val);
        }
        Node tail = head;
        while(tail.next != null)
        {
            tail = tail.next;
        }
        Node newTail = new Node(val , tail , null);
        tail.next = newTail;
        return head;
    }

    static Node insertKthNodeInDLL(Node head , int pos , int el)
    {
        if(head == null)
        {
            if(pos == 1)
            {
                return new Node(el);
            }
            else{
                return null;
            }
        }
        if(pos == 1)
        {
            Node newHead = new Node(el , null , head);
            head.prev = newHead;
            return newHead;
        }
        Node temp = head;
        int count = 0;
        while(temp != null)
        {
            count++;
            if(count == pos)
            {
                break;
            }
            temp = temp.next;
        }

        if(temp == null)
        {
            Node tail = head;
            while(tail.next != null)
            {
                tail = tail.next;
            }
            Node newNode = new Node(el , tail , null);
            tail.next = newNode;
            return head;
        }

        Node prev = temp.prev;
        Node newNode = new Node(el , prev , temp);
        prev.next = newNode;
        temp.prev = newNode;
        return head;
    }

    static Node convertArrayToDLL(int[] nums)
    {
        if(nums.length == 0) return null;
        Node start = new Node(nums[0]);
        Node prev = start;
        for(int i = 1 ; i < nums.length ; i++)
        {
            Node temp = new Node(nums[i]);
            temp.prev = prev;
            prev.next = temp;
            prev = temp;
        }
        return start;
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

        System.out.println("Enter the element to be added at head : ");
        int el1 = sc.nextInt();
        System.out.println("Before inserting at head : ");
        Node start = convertArrayToDLL(nums);
        printDLL(start);
        System.out.println("After inserting at head : ");
        start = InsertHeadInDLL(start , el1);
        printDLL(start);

        System.out.println("---------------------------------------------------------------------");

        System.out.println("Enter the element to be added after tail : ");
        int el2 = sc.nextInt();
        System.out.println("Before inserting at tail : ");
        printDLL(start); 
        System.out.println("After inserting at tail : ");
        start = InsertTailInDLL(start , el2);
        printDLL(start);

        System.out.println("---------------------------------------------------------------------");


        System.out.println("Enter the position to enter new element in the range 1 <= k <= size + 1 : ");
        int k = sc.nextInt();
        System.out.println("Enter the element to be inserted at " + k + " position : ");
        int el3 = sc.nextInt();
        System.out.println("Before inserting element at " + k + " : ");
        printDLL(start);
        System.out.println("After inserting " + el3 + " element at " + k + " : ");
        start  = insertKthNodeInDLL(start , k , el3);
        printDLL(start);

    }

}