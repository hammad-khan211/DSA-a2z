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
public class ArraytoLL
{
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

    static int findLLlength(Node head) //tc O(n)
    {
        int count = 0;
        Node current = head;
        while(current != null)
        {
            count++;
            current = current.next;
        }
        return count;
    }

    static boolean searchElement(Node head , int key) //tc O(n)
    {
        Node current = head;
        while(current != null)
        {
            if(current.data == key) return true;
            current = current.next;
        }
        return false;
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
        System.out.println("Enter the element to be searched in LL : ");
        int key = sc.nextInt();
        Node head = convertArrayToLL(nums);
        printLL(head);
        int count = findLLlength(head);
        System.out.println("Length of LL : " + count);
        if(searchElement(head , key))
        {
            System.out.println(key + " is present in Linked List");
        }
        else
        {
            System.out.println(key + " is not present in Linked List");  
        }


    }
}   