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
public class CheckPalindromeLL
{

    static boolean isPalindromeBrute(Node head) 
    {
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
            if(temp.data != stack.pop())
            {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    static boolean isPalindromeOptimal(Node head)  //tc  O(N)  sc O(1)
    {
        if(head == null || head.next == null) return true;
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node newHead = reverse(slow.next);

        Node p1 = head;
        Node p2 = newHead;
        while(p2 != null)
        {
            if(p1.data != p2.data)
            {
                reverse(newHead);
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        reverse(newHead);
        return true;
    }

    static Node reverse(Node head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
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
        
        Node head = convertArrayToLL(nums);
        if(isPalindromeOptimal(head))
        {
            System.out.println("Palindorme");
        }
        else
        {
            System.out.println("Not Palindrome");
        }
    }
}   