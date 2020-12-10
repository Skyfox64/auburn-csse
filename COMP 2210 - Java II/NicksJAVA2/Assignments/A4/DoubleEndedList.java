import java.util.Iterator;

/**
 * DoubleEndedList.java. Implements the behavior
 * described in DoubleEndedListInterface. In addition,
 * the following performance guarantees are provided.
 *
 * Time
 * -------------------------
 * addFirst    - O(1)
 * addLast     - O(1)
 * removeFirst - O(1)
 * removeLast  - O(1)
 * size        - O(1)
 * isEmpty     - O(1)
 * iterator    - O(1) for creation for each method on resulting iterator
 *
 * Space
 * -------------------------
 * This class uses memory proportional to the **current** size of the
 * list. That is, the amount of memory used at any point in time is
 * O(N) where N is the current size of the list. The iterators created
 * by this class must use only a constant amount of extra memory - not
 * a linear amount.
 *
 *
 * @author    NICHOLAS DICHIARA (npd0001@auburn.edu)
 * @version   2013-03-06
 *
 */
public class DoubleEndedList<T> implements DoubleEndedListInterface<T> {

   private Node<T> front; //storage
   private Node<T> end;  //sorage
   private int size = 0; //counter


   /**
    * Adds element to the front of the list. If element is null,
    * this method throws an IllegalArgumentException.
    */
   public void addFirst(T element) {
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
    * Adds element to the end of the list. If element is null,
    * this method throws an IllegalArgumentException.
    */
   public void addLast(T element) {
      if (element == null){
         throw new java.lang.IllegalArgumentException();
      }
      else{
         Node<T> n = new Node<T>(element);
         n.prev = end;
         end.setNext(n);
         end = n;
         size++;
      }
   }
      
   /**
    * Delete and return the element at the front of the list.
    * If the list is empty, this method returns null.
    */
   public T removeFirst() {
      if (size() == 0){
         return null;}
      else{
      
         T elem = front.element;
         front = front.next;
         front.setPrev(null);
         size--;
         return elem;
      }
   }
   
   /**
    * Delete and return the element at the end of the list.
    * If the list is empty, this method returns null.
    */
   public T removeLast() {
      if (size() == 0){
         return null;}
      else{
      
         T elem = end.element; //stores element
         end = end.prev; //sets end's prev as the end and unlinks end.
         end.setNext(null); //sets end's next as null
         size--; //decrements size.
         return elem; //returns element from removed node.
      }
   }

   /**
    * Returns the number of elements in this list.
    */
   public int size() {
      return size; //returns size
   }
 
   /**
    * Returns true if this list is empty, false otherwise.
    */
   public boolean isEmpty() {
      return size() == 0; //compares size to 0 and returns true if they are the same
   }
   
   /**
    * Creates and returns an iterator over the elements of this list.
    * The order of the elements returned by this iterator is sequential
    * from the front of the list to the end of the list.
    */
   public Iterator<T> iterator() {
      return new ListIterator();
   }
   
   /**
   * Defines a doubly-linked node for
   * building pointer chains.
   */
   public class Node<T> {
   
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


   private class ListIterator implements Iterator<T> {
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


