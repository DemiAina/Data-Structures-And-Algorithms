// StackTest.java
// Linked list implementation of Stack

class StackException extends Exception{
    
    public StackException(String s){
        super(s);
    }

}


class Stack {
    
    class Node {
        int data;
        Node next;  
    }
    private Node top;
      
    public Stack()
    { 
        top = null;
    }
        
    public void push(int x) {
        Node  t = new Node();
        t.data = x;
        t.next = top;
        top = t;
    }

    public int pop() throws Exception{
        if (isEmpty()) { // same as isEmpty() == true
            throw new StackException("Stack is empty");
        }
       int x = top.data;
        top = top.next;
        return x;
    }

    // pop() method here
    // only to be called if list is non-empty.
    // Otherwise an exception should be thrown.
    public boolean isEmpty(){
        return top == null;
      }


    public void display() {
        Node t = top;     
        System.out.println("\nStack contents are:  ");
        
        while (t != null) {
            System.out.print(t.data + " ");
            t = t.next;
        }        
        System.out.println("\n");
    }

}


public class StackTest
{
    public static void main( String[] args) throws Exception{
        Stack s = new Stack();
        //Console.Write("Stack is created\n");
        System.out.println("Stack is created\n");
        
        try{
            s.pop();
        }catch(StackException e){
            System.out.println("Exception throws " + e);
        }
        s.push(10); s.push(3); s.push(11); s.push(7);
        s.display();
        
        int i = s.pop();
        s.push(11);
        System.out.println("Just popped " + i);
        s.display();
    }
}


