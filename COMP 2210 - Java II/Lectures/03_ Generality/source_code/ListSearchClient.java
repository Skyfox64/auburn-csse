   import java.util.List;
   import java.util.LinkedList;
   import java.util.ArrayList;
   import java.util.Arrays;

   public class ListSearchClient
   {
   /**
    * Illustrates basic calls to search method.
    *
    * @param args Command line arguments not used.
    *
    */ 
      public static void main(String[] args) 
      {
      
         {
            String target1 = "blue";
         
            List<String> list1 = Arrays.asList("red", "orange", "yellow", "green", 
                        "blue", "indigo", "violet");
         
            System.out.println(
               ListSearchClass.<String>searchA(list1, target1)
               );
         
            System.out.println(
               ListSearchClass.<String>searchB(list1, target1)
               );
         
         
         }
       
         {  
            Integer target2 = 8;
         
            List<Integer> list2 = new LinkedList<Integer>();
            list2.add(2);
            list2.add(4);
            list2.add(6);
            list2.add(8);
            list2.add(10);
         
            System.out.println(
               ListSearchClass.<Integer>searchA(list2, target2)
               );
               
            System.out.println(
               ListSearchClass.<Integer>searchB(list2, target2)
               );
         
         }
        
         {
         
            List<Comparable> list3 = new ArrayList<Comparable>(5);
            list3.add("red");
            list3.add(15);
            list3.add("blue");
         
            String target3 = "blue";
         
            System.out.println(ListSearchClass.<Comparable>searchA(list3, target3));
            System.out.println(ListSearchClass.<Comparable>searchB(list3, target3));
         
         
         }
      
         {
         
            List list4 = new ArrayList(5);
            list4.add("red");
            list4.add(new Book("Lewis", "Perelandra", 256));
            list4.add(15);
         
            String target4 = "blue";
         
            System.out.println(ListSearchClass.searchA(list4, target4));
            System.out.println(ListSearchClass.searchB(list4, target4));
         
         
         }
      }
   
   }