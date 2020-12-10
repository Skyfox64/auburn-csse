
/** 
 * Example of a doubly-linked pointer chain built using a
 * private nested class Node.
 * 
 */
public class DoublyLinkedLab {
 
 /**
  * Build a doubly-linked pointer chain.
  */
   public static void main(String[] args) {
   
   // Since the Node class is a member of the DoublyLinkedLab class,
   // we can directly access the Node fields and therefore don't need
   // getter and setter methods.
   
      Node n = new Node(1, null, null);
      n.next = new Node(2, null, n);
      n.next.next = new Node(3, new Node(5, null, null), n.next);
   
   // There's a link missing in the pointer chain.
   // Add a statement below that creates the appropriate link.
   
      addAfter(n.next.next, 4);
   
   }
   
 /** 
  * Adds a new node containing e after the node
  * referenced by n in a doubly-linked pointer chain.
  */  
   private static void addAfter(Node n, Object e) {
   // Try to write this on your own. If you get stuck,
   // you can look a the solution below.
   
   }
 
 
 /**
  * Defines a doubly-linked node for
  * building pointer chains.
  */
   private static class Node {
   
      private Object element;  // data stored in the node
      private Node next;       // reference to the node after this one, if any
      private Node prev;       // reference to the node before this one, if any
   
      public Node(Object e, Node n, Node p) {
         element = e;
         next = n;
         prev = p;
      }
   
   }
   
   
 /** 
  * Try it on your own before you look here. You could shorten this,
  * but I made the solution as step-by-step as possible so you can
  * see exactly what's happening.
  */  
   private static void addAfterSolution(Node n, Object e) {
     // allocate a new node with e as its element
      Node m = new Node(e, null, null);
      
      // set m's links to point into the existing chain
      m.next = n.next;
      m.prev = n;
      
      // make the existing nodes point to m
      n.next.prev = m;
      n.next = m;
   }
 
}