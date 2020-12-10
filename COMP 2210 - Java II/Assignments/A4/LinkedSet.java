import java.util.Iterator;
import java.util.NoSuchElementException;
 
/**
 * Provides an implementation of the Set interface. 
 * A doubly-linked list is used as the underlying data structure.
 * Although not required by the Set interface, this linked list
 * is maintained in ascending natural order. Where possible, methods
 * take advantage of the implementation in the interest of efficiency.
 * Methods that take LinkedSets as parameters are specifically 
 * designed to take advantage of the underlying implementation. 
 *
 * @param	<T>	type of elements in this collection
 *
 * @author	John Carroll (jcc0044@auburn.edu)
 * @version	03-20-2014
 * 
 */
public class LinkedSet<T extends Comparable<? super T>> implements Set<T> {

/**
 * DO NOT CHANGE THIS INNER CLASS
 */
   public class Node {
      public T element;
      public Node next;
      public Node prev;
   
      public Node() {
         element = null;
         next = null;
         prev = null;
      }
   
      public Node(T e) {
         element = e;
         next = null;
         prev = null;
      }
   }

// instance varaibles
   public Node front;
   public Node rear;
   public int size;

/**
 * Instantiates an empty set.
 * DO NOT CHANGE THIS CONSTRUCTOR
 */
   public LinkedSet() {
      front = null;
      rear = null;
      size = 0;
   }
   
   /**
    * Add method.
    */
   public boolean add(T element) {
      if (element == null) {
         return false;
      } 
      Node newNode = new Node(element);
      Iterator<T> itr = descendingIterator();
      if (front == null) {
         front = newNode;
         rear = newNode;
         size++;
         return true;
      }
      Node n = rear;
      while (itr.hasNext()) {
         T temp = itr.next();
         if (setEquals(temp, element)) {
            return false;
         }
         if (0 > temp.compareTo(element) && !setEquals(temp, element)) {
            newNode.next = n.next;
            newNode.prev = n;
            n.next = newNode;
            if (newNode.next != null) {
               newNode.next.prev = newNode;
            }
            if (newNode.next == null) {
               rear = newNode;
               size++;
               return true;
            }
            size++;
            return true;
         }
      
         n = n.prev;
         if (n == null) {
            newNode.next = front;
            front = newNode;
            size++;
            if (newNode.next != null) {
               newNode.next.prev = newNode;
            }
         }
      }
      return false;
   }
   
   /**
    * method to remove an element from the collection
    */
   public boolean remove(T element) {
      if (isEmpty()) {
         return false;
      }
      Node p = front;
      Node prev = null;
      while ((p != null) && (!p.element.equals(element))) {
         prev = p;
         p = p.next;
      }
      if (p != null) {
         if (p == front) {
            front = front.next;
            front.prev = null;
         }
         else if (p == rear) {
            rear = rear.prev;
            rear.next = null;
         }
         else {
            prev.next = p.next;
            prev.next.prev = p.prev;
         }
         size--;
         return true;
      }
      return false;
   }
   
   /**
    * method to check if collection contains an element
    */
   public boolean contains(T element) {
      Node p = front;
      while (p != null) {
         if (p.element.equals(element)) {
            return true;
         }
         p = p.next;
      }
      return false;
   }
   
/**
 * DO NOT CHANGE THE SIZE METHOD
 */
   public int size() {
      return size;
   }

/**
 * DO NOT CHANGE THE ISEMPTY METHOD
 */
   public boolean isEmpty() {
      return size == 0;
   }
   
  /**
   * Iterator Method.
   */
   public Iterator<T> iterator() {
      Iterator<T> itr = 
         new Iterator<T>() {
            private Node current = front;
            public void remove()
            {
               throw new UnsupportedOperationException();
            }
            
            public boolean hasNext() {
               return current != null && !isEmpty();
            }
         
            public T next()
            {
               if (!hasNext()) {
                  throw new NoSuchElementException();
               }
               T result = current.element;
               current = current.next;
               return result;
            }
         };
      
      return itr;
   
   }
   
   /**
    * descendingIterator method.
    */
   public Iterator<T> descendingIterator() {
      Iterator<T> itr = 
         new Iterator<T>() {
            private Node current = rear;
            
            public void remove()
            {
               throw new UnsupportedOperationException();
            }
         
            public boolean hasNext() {
               return current != null;
            }
         
            public T next()
            {
               if (!hasNext()) {
                  throw new NoSuchElementException();
               }
               T result = current.element;
               current = current.prev;
               return result;
            }
         };
      
      return itr;
   }   
  
   /**
    * powerSetIterator method.
    */
   public Iterator<Set<T>> powerSetIterator() {
      Iterator<Set<T>> itr = 
         new Iterator<Set<T>>() {
            int count = 0;
            int size = expBinary(2, size());
            int b = size /2;
            Node i = front;
         
            public boolean hasNext() {
               return count < size;
            }
            public Set<T> next() {
               int a = count;
               int d = b;
               Set<T> b = new LinkedSet<>();
               if (this.hasNext()) {
                  while (a > 0) {
                     if (a/d == 1) {
                        b.add(i.element);
                     }
                     a = a % d;
                     d = d / 2;
                     i = i.next;
                  }
                  while (d > 0) {
                     i = i.next;
                     d = d / 2;
                  }
                  count++;
                  i = front;
                  return b;
               }
               else {
                  throw new NoSuchElementException();
               }
            }
            public void remove() {
            }
         };
      return itr;
   }
   
   /**
    * equals Set<T> method.
    */
   public boolean equals(Set<T> ls) {
      if (this.size() != ls.size()) {
         return false;
      }
      Iterator<T> itr = ls.iterator();
      
      while (itr.hasNext()) {
         T current = itr.next();
         if (!this.contains(current)) {
            return false;
         }
      }
      return true;
   }
   
   /**
    * equals LinkedSet<T> method.
    */
   public boolean equals(LinkedSet<T> s) {
      if (this.size() != s.size()) {
         return false;
      }
      Node current = s.front;
      
      while (current != null) {
         if (!this.contains(current.element)) {
            return false;
         }
         current = current.next;
      }
      return true;
   }
   
    /**
    * union Set<T> method.
    */
   public Set<T> union(Set<T> s) {
      Set<T> newSet = this;
      Iterator<T> itr = s.iterator();
      
      while (itr.hasNext()) {
         T temp = itr.next();
         newSet.add(temp);
      }
      return newSet;
   }
   
   /**
    * union LinkedSet<T> method.
    */
   public Set<T> union(LinkedSet<T> s) {
      Set<T> newLinkedSet = this;
      Node current = s.front;
      
      while (current != null) {
         newLinkedSet.add(current.element);
         current = current.next;
      }
      return newLinkedSet;
   }
    
    /**
     * intersection Set<T> method
     */  
   public Set<T> intersection(Set<T> s) {
      Set<T> returned = new LinkedSet<T>();
      Iterator<T> itr = s.iterator();
      
      while (itr.hasNext()) {
         T temp = itr.next();
         if (this.contains(temp)) {
            returned.add(temp);
         }
      }
      return returned;
   }
   
   /**
    * intersection LinkedSet<T> method
    */
   public Set<T> intersection(LinkedSet<T> s) {
      Set<T> returned = new LinkedSet<T>();
      Node current = s.front;
      
      while (current != null) {
         if (this.contains(current.element)) {
            returned.add(current.element);
         }
         current = current.next;
      }
      return returned;
   }
   
   /**
    * complement Set<T> method
    */
   public Set<T> complement(Set<T> s) {
      if (s == null) {
         return this;
      }
      Set<T> returned = new LinkedSet<T>();
      Iterator<T> itr = this.iterator();
      
      while (itr.hasNext()) {
         T temp = itr.next();
         if (!s.contains(temp)) {
            returned.add(temp);
         }
      }
      return returned;
   }
   
   /**
    * complement LinkedSet<T> method
    */
   public Set<T> complement(LinkedSet<T> s) {
      if (s == null) {
         return this;
      }
      Set<T> returned = new LinkedSet<T>();
      Node current = this.front;
      
      while (current != null) {
         if (!s.contains(current.element)) {
            returned.add(current.element);
         }
         current = current.next;
      }
      return returned;
   }
  
/**
 * Creates a string representation of this collection.
 * 
 * @return	string representation of this collection.
 *
 */
   @Override public String toString() {
      if (isEmpty()) {
         return "[]";
      }
      StringBuilder result = new StringBuilder();
      result.append("[");
      Node n = front;
      while (n != null) {
         result.append(n.element + ", ");
         n = n.next;
      }
      result.delete(result.length() - 2, result.length());
      result.append("]");
      return result.toString();
   }
   
   /**
    * created setEquals method
    */
   boolean setEquals(T a, T b) {
      return a.compareTo(b) == 0;
   }
  
  /**
   * expBinary method
   */
   public static int expBinary(int x, int n) {
      int term = x;
      int p = 1;
      while(n > 0) {
         if ((n % 2) == 1) {
            p *= term;
         }
         term *= term;
         n = n / 2;
      }
      return p;
   }

}