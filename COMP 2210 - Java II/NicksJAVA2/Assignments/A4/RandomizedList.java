import java.util.Iterator;

/**
 * RandomizedList.java. Implements the behavior
 * described in RandomizedListInterface. In addition,
 * the following performance guarantees are provided.
 *
 * Time
 * -------------------------
 * add      - O(1) amortized 
 * remove   - O(1) amortized
 * sample   - O(1)
 * size     - O(1)
 * isEmpty  - O(1)
 * iterator - O(N) creation; O(1) for each method on resulting iterator
 *
 * Space
 * -------------------------
 * This class uses memory proportional to the **current** size of the
 * list. That is, the amount of memory used at any point in time is
 * O(N) where N is the current size of the list. This class can use up
 * to a linear amount of extra memory per iterator.
 *
 *
 * @author    Nicholas DiChiara (npd0001@auburn.edu)
 * @author    Dean Hendrix (dh@auburn.edu)
 * @version   2013-03-6
 *
 */
public class RandomizedList<T> implements RandomizedListInterface<T> {
 
   private Node<T> front; //storage
   private Node<T> end; //storage
   private int size = 0; //counter
 
   /**
    * Adds an element to this list. If element is null, this method
    * throws an IllegalArgumentException.
    */
   public void add(T element) {
      if (element == null){
         throw new java.lang.IllegalArgumentException();
      }
      else{ //only continues if element is not equal to null
         Node<T> n = new Node<T>(element); //new node creation
         if(isEmpty()) { //if this is the first node created
            front = n; //set itself to front
            end = n; //set itself to end
         }
         n.setNext(front); //set newly created node to new front
         n.next.setPrev(n); //set old front's previous to the new node
         front = n; //name new front node as front
         size++; //increment size counter 
      }
   }
  
   /**
    * Selects and removes an element selected uniformly at random
    * from the elements currently in the list. If the list is empty
    * this method returns null.
    */
   public T remove() {
      if (size() == 0){
         return null;}
      else{
         Node<T> r = null;
         T elem;
         int rando = (1 + (int)(Math.random()*size()));
      
         if (rando == 1){
            elem = front.element;
            front = front.next;
            front.setPrev(null);
         }
         else{
            Node<T> n = front;
            for (int i=1; i< rando; i++){
               n = n.next;
               r = n;
            }
         
            if (r == end){
               elem = end.element;
               end = end.prev; //sets end's prev as the end and unlinks end.
               end.setNext(null); //sets end's next as null
            }
            else{
               elem = r.element;
               r.prev.setNext(r.next);
               r.next.setPrev(r.prev);
               r.setNext(null);
               r.setPrev(null);
               
            }  
         }           
         size--;
         return elem;
      }
   }
   
   /**
    * Selects but does not remove an element selected uniformly at random
    * from the elements currently in the list. If the list is empty
    * this method return null.
    */
   public T sample() {
      if (size() == 0){
         return null;}
      else{
         Node<T> r = null;
         int rando = (1 + (int)(Math.random()*size()));
      
         if (rando == 1){
            return front.element;
         }
         else{
            Node<T> n = front;
            for (int i=1; i< rando; i++){
               n = n.next;
               r = n;
            }
         
            return r.element;
         }  
      }
   }
   
   /**
    * Returns the number of elements in this list.
    */
   public int size() {
      return size;
   }
 
   /**
    * Returns true if this list is empty, false otherwise.
    */
   public boolean isEmpty() {
      return size() == 0;
   }
   
   /**
    * Creates and returns an iterator over the elements of this list.
    * The order of the elements returned by this iterator is random and
    * is independent of any other iterator created on the list.
    */
   public Iterator<T> iterator() {
      add(remove());
      return new RandomIterator();
   }
 
 /**
   * Defines a doubly-linked node for
   * building pointer chains.
   */
   private class Node<T> {
   
      private T element;  // data stored in the node
      private Node<T> next;  // reference to the node after this one, if any
      private Node<T> prev; //reference to the node before this one, if any
   
      public Node(T e) {
         element = e; //sets param e to the nodes element
         next = null; //next points to the next node
      }
   
      public void setNext(Node<T> n) {
         next = n; //sets the passed in param as the next node
      }
      
      public void setPrev(Node<T> n){
         prev = n; //sets the passed in param as the prev node
      }
   } 
   
   private class RandomIterator implements Iterator<T> {
      private Node<T> current = front;
      
      public boolean hasNext() {
         return current != null;
      }
      
      public T next() {
         if (!hasNext())
            throw new java.util.NoSuchElementException();
         
         T result = current.element;
         current = current.next;
         return result;
      }
         
      public void remove() {
         throw new UnsupportedOperationException();
      }
      
   }
}