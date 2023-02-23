interface Quene {
    public void Enqune(int x);

    public void dequene();

    public boolean isEmpty();

    public void display();

    public Super QueneEexcpetion(String s);
}

class QueneImplLL implements Quene {
    public class Node {
        int data;
        Node next;
    }

    private Node head;
    private Node tail;

    public void Enqune(int x) {

        if (isEmpty()) {
            Node node = new Node();
            node.data = x;
            node.next = null;
            head = node;
            tail = node;
        } else {
            Node node = new Node();
            node.data = x;
            node.next = null;
            tail.next = node;
            tail = node;
        }
    }

    public void dequene() {

        head = head.next;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void display() {
        Node t = head;
        System.out.println("\nQuenue contents are :");
        System.out.println("Top - ");
        while (t != null) {
            System.out.println(t.data + " ");
            t = t.next;
        }
        System.out.println("\n");
    }

}

class QueneCb implements Quene {
    private int q[], head, tail;
    private int qmax, size;

    public QueneCb() {
        qmax = 4;
        size = head = tail = 0;
        q = new int[qmax];
    }

    public void Enqune(int x) {
        if (isFull()) {
            System.out.println("Quene is full");
            return;
        }
        else{
            q[tail] = x;
            tail = (tail + 1) % qmax;
            size++;
        }
    }

    public void dequene() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }
        head = (head + 1) % qmax;
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == qmax;
    }

    public void display() {
        System.out.println("\nQueue contents are :");
        System.out.println("Top - ");

        int i = head;
        int count = 0;

        while(count < size - 1){
            System.out.println(q[i]);
            i = (i + 1) % qmax;
            count++;
        }
        System.out.println(q[i]);
    }

}

public class QueneTest {
    public static void main(String[] arg) {
        Quene q1 ,q2;
        // q1 = new QueneImplLL();
        q2 = new QueneCb();

        q2.Enqune(10);
        q2.Enqune(1);
        q2.Enqune(3);
        q2.Enqune(5);
        q2.Enqune(15);
        q2.dequene();
        q2.dequene();
        q2.dequene();
        q2.Enqune(15);
        q2.Enqune(15);
        q2.Enqune(12);
        q2.display();

        // more test code
    }
}
