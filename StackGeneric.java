class Node<T>{
    T data;
    Node<T> next;
}


interface Stack<T>{
    public void push(T element);
    public T pop();
    public boolean isEmpty();
    public void display();
}

class stackImpl<T> implements Stack<T>{
    private Node<T> top;

    public stackImpl(){
        top = null;
    }

    public void push(T x){
        Node<T> t = new Node<T>();
        t.data = x;
        t.next = top;
        top = t;
    }

    public T pop(){
        T y = top.data;
        top = top.next;
        return y;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void display(){
        Node<T> t = top;
        System.out.println("\nStack contents are :");
        System.out.println("Top - ");
        while (t != null){
            System.out.println(t.data + " ");
            t = t.next;
        }
        System.out.println("\n");
    }


}



public class StackGeneric
{
    public static void main( String[] arg){
        stackImpl <Integer> s = new stackImpl <Integer>();
        
        System.out.println("Stack is created\n");
        
        s.push(10); s.push(3);
        s.push(11); s.push(7);
        s.push(23);
        
        s.display();
        
       
        Integer i = s.pop();
        System.out.println("Just popped " + i);
        s.display();
        
		
    }
}
