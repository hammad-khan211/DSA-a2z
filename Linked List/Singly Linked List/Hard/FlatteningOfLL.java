import java.util.*;

class Node
{
    int data;
    Node next;
    Node bottom;

    Node(int data1, Node next1, Node bottom1)
    {
        this.data = data1;
        this.next = next1;
        this.bottom = bottom1;
    }

    Node(int data1)
    {
        this.data = data1;
        this.next = null;
        this.bottom = null;
    }
}

class FlatteningOfLL
{
    static Node brute(Node head)
    {
        ArrayList<Integer> nums = new ArrayList<>();

        Node temp = head;

        while(temp != null)
        {
            nums.add(temp.data);

            Node child = temp.bottom;

            while(child != null)
            {
                nums.add(child.data);
                child = child.bottom;
            }

            temp = temp.next;
        }

        Collections.sort(nums);

        if(nums.size() == 0)
            return null;

        Node newHead = new Node(nums.get(0));
        Node mover = newHead;

        for(int i = 1; i < nums.size(); i++)
        {
            mover.bottom = new Node(nums.get(i));
            mover = mover.bottom;
        }

        return newHead;
    }

    static Node optimal(Node head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }

        head.next = optimal(head.next);

        head = merge(head, head.next);

        return head;
    }

    static Node merge(Node head1, Node head2)
    {
        Node t1 = head1;
        Node t2 = head2;

        Node dummy = new Node(-1);
        Node mover = dummy;

        while(t1 != null && t2 != null)
        {
            if(t1.data <= t2.data)
            {
                mover.bottom = t1;
                mover = mover.bottom;
                t1 = t1.bottom;
            }
            else
            {
                mover.bottom = t2;
                mover = mover.bottom;
                t2 = t2.bottom;
            }
        }

        mover.bottom = (t1 != null) ? t1 : t2;

        return dummy.bottom;
    }

    static Node convertArrayToLL(int[] nums)
    {
        if(nums.length == 0)
            return null;

        Node head = new Node(nums[0]);
        Node mover = head;

        for(int i = 1; i < nums.length; i++)
        {
            mover.bottom = new Node(nums[i]);
            mover = mover.bottom;
        }

        return head;
    }

    static void printLL(Node head)
    {
        Node temp = head;

        while(temp != null)
        {
            System.out.print(temp.data);

            if(temp.bottom != null)
                System.out.print(" -> ");

            temp = temp.bottom;
        }

        System.out.println();
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of linked lists: ");
        int n = sc.nextInt();

        Node head = null;
        Node last = null;

        for(int i = 0; i < n; i++)
        {
            System.out.print("\nEnter number of elements in list " + (i + 1) + ": ");
            int size = sc.nextInt();

            int[] nums = new int[size];

            System.out.println("Enter " + size + " sorted elements:");

            for(int j = 0; j < size; j++)
            {
                nums[j] = sc.nextInt();
            }

            Node current = convertArrayToLL(nums);

            // Connect current list using next pointer
            if(head == null)
            {
                head = current;
            }
            else
            {
                last.next = current;
            }

            last = current;
        }

        System.out.println("\nOriginal Linked Lists:");

        Node temp = head;

        while(temp != null)
        {
            printLL(temp);
            temp = temp.next;
        }

        System.out.println("\nFlattening the linked list...");

        Node ans = optimal(head);

        System.out.println("\nFlattened Linked List:");

        printLL(ans);

        sc.close();
    }
}