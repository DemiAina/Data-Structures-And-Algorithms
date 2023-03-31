// Simple weighted graph representation 
// Uses an Adjacency Linked Lists, suitable for sparse graphs

import java.io.*;


interface Quene {
    public void enqueue(int x);

    public int dequeue();

    public boolean isEmpty();

    public void display();

    // public Super QueneEexcpetion(String s);
}

class QueneImplLL implements Quene {
    public class Node {
        int data;
        Node next;
    }

    private Node head;
    private Node tail;

    public void enqueue(int x) {

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

    public int dequeue() {

        int x = head.data;
        head = head.next;
        return x;
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

// class QueneCb implements Quene {
//     private int q[], head, tail;
//     private int qmax, size;

//     public QueneCb() {
//         qmax = 4;
//         size = head = tail = 0;
//         q = new int[qmax];
//     }

//     public void Enqune(int x) {
//         if (isFull()) {
//             System.out.println("Quene is full");
//             return;
//         }
//         else{
//             q[tail] = x;
//             tail = (tail + 1) % qmax;
//             size++;
//         }
//     }

//     public void dequene() {
//         if (isEmpty()) {
//             System.out.println("Queue is empty");
//         }
//         head = (head + 1) % qmax;
//         size--;
//     }

//     public boolean isEmpty() {
//         return size == 0;
//     }

//     public boolean isFull() {
//         return size == qmax;
//     }

//     public void display() {
//         System.out.println("\nQueue contents are :");
//         System.out.println("Top - ");

//         int i = head;
//         int count = 0;

//         while(count < size - 1){
//             System.out.println(q[i]);
//             i = (i + 1) % qmax;
//             count++;
//         }
//         System.out.println(q[i]);
//     }

// }

// class Heap
// {
//     private int[] a;	   // heap array
//     private int[] hPos;	   // hPos[h[k]] == k
//     private int[] dist;    // dist[v] = priority of v

//     private int N;         // heap size
   
//     // The heap constructor gets passed from the Graph:
//     //    1. maximum heap size
//     //    2. reference to the dist[] array
//     //    3. reference to the hPos[] array
//     public Heap(int maxSize, int[] _dist, int[] _hPos) 
//     {
//         N = 0;
//         a = new int[maxSize + 1];
//         dist = _dist;
//         hPos = _hPos;
//     }


//     public boolean isEmpty() 
//     {
//         return N == 0;
//     }


//     public void siftUp( int k) 
//     {
//         int v = a[k];

//         // code yourself
//         // must use hPos[] and dist[] arrays
//     }


//     public void siftDown( int k) 
//     {
//         int v, j;
       
//         v = a[k];  
        
//         // code yourself 
//         // must use hPos[] and dist[] arrays
//     }


//     public void insert( int x) 
//     {
//         a[++N] = x;
//         siftUp( N);
//     }


//     public int remove() 
//     {   
//         int v = a[1];
//         hPos[v] = 0; // v is no longer in heap
//         a[N+1] = 0;  // put null node into empty spot
        
//         a[1] = a[N--];
//         siftDown(1);
        
//         return v;
//     }

// }

class Graph {
    class Node {
        public int vert;
        public int wgt;
        public Node next;
    }
    
    // V = number of vertices
    // E = number of edges
    // adj[] is the adjacency lists array
    private int V, E;
    private Node[] adj;
    private Node z;
    private int[] mst;
    
    // used for traversing graph
    private int[] visited;
    private int id;
    
    
    // default constructor
    public Graph(String graphFile)  throws IOException
    {
        int u, v;
        int e, wgt;
        Node t;

        FileReader fr = new FileReader(graphFile);
		BufferedReader reader = new BufferedReader(fr);
	           
        String splits = " +";  // multiple whitespace as delimiter
		String line = reader.readLine();        
        String[] parts = line.split(splits);
        System.out.println("Parts[] = " + parts[0] + " " + parts[1]);
        
        V = Integer.parseInt(parts[0]);
        E = Integer.parseInt(parts[1]);
        
        // create sentinel node
        z = new Node(); 
        z.next = z;
        
        // create adjacency lists, initialised to sentinel node z       
        adj = new Node[V+1];        
        for(v = 1; v <= V; ++v)
            adj[v] = z;               
        
       // read the edges
        System.out.println("Reading edges from text file");
        for(e = 1; e <= E; ++e)
        {
            line = reader.readLine();
            parts = line.split(splits);
            u = Integer.parseInt(parts[0]);
            v = Integer.parseInt(parts[1]); 
            wgt = Integer.parseInt(parts[2]);
            
            System.out.println("Edge " + toChar(u) + "--(" + wgt + ")--" + toChar(v));   

           
            
            // write code to put edge into adjacency matrix
            t = new Node();
            t.vert = v;
            t.wgt = wgt;
            t.next = adj[u];
            adj[u] = t;

        }	       
    }
   
    // convert vertex into char for pretty printing
    private char toChar(int u)
    {  
        return (char)(u + 64);
    }
    
    // method to display the graph representation
    public void display() {
        int v;
        Node n;
        
        for(v=1; v<=V; ++v){
            System.out.print("\nadj[" + toChar(v) + "] ->" );
            for(n = adj[v]; n != z; n = n.next) 
                System.out.print(" |" + toChar(n.vert) + " | " + n.wgt + "| ->");    
        }
        System.out.println("");
    }

	public void MST_Prim(int s)
	{
        int v, u;
        int wgt, wgt_sum = 0;
        int[]  dist, parent, hPos;
        Node t;

        //code here
        
        //dist[s] = 0;
        
        //Heap h =  new Heap(V, dist, hPos);
        //h.insert(s);
        
        //while ( ...)  
        //{
            // most of alg here
            
       // }
        System.out.print("\n\nWeight of MST = " + wgt_sum + "\n");
        
                  		
	}
    
    public void showMST()
    {
            System.out.print("\n\nMinimum Spanning tree parent array is:\n");
            for(int v = 1; v <= V; ++v)
                System.out.println(toChar(v) + " -> " + toChar(mst[v]));
            System.out.println("");
    }

    public void SPT_Dijkstra(int s)
    {

    }

    public void DF(int s){
        
        id = 0;
        visited = new int[V+1];
        for(int v = 1; v <= V; ++v)
            visited[v] = 0;
        dfvisit(id,s);



    }

    public void dfvisit(int prev , int v){
        Node t;
        int w;
        prev = id;
        visited[v] = ++id;
        System.out.println("Visited " + toChar(v) + " prev " + toChar(prev));
        for(int u = 1; u <= V; ++u){
            if(visited[u] == 0){
                dfvisit(id,u);
            }
        }
    }

    public void breadthFirst(int s){
        int v, w;
        Node t;
        QueneImplLL q = new QueneImplLL();
        visited = new int[V+1];
        for(v = 1; v <= V; ++v)
            visited[v] = 0;
        visited[s] = ++id;
        q.enqueue(s);
        while(!q.isEmpty()){
            v = q.dequeue();
            System.out.println("Visited node " + toChar(v));
            for(t = adj[v]; t != z; t = t.next){
                w = t.vert;
                System.out.println("Visiting vertex " + toChar(w));
                if(visited[w] == 0){
                    visited[w] = ++id;
                    q.enqueue(w);
                }
            }
        }
    }

}

public class depthFirstSearch {
    public static void main(String[] args) throws IOException
    {
        int s = 2; 
        String fname = "wGraph3.txt";               

        Graph g = new Graph(fname);
       
        g.display();
        // TODO :  ADD vertices to show the graph
       // g.DF(s); // TODO : fix depth first search
        g.breadthFirst(s);
       //g.MST_Prim(s);   
       //g.SPT_Dijkstra(s);               
    }
}