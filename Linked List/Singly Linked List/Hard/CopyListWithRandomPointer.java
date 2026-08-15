import java.util.*;

class Node
{
    int data;
    Node next;
    Node random;

    Node(int data1, Node next1, Node random1)
    {
        this.data = data1;
        this.next = next1;
        this.random = random1;
    }

    Node(int data1)
    {
        this.data = data1;
        this.next = null;
        this.random = null;
    }
}

class CopyListWithRandomPointer
{
    static Node giveCopyBrtue(Node head)
    {
        Node temp = head;

        HashMap<Node, Node> mpp = new HashMap<>();

        // Create all copied nodes
        while(temp != null)
        {
            Node newNode = new Node(temp.data);
            mpp.put(temp, newNode);
            temp = temp.next;
        }

        // Connect next and random pointers
        temp = head;

        while(temp != null)
        {
            Node copy = mpp.get(temp);

            copy.next = mpp.get(temp.next);
            copy.random = mpp.get(temp.random);

            temp = temp.next;
        }

        return mpp.get(head);
    }

    static Node giveCopyNodeOptimal(Node head)
    {
        Node temp = head;
        while(temp != null) //put copy nodes in between
        {
            Node copy = new Node(temp.data);
            copy.next = temp.next;
            temp.next = copy;
            temp = temp.next.next;
        }
        temp = head;
        while(temp != null) //put copy noes random
        {
            Node copyNode = temp.next;
            if(temp.random != null) copyNode.random = temp.random.next;
            temp = temp.next.next;
        }

        Node dummy = new Node(-1);
        Node mover = dummy;
        temp  = head;
        while(temp != null) //put copy node next
        {
            mover.next = temp.next;
            temp.next = temp.next.next;
            mover = mover.next;
            temp = temp.next;
        }
        return dummy.next;
    }

    // Convert array into linked list
    static Node convertArrayToDLL(int[] nums)
    {
        if(nums.length == 0)
        {
            return null;
        }

        Node head = new Node(nums[0]);
        Node temp = head;

        for(int i = 1; i < nums.length; i++)
        {
            Node newNode = new Node(nums[i]);
            temp.next = newNode;
            temp = newNode;
        }

        return head;
    }

    // Print linked list along with random pointer
    static void printDLL(Node head)
    {
        Node temp = head;

        while(temp != null)
        {
            System.out.print("Data = " + temp.data);

            if(temp.random != null)
            {
                System.out.println(", Random = " + temp.random.data);
            }
            else
            {
                System.out.println(", Random = null");
            }

            temp = temp.next;
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of nodes: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the data of the nodes:");

        for(int i = 0; i < n; i++)
        {
            System.out.print("Enter data for node " + (i + 1) + ": ");
            nums[i] = sc.nextInt();
        }

        // Create the linked list
        Node head = convertArrayToDLL(nums);

        // Store nodes in an ArrayList so that
        // user can specify random pointers using index
        ArrayList<Node> nodes = new ArrayList<>();

        Node temp = head;

        while(temp != null)
        {
            nodes.add(temp);
            temp = temp.next;
        }

        // Take random pointer input
        System.out.println("\nEnter random pointer index for each node.");
        System.out.println("Use -1 if random pointer is NULL.");
        System.out.println("Index starts from 0.");

        for(int i = 0; i < n; i++)
        {
            System.out.print("Random pointer of node " + i + " (data = "
                    + nodes.get(i).data + ") points to index: ");

            int index = sc.nextInt();

            if(index == -1)
            {
                nodes.get(i).random = null;
            }
            else if(index >= 0 && index < n)
            {
                nodes.get(i).random = nodes.get(index);
            }
            else
            {
                System.out.println("Invalid index! Random pointer set to NULL.");
                nodes.get(i).random = null;
            }
        }

        System.out.println("\nOriginal Linked List:");
        printDLL(head);

        // Copy the linked list
        Node copyHead = giveCopyNodeOptimal(head);

        System.out.println("\nCopied Linked List:");
        printDLL(copyHead);

        sc.close();
    }
}