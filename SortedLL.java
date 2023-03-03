
// Sorted linked list with a sentinel node
// Skeleton code
import java.util.Scanner;

class SortedLL {
    // internal data structure and
    // constructor code to be added here
    class Node {
        public int data;
        Node next;
    }

    private Node sentital, z;

    private Node prev, curr, t;

    public SortedLL() {

        sentital = new Node();
        sentital.data = 0;
        sentital.next = null;
        z = new Node();
        z.data = Integer.MAX_VALUE; // set a large value for the sentinel node
        z.next = null;
    }

    // this is the crucial method
    public void insert(int x) {
        Node t = new Node();
        t.data = x;
        t.next = null;

        if (sentital.next == null) {
            // if the list is empty, insert at the beginning
            sentital.next = t;
            t.next = z;
            return;
        }

        // traverse the list to find the correct insertion point
        prev = sentital;
        curr = sentital.next;

        while (curr != z && curr.data < x) {
            prev = curr;
            curr = curr.next;
        }

        // insert the new node after prev and before curr
        prev.next = t;
        t.next = curr;
    }

    public boolean remove(int x) {

        prev = sentital;

        curr = sentital.next;

        if (isEmpty()) {
            return false;
        }

        if (curr.data == x) {
            sentital.next = curr.next;
            return true;
        }

        while (curr != null && curr.data != x) {
            prev = curr;
            curr = curr.next;
        }

        if (curr != null) {
            prev.next = curr.next;
            return true;
        } else {
            System.out.println("Value not in list");
            return false;
        }
    }

    public boolean isEmpty() {
        return sentital.next == null;
    }

    public void display() {
        Node t = sentital.next;
        System.out.print("\nHead -> ");
        while (t != z) {
            System.out.print(t.data + " -> ");
            t = t.next;
        }
        System.out.println("Z\n");
    }

    public static void main(String args[]) {
        SortedLL list = new SortedLL();
        // list.display();

        double x;
        int i, r;

        Scanner in = new Scanner(System.in); // create Scanner object outside loop

        for (i = 1; i <= 5; ++i) {
            x = (Math.random() * 100.0);
            r = (int) x;
            System.out.println("Inserting " + r);
            list.insert(r);
            list.display();
        }

        while (!list.isEmpty()) {
            System.out.println("\nInput a value to remove: ");
            r = in.nextInt(); // reuse Scanner object for each iteration
            if (list.remove(r)) {
                System.out.println("\nSuccessfully removed: " + r);
                list.display();
            } else
                System.out.println("\nValue not in list");
        }

        in.close(); // close Scanner object after use
    }

}