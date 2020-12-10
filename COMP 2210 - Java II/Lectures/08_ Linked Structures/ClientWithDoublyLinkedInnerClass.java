/**
 * Sample client for a doubly linked node, implememted
 * as an inner class.
 */
public class ClientWithDoublyLinkedInnerClass {
 
/**
 * Defines a doubly-linked node.
 */
   private class Node {
      private Object element;
      private Node next;
      private Node prev;
      
      public Node(Object e) {
         element = e;
      }
   }
   
  /**
   * Call a method to perform example operations on nodes.
   */ 
   public static void main(String[] args) {
   
      ClientWithDoublyLinkedInnerClass client = new ClientWithDoublyLinkedInnerClass();
      client.basicExamples();
   }
   
  /**
   * Creates the examples from lecture notes.
   */ 
   public void basicExamples() {
   
   // Declaration;
      Node n;
      Node m;
      
   // Constructor, garbage
      n = new Node(1);
      m = new Node(2);
      m.prev = n;
      n.next = m;
      n = new Node(3);
      System.out.println("n -> " + asString(n));
      System.out.println("m -> " + asString(m));
      n = null;
      System.out.println("n -> " + asString(n));
      
   // basic linking   
      n = new Node("A");
      m = new Node("B");
      n.next = m;
      m.prev = n;
      m.next = new Node("C");
      m = m.next;
      m.prev = n.next;
      Node x = m;
      m.next = new Node("D");
      m = m.next;
      m.prev = x;
      x.next = m;
      
      
   }
   
  /**
   * Returns a string representation of the pointer chain accessible
   * from n.
   */ 
   public String asString(Node n) {
      if (n == null)
         return "NULL";
   
      StringBuffer s = new StringBuffer();
      Node p = n;
      while (p != null) {
         s.append(p.element);
         s.append(" <-> ");
         p = p.next;
      }
      s.delete(s.length()-4, s.length());
      return s.toString();
   }
	
  /**
   * Returns the number of nodes accessible from n, in the forward direction.
   */ 
   public int length(Node n) {
      Node p = n;
      int len = 0;
      while (p != null) {
         len++;
         p = p.next;
      }
      return len;
   }
   
  /**
   * Searches for target in the pointer chain accessible from n, in the forward direction.
   */ 
   public boolean contains(Node n, Object target) {
      Node p = n;
      while (p != null) {
         if (p.element.equals(target)) {
            return true;
         }
         p = p.next;
      }
      return false;
   }
	 
}