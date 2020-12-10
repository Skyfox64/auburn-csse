class Parent {
   public Parent() {
   
   }
}

class Child extends Parent {
   public Child() {
      super();
   }
}

public class MainClass {
   public static void main(String[] a) {
   
      Child c = new Child();
      if (c instanceof Parent) {
         System.out.println("Child c is a Parent");
      }
      
      Parent p = new Parent();
      if(p instanceof Parent) {
         System.out.println("Parent p is a Parent");
      }
   	
      if(!(p instanceof Child)) {
         System.out.println("Parent p is not a Child");
      }
   
   
   }

}