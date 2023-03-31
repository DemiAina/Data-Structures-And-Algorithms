import java.util.Scanner;

public class SortedDLL {
    private Node head; // head node
    private Node z; // sentinal node
    
    // constructor
    public SortedDLL() {
        z = new Node(0); // sentinal node for DLL
        head = new Node(0); // head node for DLL
        head.next = z; // link head node to sentinal node
        z.prev = head; // link sentinal node to head node
    }

    // private nested class 
    private class Node {
        int data;
        Node prev;
        Node next;

        // constructor
        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public void insert(int x) {
        Node curr = head.next; // initialize current var

        // traverse DLL while true
        while (curr != z && curr.data < x) {
            curr = curr.next; // move current var to next node in DLL
        }
        Node newNode = new Node(x);
        newNode.prev = curr.prev; // points to node before current in DLL
        newNode.next = curr; // update next pointer of the new nodebefore current
        curr.prev.next = newNode; // in the DLL to point to the new node
        curr.prev = newNode; // Update the previous pointer of current to point to the new node
    }

    public boolean remove(int x) {
        Node curr = head.next;
        while (curr != z && curr.data < x) {
            curr = curr.next;
        }
        if (curr != z && curr.data == x) {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        return head.next == z;
    }

    public void display() {
        Node curr = head.next;
        System.out.print("Head -> ");
        while (curr != z) {
            System.out.print(curr.data + " <-> ");
            curr = curr.next;
        }
        System.out.println("Z\n");
    }

    public static void main(String[] args) {
        SortedDLL list = new SortedDLL();
        list.display();
        
        double x;
        int i, r;
        
        
        for(i = 1; i <= 5; ++i) {
            x =  (Math.random()*100.0);
            r = (int) x; 
            System.out.println("Inserting " + r);
            list.insert(r);
            list.display();            
        }
        
        while (!list.isEmpty()) {
            System.out.println("\nInput a value to remove: ");
            Scanner in = new Scanner(System.in);
            r = in.nextInt();
            if(list.remove(r)) {
                System.out.println("\nSuccessfully removed: " + r);
                list.display(); 
            } else {
                System.out.println("\nValue not in list"); 
            }
        }
    }
}
