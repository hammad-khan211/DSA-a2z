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
public class findLengthOfLoopInLL
{

    static int findLoopLengthBrute(Node head) //tc O(N) sc O(N)
    {
        int length = 0;
        int timer = 1;
        HashMap < Node , Integer > mpp = new HashMap<>();
        Node temp = head;
        while(temp != null)
        {
            if(mpp.containsKey(temp))
            {
                length = timer - mpp.get(temp);
                break;
            }
            mpp.put(temp , timer);
            temp = temp.next;
            timer++;
        }
        return length;
    }

    static int findLoopLengthOptimal(Node head) //Tortoisee & Hare  tc O(n) sc O(1)
    {
        int length = 0;
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                length = 1;
                fast = fast.next;
                while(slow != fast)
                {
                    fast = fast.next;
                    length++;
                }
                break;
            }
        }
        return length;
    }

    static Node convertArrayToLL(int[] arr , int pos) //tc O(n)
    {
        if(arr.length == 0)
        {
            return null;
        }
        Node head = new Node(arr[0]);
        Node mover = head;
        Node loopNode = null;

        if(pos == 0)
        {
            loopNode = head;
        }

        for(int i = 1 ; i < arr.length ; i++)
        {
            mover.next = new Node(arr[i]);
            mover = mover.next;

            if(i == pos)
            {
                loopNode = mover;
            }
        }

        if(pos >= 0 &&  pos < arr.length)
        {
            mover.next = loopNode;
        }
        return head;
    }


    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int size = sc.nextInt();
        System.out.println("Enter the array index where u want to start the loop : ");
        int pos = sc.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter the " + size + " number of array elements : ");
        for(int i = 0 ; i < size ; i++)
        {
            nums[i] = sc.nextInt();
        }
        Node head = convertArrayToLL(nums, pos);
        int ans = findLoopLengthOptimal(head);
        if(ans == 0)
        {
            System.out.println("Loop doesnt exitst");
        }
        else
        {
            System.out.println("Loop length : " + ans);
        }
    }
}   