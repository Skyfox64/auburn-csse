// Adapted from Carrano and Savitch

   @SuppressWarnings("unchecked")
   public class HeapSort
   {
   
      public static void main (String[] args)
      {
      
         Integer[] a = {20,12,35,15,10,80,30,17,2,1};
         display(a);
         heapSort(a, a.length);
         display(a);
      
      }
   
      public static void heapSort(Comparable[] array, int n)
      {
      // create heap	
         for (int index = (n-1)/2; index >= 0; index--)
            reheap(array, index, n-1);
      	
         swap(array, 0, n-1);
      
         for (int last = n-2; last > 0; last--)
         {
            reheap(array, 0, last);
            swap(array, 0, last);		
         } // end for	
      } // end heapSort
   
   
      private static void reheap(Comparable[] heap, int first, int last) 
      {
         boolean done = false;
         Comparable orphan = heap[first];
         int largerChildIndex = 2*first+1; // index of left child, if any
         while (!done && (largerChildIndex <= last) )
         {
            int rightChildIndex = largerChildIndex + 1;
            if ( (rightChildIndex <= last) && 
               heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0 )
            {
               largerChildIndex = rightChildIndex;			
            }
         		
            if (orphan.compareTo(heap[largerChildIndex]) < 0)
            {
               heap[first] = heap[largerChildIndex];
            
               first = largerChildIndex;
               largerChildIndex = 2*first+1; // index of next left child
            } 
            else
               done = true;	
         } // end while
      
         heap[first] = orphan;
      } // end reheap
   
      private static void swap(Comparable[] a, int i, int j)
      {
         Comparable temp = a[i];
         a[i] = a[j];
         a[j] = temp; 
      } // end swap
   
      private static void display(Comparable[]a)
      {
         for (int i = 0; i < a.length; i++)
         {
            System.out.print(a[i] + " ");
         }
         System.out.println();
      }
   
   }