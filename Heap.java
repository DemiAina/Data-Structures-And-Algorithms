// public class Heap {
//     // Can be put into an array
//     // Linked list
//     // CLASS node{
//         // lc
//         // parent
//         // data
//         // rc
//     //}

//     // An array could be wasting space

//     // Complete means no empty slot in array
//     // Random or not Random
//     // not Ordered (sorted)
//     // Partially ordered (max heap)

//     sifitup(int k){
//         u = a[k]
//         a[0] = 99999
//         while (v > a[k/2]){
//             a[K] = a[K/2]
//             k = k/2
//         }
//         a[k] = v;
//     }
//     shiftdown(int k){
//         v = a[k]
//         j = 2k
//         while(j <= N)
//             if(J < n and a[j+1] > a[j] j++)
//             if()
//     }
// }

// Get the Position of the array using an array to present the numbers
// Array values 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 
// Hpos  values 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0
// I can use hpos to get the position of the array

// HPos algorith
// while (j > a[k/2]){
//     a[k] = a[k/2]
//     hpos[a[k]] = k
//    k = k/2
//    a[k] = v
//    hpos[v] = k

// Heap.java
// Skeleton code

class Heap {
   private int[] a;
   int N;
   static int maxH = 100;

   // two constructors
   Heap() {
      N = 0;
      a = new int[maxH + 1];
   }

   Heap(int size) {
      N = 0;
      a = new int[size + 1];

   }

   void siftUp(int k) {
      int v = a[k];
      a[0] = Integer.MAX_VALUE;

      // complete yourself from pseudocode in notes
      while (v > a[k / 2]) {
         a[k] = a[k / 2];
         k = k / 2;
      }
      a[k] = v;
   }

   // Q: why does the last element of the heap disappear?
   // A: because it is replaced by the last element of the heap
   //    and then sifted down
   // Q: How can I fix this

   void siftDown(int k) {
      int v, j;
      v = a[k];
      // complete yourself
      v = a[k];
      j = 2 * k;
      while (j <= N) {
         if (j < N && a[j + 1] > a[j])
            j++;
         if (v >= a[j])
            break;
         a[k] = a[j];
         k = j;
         j = 2 * k;
      }
      a[k] = v;
   }

   void insert(int x) {
      a[++N] = x;
      siftUp(N);
   }

   int remove() {
      a[0] = a[1]; // store highest priority value in a[0]
      a[1] = a[N--]; // and replace it with value from end og the heap
      siftDown(1); // and then sift this value down
      System.out.println("Removing " + a[0]);
      return a[0];
   }

   void display() {
      System.out.println("\nThe tree structure of the heaps is:");
      System.out.println(a[1]);
      for (int i = 1; i <= N / 2; i = i * 2) {
         for (int j = 2 * i; j < 4 * i && j <= N; ++j)
            System.out.print(a[j] + "  ");
         System.out.println();
      }
      System.out.println();
   }

   public static void main(String args[]) {

      Heap h = new Heap();
      int r;
      double x;

      // insert random numbers between 0 and 99 into heap
      for (int i = 1; i <= 10; ++i) {
         x = (Math.random() * 100.0);
         r = (int) x;
         System.out.println("Inserting " + r);
         h.insert(r);
         h.display();

      }
      h.remove();
      h.display();
   }

} // end of Heap class
