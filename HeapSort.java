// HEAPSORT(A)
// 1  BUILD-MAX-HEAP(A)
// 2  for i = A.length downto 2
// 3      exchange A[1] with A[i]
// 4      A.heap-size = A.heap-size - 1
// 5      MAX-HEAPIFY(A, 1)
// BUILD-MAX-HEAP(A)
// 1  A.heap-size = A.length
// 2  for i = floor(A.length/2) downto 1
// 3      MAX-HEAPIFY(A, i)
// MAX-HEAPIFY(A, i)
// 1  l = LEFT(i)
// 2  r = RIGHT(i)
// 3  if l <= A.heap-size and A[l] > A[i]
// 4      largest = l
// 5  else largest = i
// 6  if r <= A.heap-size and A[r] > A[largest]
// 7      largest = r
// 8  if largest != i
// 9      exchange A[i] with A[largest]
// 10     MAX-HEAPIFY(A, largest)



class HeapSort {

// used to reform the shrinking heap when
// the largest value is removed.
// N = heap size, a[N-1] is last value on heap

public static void BuildHeap(int a[], int N) {
   int i;
   i  = a.length/2;
}

// public static void  HeapSortRec(int a[], int n) 

public  static void siftDown( int a[], int k, int N) {
   int v, j;

   v = a[k];
   j = 2*k+1;          // j is position of leftchild of k
   while( j <= N-1) {  // make sure leftchild of k is within the heap
      if(j < N-1 && a[j] < a[j+1]) 
            ++j;
      if( v >= a[j]) 
            break;
      a[k] = a[j];
      k = j;
      j = 2*k + 1;      
   }
   a[k] = v;
}


// in this version, it is assumed the array
// values are a[0] to a[n-1]. Then
// leftChild(k) = 2k+1, nrightChild(k) = 2k + 2
// parent(k) = (k-1)/2

public static void heapSort(int a[], int n)
{
   int k, v;

  // first convert array into heap
   for(k = (n-2)/2; k >= 0; --k)  // parent of last leaf  a[n-1]
      siftDown(a, k, n);     // is at (n-1-1)/2 = n/2 -1

   // repeatedly remove largest value from heap,
   // place in position freed by heap.
   for(k = n-1; k > 0; --k) {
      v = a[0];
      a[0] = a[k];
      siftDown( a, 0, k); // k new heap size
      a[k] = v;
   }
}




public static void main(String arg[])
{
    int a[];
    int N = 10;
    a = new int[N];

    int i;

    // insert 10 random number between 0 and 99 into array
    for(i = 0; i < N; ++i)
       a[i] = (int) (Math.random()*100.0);

    System.out.println( "\nUnsorted array is:\n");
    for(i = 0; i < N; ++i)
        System.out.print("  "  + a[i]);

    HeapSort.heapSort( a, N);

    System.out.println( "\nSorted array is:\n");
    for(i = 0; i < N; ++i)
        System.out.print("  "  + a[i]);
}

}